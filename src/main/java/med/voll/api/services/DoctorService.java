package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;

import java.util.List;

public interface DoctorService {

    DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO);

    List<DoctorGetMinDTO> getAll();
}
