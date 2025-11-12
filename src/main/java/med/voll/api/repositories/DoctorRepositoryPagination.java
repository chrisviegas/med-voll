package med.voll.api.repositories;

import med.voll.api.entities.Doctor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DoctorRepositoryPagination extends PagingAndSortingRepository<Doctor, Long> {
}
