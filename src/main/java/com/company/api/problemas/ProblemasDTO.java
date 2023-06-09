package com.company.api.problemas;

import com.company.api.usuario.Endereco;
import jakarta.validation.constraints.NotNull;

public record ProblemasDTO(@NotNull Long id,
                           Problema problema,
                           String localizacao,
                           Endereco endereco) {

    public ProblemasDTO(ProblemasEntity json){

        this(json.getId(),
                json.getProblema(),
                json.getLocalizacao(),
                json.getEndereco());

    }

}
