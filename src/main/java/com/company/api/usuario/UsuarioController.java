package com.company.api.usuario;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController

@RequestMapping("/usuario")

public class UsuarioController {


    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody @Valid UsuarioEntity json, UriComponentsBuilder UriBuilder){

        var usuario = repository.save(new UsuarioEntity(json));

        var uri = UriBuilder.path("/usuario/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new UsuarioDTO(usuario));

    }

    @GetMapping
    public Page<UsuarioDTO> read(Pageable page){

        return repository.findAll(page).map(UsuarioDTO::new);

    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid UserUpdateDTO json){

        var usuario = repository.getReferenceById(json.id());

        usuario.updateInfo(json);

        return ResponseEntity.ok(new UserUpdateDTO(usuario));


    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id){

        repository.deleteById(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity detail(@PathVariable Long id){

        var usuario = repository.getReferenceById(id);

        return ResponseEntity.ok(new UsuarioDTO(usuario));

    }

}
