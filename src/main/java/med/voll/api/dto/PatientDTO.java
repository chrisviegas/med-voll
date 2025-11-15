package med.voll.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.entities.Patient;

public record PatientDTO(

        @NotBlank
        String name,

        @NotBlank
        String email,

        @NotBlank
        String phone,

        @NotBlank
        String cpf,

        @Valid
        AddressDTO address
) {

    public PatientDTO(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), new AddressDTO(patient.getAddress()));
    }
}
