package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorCreateDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.services.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

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
    public Page<DoctorGetMinDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue= "10") int size) {
        return service.getAll(page, size);
    }
}
