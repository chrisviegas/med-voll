package med.voll.api.dto;

import med.voll.api.entities.Doctor;
import med.voll.api.enums.DoctorSpecialtyEnum;

public record DoctorGetMinDTO(String name, String email, String crm, DoctorSpecialtyEnum specialty){

    public DoctorGetMinDTO(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getCrm(), doctor.getDoctorSpecialtyEnum());
    }
}
