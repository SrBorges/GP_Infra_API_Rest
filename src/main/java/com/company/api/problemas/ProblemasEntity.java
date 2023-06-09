package com.company.api.problemas;

import com.company.api.usuario.Endereco;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "problemas")
@Entity(name = "ProblemasEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")



public class ProblemasEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    @Enumerated(EnumType.STRING)
    private Problema problema;
    @NotNull @NotBlank
    private String localizacao;
    @Embedded
    private Endereco endereco;


    public ProblemasEntity(ProblemasEntity json) {

        this.problema = json.problema;
        this.localizacao = json.localizacao;
        this.endereco = new Endereco(json.endereco);

    }

    public void updateInfo(ProbUpdateDTO json) {

        if(json.problema() != null){
            this.problema = json.problema();
        }

        if(json.localizacao() != null){
            this.localizacao = json.localizacao();
        }

    }
}
