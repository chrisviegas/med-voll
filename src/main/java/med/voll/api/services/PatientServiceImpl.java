package med.voll.api.services;

import jakarta.persistence.EntityNotFoundException;
import med.voll.api.dto.PatientDTO;
import med.voll.api.dto.PatientGetMinDTO;
import med.voll.api.dto.PatientUpdateDTO;
import med.voll.api.entities.Patient;
import med.voll.api.repositories.PatientRepository;
import med.voll.api.services.util.AddressUpdateHelper;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Primary
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public PatientDTO create(PatientDTO dto) {
        Patient patient = repository.save(new Patient(dto));
        return new PatientDTO(patient);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<PatientGetMinDTO> getAll(int page, int size, Sort sort) {
        return repository.findAllByIsActiveTrue(PageRequest.of(page, size, sort)).map(PatientGetMinDTO::new);
    }

    @Override
    @Transactional
    public PatientDTO update(Long id, PatientUpdateDTO dto) {
        Patient patient = repository.getReferenceById(id);

        Optional.ofNullable(dto.name()).ifPresent(patient::setName);
        Optional.ofNullable(dto.phone()).ifPresent(patient::setPhone);
        Optional.ofNullable(dto.address())
                .ifPresent(addressDto -> AddressUpdateHelper.updateAddress(patient.getAddress(), addressDto));

        return new PatientDTO(patient);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Patient patient = repository.getReferenceById(id);
        patient.setActive(false);
    }

    @Override
    @Transactional(readOnly = true)
    public PatientDTO getById(Long id) {
        return repository.findById(id).map(PatientDTO::new)
        .orElseThrow(() -> new EntityNotFoundException("Patient not found"));
    }

}

