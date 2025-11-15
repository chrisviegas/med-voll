package med.voll.api.entities;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.enums.DoctorSpecialtyEnum;

@Entity
@Table(name = "tb_doctor")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private boolean isActive = true;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
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

    public Doctor(DoctorDTO doctorDTO) {
        this.name = doctorDTO.name();
        this.email = doctorDTO.email();
        this.phone = doctorDTO.phone();
        this.crm = doctorDTO.crm();
        this.doctorSpecialtyEnum = doctorDTO.specialty();

        if (doctorDTO.address() != null) {
            this.address = new Address(doctorDTO.address());
        }
    }
}
