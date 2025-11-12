package med.voll.api.services;

import med.voll.api.dto.PatientCreateDTO;

public interface PatientService {

    PatientCreateDTO create(PatientCreateDTO dto);
}
