import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import br.com.alura.screenmatch.calculos.FiltroRecomendacao;
import br.com.alura.screenmatch.modelos.Filme;

class FiltroRecomendacaoTest {

    @Test
    void deveIndicarFilmeComoPreferidoQuandoClassificacaoEhAlta() {
        Filme filme = new Filme();
        filme.avalia(10.0);
        filme.avalia(9.0);
        filme.avalia(8.0);

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(saida));

        try {
            FiltroRecomendacao filtro = new FiltroRecomendacao();
            filtro.filtrar(filme);
        } finally {
            System.setOut(original);
        }

        assertTrue(saida.toString().contains("Está entre os preferidos no momento"));
    }

    @Test
    void deveIndicarFilmeComoBemAvaliadoQuandoClassificacaoEhMedia() {
        Filme filme = new Filme();
        filme.avalia(5.0);
        filme.avalia(6.0);

        ByteArrayOutputStream saida = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(saida));

        try {
            FiltroRecomendacao filtro = new FiltroRecomendacao();
            filtro.filtrar(filme);
        } finally {
            System.setOut(original);
        }

        assertTrue(saida.toString().contains("Muito bem avaliado no momento!"));
    }
}
