package com.dojo.zupflixdojo.zupper;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

public class NovoZupperRequest {

    @NotBlank
    private String nome;

    @PastOrPresent
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataDeAdmissao;

    @NotBlank
    private String email;

    public String getNome() {
        return nome;
    }

    public LocalDate getDataDeAdmissao() {
        return dataDeAdmissao;
    }

    public String getEmail() {
        return email;
    }

    public Zupper toModel() {
        return new Zupper(nome,dataDeAdmissao,email);
    }

    @Override
    public String toString() {
        return "NovoZupperRequest{" +
                "nome='" + nome + '\'' +
                ", dataDeAdmissao=" + dataDeAdmissao +
                ", email='" + email + '\'' +
                '}';
    }
}
