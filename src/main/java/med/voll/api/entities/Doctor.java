package med.voll.api.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.enums.DoctorSpecialtyEnum;

@Entity
@Table(name = "tb_doctor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private String phone;

    @NotBlank
    @Column(nullable = false)
    private String crm;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialty", nullable = false)
    private DoctorSpecialtyEnum doctorSpecialtyEnum;

    @Embedded
    @Valid
    @NotNull
    @Column(nullable = false)
    private Address address;

    public Doctor(DoctorCreateDTO doctorCreateDTO) {
        this.name = doctorCreateDTO.name();
        this.email = doctorCreateDTO.email();
        this.phone = doctorCreateDTO.phone();
        this.crm = doctorCreateDTO.crm();
        this.doctorSpecialtyEnum = doctorCreateDTO.doctorSpecialtyEnum();

        if (doctorCreateDTO.address() != null) {
            this.address = new Address(doctorCreateDTO.address());
        }
    }
}
