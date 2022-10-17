package br.edu.femass.teste.models;
import br.edu.femass.model.Autor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class AutorTest {

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