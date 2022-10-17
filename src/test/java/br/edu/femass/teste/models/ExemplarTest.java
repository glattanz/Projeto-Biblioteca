package br.edu.femass.teste.models;
import br.edu.femass.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ExemplarTest {

    @Test
    void criarExemplar() throws Exception {

        Exemplar exemplar = new Exemplar(new Livro());

        LocalDate dataAquisicaoEsperado = LocalDate.now();
        Boolean disponivelEsperado = true;

        Assertions.assertEquals(dataAquisicaoEsperado, exemplar.getDataAquisicao());
        Assertions.assertEquals(disponivelEsperado, exemplar.getDisponivel());

    }

    @Test
    void toStringTeste() throws Exception {
        Leitor leitor = new Leitor("Nome", "Endereço", "Telefone");
        List<Autor> autores = new ArrayList<>();
        Livro livro = new Livro("Título", autores, 2000);
        Exemplar exemplar = new Exemplar(livro);

        String nomeExemplarEsperado = "Título " + exemplar.getCodigo().toString() ;

        Assertions.assertEquals(nomeExemplarEsperado, exemplar.toString());
    }
}