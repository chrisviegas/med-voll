package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.PatientCreateDTO;
import med.voll.api.repositories.PatientRepository;
import med.voll.api.services.PatientService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository repository;
    private final PatientService service;

    public PatientController(PatientRepository repository, PatientService service) {
        this.repository = repository;
        this.service = service;
    }

    @PostMapping("/register")
    public void create(@RequestBody @Valid PatientCreateDTO dto) {
        service.create(dto);
    }
}
