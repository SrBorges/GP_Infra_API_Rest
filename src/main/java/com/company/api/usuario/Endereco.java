package com.company.api.usuario;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class Endereco {

    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;


    public Endereco(Endereco endereco) {

        this.logradouro = endereco.logradouro;
        this.bairro = endereco.bairro;
        this.cidade = endereco.cidade;
        this.estado = endereco.estado;

    }

    public void novoEndereco(Endereco endereco) {

        if(endereco.logradouro != null){
            this.logradouro = endereco.logradouro;
        }

        if(endereco.bairro != null){
            this.bairro = endereco.bairro;
        }

        if(endereco.cidade != null){
            this.cidade = endereco.cidade;
        }

        if(endereco.estado != null){
            this.estado = endereco.estado;
        }


    }
}
