package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.PatientDTO;
import med.voll.api.dto.PatientGetMinDTO;
import med.voll.api.dto.PatientUpdateDTO;
import med.voll.api.services.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService service;

    public PatientController(PatientService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<PatientDTO> create(@RequestBody @Valid PatientDTO patientDTO, UriComponentsBuilder uriComponentsBuilder) {
        PatientDTO dto = service.create(patientDTO);
        var uri = uriComponentsBuilder.path("patients/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<PatientGetMinDTO>> getAll(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size, Sort sort) {
        return ResponseEntity.ok(service.getAll(page, size, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PatientDTO> update(@PathVariable Long id, @RequestBody @Valid PatientUpdateDTO updateDTO) {
        return ResponseEntity.ok(service.update(id, updateDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
         service.delete(id);
         return ResponseEntity.noContent().build();
    }
}
