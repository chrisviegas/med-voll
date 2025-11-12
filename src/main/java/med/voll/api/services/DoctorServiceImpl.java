package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import med.voll.api.repositories.DoctorRepositoryPagination;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Primary
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepositoryPagination repositoryPagination;
    private final DoctorRepository repository;

    public DoctorServiceImpl(DoctorRepositoryPagination repositoryPagination, DoctorRepository repository) {
        this.repositoryPagination = repositoryPagination;
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
    public Page<DoctorGetMinDTO> getAll(int page, int size) {
        return repositoryPagination.findAll(PageRequest.of(page, size)).map(DoctorGetMinDTO::new);
    }
}
