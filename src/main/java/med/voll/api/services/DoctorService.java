package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;

public interface DoctorService {

    DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO);
}
