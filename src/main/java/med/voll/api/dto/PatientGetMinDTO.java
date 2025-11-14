package med.voll.api.dto;

import med.voll.api.entities.Patient;

public record PatientGetMinDTO(String name, String email, String cpf) {

    public PatientGetMinDTO(Patient patient) {
        this(patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
