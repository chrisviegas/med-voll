package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import med.voll.api.entities.Doctor;
import med.voll.api.enums.DoctorSpecialtyEnum;

public record DoctorDTO(

        Long id,

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String phone,

        @NotBlank
        String crm,

        @NotNull
        DoctorSpecialtyEnum specialty,

        @Valid
        AddressDTO address) {

    public DoctorDTO(Doctor doctor) {
        this(doctor.getId(),doctor.getName(), doctor.getEmail(), doctor.getPhone(), doctor.getCrm(),
                doctor.getDoctorSpecialtyEnum(), new AddressDTO(doctor.getAddress()));
    }
}
