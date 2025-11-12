package med.voll.api.dto;

import med.voll.api.entities.Patient;

public record PatientCreateDTO(String name, String email, String phone, String cpf, AddressDTO address) {
    public PatientCreateDTO(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getPhone(), patient.getCpf(), new AddressDTO(patient.getAddress()));
    }
}
