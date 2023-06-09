package com.company.api.problemas;

import jakarta.validation.constraints.NotNull;

public record ProbUpdateDTO(@NotNull Long id,
                            Problema problema,
                            String localizacao) {

    public ProbUpdateDTO(ProblemasEntity json){

        this(json.getId(), json.getProblema(), json.getLocalizacao());

    }

}
