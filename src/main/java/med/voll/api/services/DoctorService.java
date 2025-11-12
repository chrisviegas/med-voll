package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import org.springframework.data.domain.Page;

public interface DoctorService {

    DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO);

    Page<DoctorGetMinDTO> getAll(int page, int size);
}
