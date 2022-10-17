package br.edu.femass.teste.models;
import br.edu.femass.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class LivroTest {

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
    void criarLivroUmAutor() throws Exception {

        Autor autor = new Autor("Nome", "Sobrenome", "Nacionalidade");
        List<Autor> listaAutores = new ArrayList<>();
        listaAutores.add(autor);
        Livro livro = new Livro("Título", listaAutores, 2000);

        String tituloEsperado = "Título";
        String nomeAutorEsperado = "Nome";
        String sobrenomeAutorEsperado = "Sobrenome";
        String nacionalidadeAutorEsperado = "Nacionalidade";
        int anoEsperado = 2000;

        Assertions.assertEquals(tituloEsperado, livro.getTitulo());
        Assertions.assertEquals(nomeAutorEsperado, livro.getListaAutores().get(0).getNome());
        Assertions.assertEquals(sobrenomeAutorEsperado, livro.getListaAutores().get(0).getSobrenome());
        Assertions.assertEquals(nacionalidadeAutorEsperado, livro.getListaAutores().get(0).getNacionalidade());
        Assertions.assertEquals(anoEsperado, livro.getAno());

    }

    @Test
    void criarLivroVariosAutores() throws Exception {

        Autor autor1 = new Autor("Nome", "Sobrenome", "Nacionalidade");
        Autor autor2 = new Autor("Nome", "Sobrenome", "Nacionalidade");
        List<Autor> listaAutores = new ArrayList<>();
        listaAutores.add(autor1);
        listaAutores.add(autor2);
        Livro livro = new Livro("Título", listaAutores, 2000);

        String tituloEsperado = "Título";
        String nomeAutor1Esperado = "Nome";
        String sobrenomeAutor1Esperado = "Sobrenome";
        String nacionalidadeAutor1Esperado = "Nacionalidade";
        String nomeAutor2Esperado = "Nome";
        String sobrenomeAutor2Esperado = "Sobrenome";
        String nacionalidadeAutor2Esperado = "Nacionalidade";

        Assertions.assertEquals(tituloEsperado, livro.getTitulo());
        Assertions.assertEquals(nomeAutor1Esperado, livro.getListaAutores().get(0).getNome());
        Assertions.assertEquals(sobrenomeAutor1Esperado, livro.getListaAutores().get(0).getSobrenome());
        Assertions.assertEquals(nacionalidadeAutor1Esperado, livro.getListaAutores().get(0).getNacionalidade());
        Assertions.assertEquals(nomeAutor2Esperado, livro.getListaAutores().get(1).getNome());
        Assertions.assertEquals(sobrenomeAutor2Esperado, livro.getListaAutores().get(1).getSobrenome());
        Assertions.assertEquals(nacionalidadeAutor2Esperado, livro.getListaAutores().get(1).getNacionalidade());
    }

    @Test
    void toStringTeste() throws Exception {
        List<Autor> listaAutores = new ArrayList<>();
        Livro livro = new Livro("Título", listaAutores, 2000);

        String esperado = "Título";

        Assertions.assertEquals(esperado, livro.toString());
    }
}