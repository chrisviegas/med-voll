package med.voll.api.dto;

import med.voll.api.enums.DoctorSpecialtyEnum;

public record DoctorCreateDTO(String name, String email, String phone, String crm, DoctorSpecialtyEnum doctorSpecialtyEnum, AddressDTO address) {

}
