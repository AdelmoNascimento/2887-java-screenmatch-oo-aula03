import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.screenmatch.calculos.CalculadoraDeTempo;
import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;

class CalculadoraDeTempoTest {

    @Test
    void deveSomarDuracaoDosTitulosIncluidos() {
        Filme filme = new Filme();
        filme.setDuracaoEmMinutos(120);

        Serie serie = new Serie();
        serie.setTemporadas(2);
        serie.setEpisodiosPorTemporada(3);
        serie.setMinutosPorEpisodio(30);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(filme);
        calculadora.inclui(serie);

        assertEquals(300, calculadora.getTempoTotal());
    }
}
