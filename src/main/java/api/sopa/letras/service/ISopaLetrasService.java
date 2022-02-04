package api.sopa.letras.service;

import org.springframework.http.ResponseEntity;

public interface ISopaLetrasService {
    ResponseEntity<?> localiza(String palavra);
}
