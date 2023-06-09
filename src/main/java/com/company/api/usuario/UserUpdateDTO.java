package com.company.api.usuario;

import jakarta.validation.constraints.NotNull;

public record UserUpdateDTO(@NotNull Long id,
                            String nome,
                            String cpf,
                            String dnascimento,
                            String email,
                            Endereco endereco) {

    public UserUpdateDTO(UsuarioEntity json){

        this(json.getId(),
                json.getNome(),
                json.getCpf(),
                json.getDnascimento(),
                json.getEmail(),
                json.getEndereco());

    }

}
