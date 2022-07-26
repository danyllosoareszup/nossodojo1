package com.dojo.zupflixdojo.zupper;

import com.dojo.zupflixdojo.palestra.Palestra;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany(mappedBy = "zuppers")
    private Set<Palestra> palestras = new HashSet<>();

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


    public void adicionarPalestra(Palestra novaPalestra){
        this.palestras.add(novaPalestra);
    }

}
