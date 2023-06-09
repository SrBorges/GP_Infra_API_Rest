package com.company.api.problemas;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

@RequestMapping("/problemas")

public class ProblemasController {

    @Autowired
    private ProblemasRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid ProblemasEntity json, UriComponentsBuilder UriBuilder){

        var problemas = repository.save(new ProblemasEntity(json));

        var uri = UriBuilder.path("/problemas/{id}").buildAndExpand(problemas.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProblemasDTO(problemas));


    }

    @GetMapping
    public Page<ProblemasDTO> read(Pageable page){

        return repository.findAll(page).map(ProblemasDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ProbUpdateDTO json){

        var problema = repository.getReferenceById(json.id());

        problema.updateInfo(json);

        return ResponseEntity.ok(new ProbUpdateDTO(problema));

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var problema = repository.getReferenceById(id);

        return ResponseEntity.ok(new ProblemasDTO(problema));

    }

}
