package med.voll.api.services;

import med.voll.api.dto.AddressDTO;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import med.voll.api.entities.Address;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Primary
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public DoctorDTO create(DoctorDTO doctorDTO) {
        Doctor doctor = repository.save(new Doctor(doctorDTO));
        return new DoctorDTO(doctor);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<DoctorGetMinDTO> getAll(int page, int size, Sort sort) {
        return repository.findAllByIsActiveTrue(PageRequest.of(page, size, sort)).map(DoctorGetMinDTO::new);
    }

    @Transactional
    @Override
    public DoctorDTO update(Long id, DoctorUpdateDTO dto) {
        Doctor doctor = repository.getReferenceById(id);

        Optional.ofNullable(dto.name()).ifPresent(doctor::setName);
        Optional.ofNullable(dto.phone()).ifPresent(doctor::setPhone);
        Optional.ofNullable(dto.address())
                .ifPresent(addressDto -> updateAddress(doctor.getAddress(), addressDto));

        return new DoctorDTO(doctor);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Doctor doctor = repository.getReferenceById(id);
        doctor.setActive(false);
    }

    private void updateAddress(Address address, AddressDTO dto) {
        Optional.ofNullable(dto.street()).ifPresent(address::setStreet);
        Optional.ofNullable(dto.number()).ifPresent(address::setNumber);
        Optional.ofNullable(dto.complement()).ifPresent(address::setComplement);
        Optional.ofNullable(dto.neighborhood()).ifPresent(address::setNeighborhood);
        Optional.ofNullable(dto.city()).ifPresent(address::setCity);
        Optional.ofNullable(dto.state()).ifPresent(address::setState);
        Optional.ofNullable(dto.zip()).ifPresent(address::setZip);
    }
}
