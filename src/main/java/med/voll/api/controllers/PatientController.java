package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.PatientDTO;
import med.voll.api.dto.PatientGetMinDTO;
import med.voll.api.dto.PatientUpdateDTO;
import med.voll.api.services.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public PatientDTO create(@RequestBody @Valid PatientDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public Page<PatientGetMinDTO> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size, Sort sort) {
        return service.getAll(page, size, sort);
    }

    @PatchMapping("/{id}")
    public PatientDTO update(@PathVariable Long id, @RequestBody @Valid PatientUpdateDTO updateDTO) {
        return service.update(id, updateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         service.delete(id);
    }
}
