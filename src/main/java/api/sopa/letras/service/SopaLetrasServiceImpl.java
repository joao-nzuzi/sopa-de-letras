package api.sopa.letras.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SopaLetrasServiceImpl implements ISopaLetrasService {

    private char[][] matrizPalavras = {
            {'T','J','O','A','O','N'},
            {'B','E','I','R','W','Z'},
            {'A','G','S','V','R','U'},
            {'I','O','Y','T','H','Z'},
            {'X','M','B','R','E','I'},
            {'A','L','O','G','N','A'}

    };

    @Override
    public ResponseEntity<?> localiza(String palavra) {

        for (int[] pos : resolucaoPalavra(palavra)) {

            String novaPalavra = palavraMatriz(pos, palavra.length(), 0, 1);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), 0, -1);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), 1, 0);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), -1, 0);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), -1, 1);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), -1, -1);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), 1, 1);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);

            novaPalavra = palavraMatriz(pos, palavra.length(), 1, -1);
            if (novaPalavra.equals(palavra))
                return new ResponseEntity<>("Palavra "+novaPalavra+ " encontrada na matriz", HttpStatus.OK);
        }
        return new ResponseEntity<>("Palavra "+palavra+ " não encontrada na matriz", HttpStatus.NOT_FOUND);
    }

    private int[][] resolucaoPalavra(String palavraResolver) {
        char primeiraLetra = palavraResolver.charAt(0);
        List<int[]> indiceInvertido = new ArrayList<int[]>();

        for (int i = 0; i < matrizPalavras.length; i++) {
            for (int j = 0; j < matrizPalavras[i].length; j++) {
                if (matrizPalavras[i][j] == primeiraLetra) {
                    indiceInvertido.add(new int[] { i, j });
                }
            }
        }
        return toArrayInt(indiceInvertido);
    }

    private int[][] toArrayInt(List<int[]> lista) {
        return (int[][]) lista.toArray(new int[lista.size()][lista.get(0).length]);
    }

    private String palavraMatriz(int[] posInicial, int numeroDeCaracteres, int moverFila, int moverColuna) {
        String palavra = "";
        int recorrido = 0, fila = posInicial[0], coluna = posInicial[1];

        while ((recorrido < numeroDeCaracteres) &&
                (fila < matrizPalavras.length && coluna < matrizPalavras.length) &&
                (fila > -1 && coluna > -1)) {

            palavra += matrizPalavras[fila][coluna];
            fila = fila + moverFila;
            coluna = coluna + moverColuna;
            recorrido++;
        }

        return palavra;
    }
}
