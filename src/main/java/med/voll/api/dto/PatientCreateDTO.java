package med.voll.api.dto;

public record PatientCreateDTO(String name, String email, String phone, String cpf, AddressDTO address) {
}
