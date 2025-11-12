package med.voll.api.services;

import med.voll.api.dto.PatientCreateDTO;
import med.voll.api.entities.Patient;
import med.voll.api.repositories.PatientRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class PatientServiceImpl implements PatientService {

    private final PatientRepository repository;

    public PatientServiceImpl(PatientRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void create(PatientCreateDTO dto) {
        repository.save(new Patient(dto));
    }
}
