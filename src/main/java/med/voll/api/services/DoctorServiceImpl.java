package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository repository) {
        this.repository = repository;
    }

    @Transactional
    @Override
    public DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO) {
        Doctor doctor = repository.save(new Doctor(doctorCreateDTO));
        return new DoctorCreateDTO(doctor);
    }

    @Transactional(readOnly = true)
    @Override
    public Page<DoctorGetMinDTO> getAll(int page, int size, Sort sort) {
        return repository.findAll(PageRequest.of(page, size, sort)).map(DoctorGetMinDTO::new);
    }
}
