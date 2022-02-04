package api.sopa.letras.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import api.sopa.letras.service.SopaLetrasServiceImpl;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/")
@Slf4j
public class SopaLetrasController {

    @Autowired
    SopaLetrasServiceImpl service;

    @GetMapping("/{palavra}")
    public ResponseEntity<?> localizaPalavra(@PathVariable String palavra) {
        log.info("Iniciando a sopa palavra!");
        ResponseEntity<?> palavraLocalizada = service.localiza(palavra.toUpperCase());
        if(palavraLocalizada.equals(palavra.toUpperCase()))
            return new ResponseEntity<>(palavraLocalizada, HttpStatus.OK);
        log.info("Palavra localizada: ", palavraLocalizada.equals(palavra.toUpperCase()) ? "Sim" : "Não");
        return new ResponseEntity<>(palavraLocalizada, HttpStatus.NOT_FOUND);
    }
}
