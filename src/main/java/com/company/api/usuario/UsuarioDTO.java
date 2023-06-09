package com.company.api.usuario;

import jakarta.validation.constraints.NotNull;

public record UsuarioDTO(@NotNull Long id,
                         String nome,
                         String cpf,
                         String dnascimento,
                         String email,
                         Endereco endereco
                         ) {

    public UsuarioDTO(UsuarioEntity json){

        this(json.getId(),
                json.getNome(),
                json.getCpf(),
                json.getDnascimento(),
                json.getEmail(),
                json.getEndereco());

    }


}
