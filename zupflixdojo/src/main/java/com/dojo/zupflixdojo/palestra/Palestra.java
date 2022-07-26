package com.dojo.zupflixdojo.palestra;

import com.dojo.zupflixdojo.zupper.Zupper;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Palestra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String tema;

    @Column(nullable = false)
    private Duration tempoEmMinutos;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoExibicao tipoExibicao;

    @Column(nullable = false)
    private LocalDateTime dataHoraExibicao;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Zupper> zuppers = new HashSet<>();

    public Palestra(String titulo, String tema, Duration tempoEmMinutos, TipoExibicao tipoExibicao, LocalDateTime dataHoraExibicao, Set<Zupper> zuppers) {
        this.titulo = titulo;
        this.tema = tema;
        this.tempoEmMinutos = tempoEmMinutos;
        this.tipoExibicao = tipoExibicao;
        this.dataHoraExibicao = dataHoraExibicao;
        this.zuppers = zuppers;
    }

    @Deprecated
    public Palestra() {
    }

    public Long getId() {
        return id;
    }
}
