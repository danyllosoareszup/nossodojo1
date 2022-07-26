package com.dojo.zupflixdojo.zupper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class CadastraNovoZupperController {


    private final ZupperRepository zupperRepository;
    public CadastraNovoZupperController(ZupperRepository zupperRepository) {
        this.zupperRepository = zupperRepository;
    }

    @PostMapping("/zuppers")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoZupperRequest request, UriComponentsBuilder uriComponentsBuilder){
        Zupper zupper = request.toModel();

        System.out.println(request);

        zupperRepository.save(zupper);

        URI location = uriComponentsBuilder.path("/zuppers/{id}").buildAndExpand(zupper.getId()).toUri();


        return ResponseEntity.created(location).build();
    }

}
