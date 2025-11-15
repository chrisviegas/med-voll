package med.voll.api.dto;

import med.voll.api.entities.Patient;

public record PatientUpdateDTO(
        String name,
        String phone,
        AddressDTO address
) {
    public PatientUpdateDTO(Patient patient) {
        this(patient.getName(), patient.getPhone(), new AddressDTO(patient.getAddress()));
    }

}
