package med.voll.api.services;

import med.voll.api.dto.PatientCreateDTO;
import med.voll.api.dto.PatientGetMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

public interface PatientService {

    PatientCreateDTO create(PatientCreateDTO dto);

    Page<PatientGetMinDTO> getAll(int page, int size, Sort sort);
}
