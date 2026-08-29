import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.screenmatch.modelos.Titulo;

class TituloTest {

    @Test
    void deveCalcularMediaEContarAvaliacoes() {
        Titulo titulo = new Titulo();

        titulo.avalia(8.0);
        titulo.avalia(10.0);
        titulo.avalia(6.0);

        assertEquals(3, titulo.getTotalDeAvaliacoes());
        assertEquals(8.0, titulo.pegaMedia(), 0.0001);
    }
}
