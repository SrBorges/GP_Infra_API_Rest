package com.company.api.usuario;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "usuario")
@Entity(name = "UsuarioEntity")

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class UsuarioEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @NotNull @NotBlank
    private String nome;
    private String cpf;
    private String dnascimento;
    @NotNull @Email
    private String email;
    @Embedded
    private Endereco endereco;

    public UsuarioEntity(UsuarioEntity json) {

        this.nome = json.nome;
        this.cpf = json.cpf;
        this.dnascimento = json.dnascimento;
        this.email = json.email;
        this.endereco = new Endereco(json.endereco);

    }

    public void updateInfo(UserUpdateDTO json) {

        if(json.nome() != null){
            this.nome = json.nome();
        }

        if(json.cpf() != null){
            this.cpf = json.cpf();
        }

        if(json.dnascimento() != null){
            this.dnascimento = json.dnascimento();
        }

        if(json.email() != null){
            this.email = json.email();
        }

        if(json.endereco() != null){
            this.endereco.novoEndereco(endereco);
        }

    }
}
