package med.voll.api.services;

import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface DoctorService {

    DoctorDTO create(DoctorDTO doctorDTO);

    Page<DoctorGetMinDTO> getAll(int page, int size, Sort sort);

    DoctorDTO update(Long id,DoctorUpdateDTO dto);

    void delete(Long id);
}
