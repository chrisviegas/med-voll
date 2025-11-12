package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService doctorService) {
        this.service = doctorService;
    }

    @PostMapping("/register")
    public DoctorCreateDTO create(@RequestBody @Valid DoctorCreateDTO doctorCreateDTO) {
        return service.create(doctorCreateDTO);
    }

    @GetMapping
    public List<DoctorGetMinDTO> getAll() {
        return service.getAll();
    }
}
