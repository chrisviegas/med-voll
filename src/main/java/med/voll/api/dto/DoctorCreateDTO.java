package med.voll.api.dto;

import med.voll.api.entities.Doctor;
import med.voll.api.enums.DoctorSpecialtyEnum;

public record DoctorCreateDTO(String name, String email, String phone, String crm, DoctorSpecialtyEnum doctorSpecialtyEnum, AddressDTO address) {

    public DoctorCreateDTO(Doctor doctor) {
        this(doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(), doctor.getDoctorSpecialtyEnum(), new AddressDTO(doctor.getAddress()));
    }
}
