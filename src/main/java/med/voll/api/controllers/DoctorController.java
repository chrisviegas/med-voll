package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import med.voll.api.services.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService doctorService) {
        this.service = doctorService;
    }

    @PostMapping("/register")
    public DoctorDTO create(@RequestBody @Valid DoctorDTO doctorDTO) {
        return service.create(doctorDTO);
    }

    @GetMapping
    public Page<DoctorGetMinDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue= "10") int size, Sort sort) {
        return service.getAll(page, size, sort);
    }

    @PatchMapping("/{id}")
    public DoctorDTO update(@PathVariable Long id, @RequestBody @Valid DoctorUpdateDTO dto) {
        return service.update(id, dto);
    }


}
