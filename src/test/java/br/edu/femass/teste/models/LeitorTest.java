package br.edu.femass.teste.models;

import br.edu.femass.model.Leitor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LeitorTest {

    @Test
    void criarLeitor(){

        Leitor leitor = new Leitor("Nome", "Endereço", "Telefone");

        String nomeEsperado = "Nome";
        String enderecoEsperado = "Endereço";
        String telefoneEsperado = "Telefone";
        int prazoEsperado = 0;

        Assertions.assertEquals(nomeEsperado, leitor.getNome());
        Assertions.assertEquals(enderecoEsperado, leitor.getEndereco());
        Assertions.assertEquals(telefoneEsperado, leitor.getTelefone());
        Assertions.assertEquals(prazoEsperado, leitor.getPrazoMaximoDevolucao());

    }

}