package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Primary
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.repository = doctorRepository;
    }

    @Transactional
    @Override
    public DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO) {
        Doctor doctor = repository.save(new Doctor(doctorCreateDTO));
        return new DoctorCreateDTO(doctor);
    }

    @Transactional(readOnly = true)
    @Override
    public List<DoctorGetMinDTO> getAll() {
        return repository.findAll().stream().map(DoctorGetMinDTO::new).toList();
    }
}
