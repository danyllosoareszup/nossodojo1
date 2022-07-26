package com.dojo.zupflixdojo.palestra;

import com.dojo.zupflixdojo.zupper.Zupper;
import com.dojo.zupflixdojo.zupper.ZupperRepository;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PalestraRequest {

    @NotBlank
    private String titulo;

    @NotBlank
    private String tema;

    @NotNull
    private Duration tempoEmMinutos;

    @NotNull
    private TipoExibicaoRequest tipoExibicao;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime dataHoraExibicao;

    @NotEmpty
    private Set<Long> zuppers = new HashSet<>();

    public Palestra toModel(ZupperRepository zupperRepository) {
        Set<Zupper> novosZuppers = zuppers.stream().map((id) -> zupperRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY))).collect(Collectors.toSet());

        return new Palestra(titulo, tema, tempoEmMinutos, TipoExibicao.valueOf(tipoExibicao.name()), dataHoraExibicao, novosZuppers);
    }

    public String getTitulo() {
        return titulo;
    }

    public String getTema() {
        return tema;
    }

    public Duration getTempoEmMinutos() {
        return tempoEmMinutos;
    }

    public TipoExibicaoRequest getTipoExibicao() {
        return tipoExibicao;
    }

    public LocalDateTime getDataHoraExibicao() {
        return dataHoraExibicao;
    }

    public Set<Long> getZuppers() {
        return zuppers;
    }

}
