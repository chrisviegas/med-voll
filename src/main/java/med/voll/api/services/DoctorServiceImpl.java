package med.voll.api.services;

import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.entities.Doctor;
import med.voll.api.repositories.DoctorRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.Doc;
import javax.swing.*;

@Service
@Primary
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Transactional
    @Override
    public DoctorCreateDTO create(DoctorCreateDTO doctorCreateDTO) {
        Doctor doctor = doctorRepository.save(new Doctor(doctorCreateDTO));
        return new DoctorCreateDTO(doctor);
    }
}
