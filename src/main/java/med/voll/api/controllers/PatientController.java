package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.PatientCreateDTO;
import med.voll.api.dto.PatientGetMinDTO;
import med.voll.api.repositories.PatientRepository;
import med.voll.api.services.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public PatientCreateDTO create(@RequestBody @Valid PatientCreateDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public Page<PatientGetMinDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size, Sort sort) {
        return service.getAll(page, size, sort);
    }
}
