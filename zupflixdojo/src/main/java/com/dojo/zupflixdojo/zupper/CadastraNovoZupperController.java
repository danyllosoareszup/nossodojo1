package com.dojo.zupflixdojo.zupper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CadastraNovoZupperController {

    @PostMapping("/zuppers")
    public ResponseEntity<?> cadastra(@RequestBody @Valid NovoZupperRequest request){
        Zupper zupper = request.toModel();

        System.out.println(request);

        return null;
    }

}
