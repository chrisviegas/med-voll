package med.voll.api.services;

import med.voll.api.dto.PatientDTO;
import med.voll.api.dto.PatientGetMinDTO;
import med.voll.api.dto.PatientUpdateDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface PatientService {

    PatientDTO create(PatientDTO dto);

    Page<PatientGetMinDTO> getAll(int page, int size, Sort sort);

    PatientDTO update(Long id, PatientUpdateDTO updateDTO);
}
