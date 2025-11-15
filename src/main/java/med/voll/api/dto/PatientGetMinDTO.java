package med.voll.api.dto;

import med.voll.api.entities.Patient;

public record PatientGetMinDTO(Long id, String name, String email, String cpf) {

    public PatientGetMinDTO(Patient patient) {
        this(patient.getId(), patient.getName(), patient.getEmail(), patient.getCpf());
    }
}
