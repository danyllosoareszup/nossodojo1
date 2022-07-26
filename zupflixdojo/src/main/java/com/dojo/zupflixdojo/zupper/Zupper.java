package com.dojo.zupflixdojo.zupper;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Zupper {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private LocalDate dataDeAdmissao;

    @Column(nullable = false)
    private String email;

    public Zupper(String nome, LocalDate dataDeAdmissao, String email) {
        this.nome = nome;
        this.dataDeAdmissao = dataDeAdmissao;
        this.email = email;
    }

    @Deprecated
    public Zupper() {
    }

    public Long getId() {
        return id;
    }

}
