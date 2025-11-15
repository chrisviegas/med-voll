package med.voll.api.controllers;

import jakarta.validation.Valid;
import med.voll.api.dto.DoctorDTO;
import med.voll.api.dto.DoctorGetMinDTO;
import med.voll.api.dto.DoctorUpdateDTO;
import med.voll.api.services.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService service;

    public DoctorController(DoctorService doctorService) {
        this.service = doctorService;
    }

    @PostMapping("/register")
    public ResponseEntity<DoctorDTO> create(@RequestBody @Valid DoctorDTO doctorDTO, UriComponentsBuilder uriComponentsBuilder) {
        DoctorDTO dto = service.create(doctorDTO);
        var uri = uriComponentsBuilder.path("/doctors/{id}").buildAndExpand(dto.id()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DoctorGetMinDTO>> getAll(@RequestParam(defaultValue = "0") int page,
                                        @RequestParam(defaultValue= "10") int size, Sort sort) {
        return ResponseEntity.ok(service.getAll(page, size, sort));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<DoctorDTO> update(@PathVariable Long id, @RequestBody @Valid DoctorUpdateDTO dto) {
        return ResponseEntity.ok(service.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
