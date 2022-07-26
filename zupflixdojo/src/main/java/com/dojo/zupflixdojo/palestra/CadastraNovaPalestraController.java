package com.dojo.zupflixdojo.palestra;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dojo.zupflixdojo.zupper.ZupperRepository;

import java.net.URI;

@RestController
public class CadastraNovaPalestraController {
    private final PalestraRepository palestraRepository;
    private final ZupperRepository zupperRepository;

    public CadastraNovaPalestraController(PalestraRepository palestraRepository, ZupperRepository zupperRepository) {
        this.palestraRepository = palestraRepository;
        this.zupperRepository = zupperRepository;
    }

    @PostMapping("/palestras")
    public ResponseEntity<Void> cadastra(@RequestBody @Valid PalestraRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Palestra palestra = request.toModel(zupperRepository);

        palestraRepository.save(palestra);
        URI location = uriComponentsBuilder.path("/palestras/{id}").buildAndExpand(palestra.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
