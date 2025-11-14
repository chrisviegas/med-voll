package med.voll.api.dto;

import med.voll.api.entities.Doctor;

public record DoctorUpdateDTO(String name, String phone, AddressDTO address) {

    public DoctorUpdateDTO (Doctor doctor) {
        this(doctor.getName(), doctor.getPhone(), new AddressDTO(doctor.getAddress()));
    }

}