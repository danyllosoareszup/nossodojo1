package com.dojo.zupflixdojo;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

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

    @OneToMany
    private List<Zupper> zuppers;

    public Palestra(String titulo, String tema, Duration tempoEmMinutos, TipoExibicao tipoExibicao, LocalDateTime dataHoraExibicao, List<Zupper> zuppers) {
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
