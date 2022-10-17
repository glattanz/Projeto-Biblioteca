package br.edu.femass.teste.models;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class AutorTest {

    @Test
    void criarLivroSemAutor() throws Exception {

        List<Autor> listaAutores = new ArrayList<>();
        Livro livro = new Livro("Título", listaAutores, 2000);

        String tituloEsperado = "Título";
        boolean listaAutorEsperado = true;

        Assertions.assertEquals(tituloEsperado, livro.getTitulo());
        Assertions.assertEquals(listaAutorEsperado, livro.getListaAutores().isEmpty());
    }

    @Test
    void criaAutor(){

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");

        String nomeEsperado = "Nome";
        String sobrenomeEsperado = "Sobrenome";
        String nacionalidadeEsperado = "Nacionalidade";

        Assertions.assertEquals(nomeEsperado, autor.getNome());
        Assertions.assertEquals(sobrenomeEsperado, autor.getSobrenome());
        Assertions.assertEquals(nacionalidadeEsperado, autor.getNacionalidade());
    }

    @Test
    void toStringTeste(){
        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");

        String esperado = autor.toString();

        Assertions.assertEquals(esperado, "Nome Sobrenome");
    }

}