package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface DoctorService {

    DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO);

    Page<DoctorGetMinDTO> getAll(int page, int size, Sort sort);
}
