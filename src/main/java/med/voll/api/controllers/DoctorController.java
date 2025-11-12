package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.services.DoctorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @PostMapping("/register")
    public DoctorCreateDTO create(@RequestBody @Valid DoctorCreateDTO doctorCreateDTO) {
        return doctorService.create(doctorCreateDTO);
    }
}
