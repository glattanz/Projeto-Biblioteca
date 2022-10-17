package br.edu.femass.teste.models;

import br.edu.femass.model.Aluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlunoTest {

    @Test
    void criarAluno() throws Exception {

        Aluno aluno = new Aluno("Nome", "Endereço", "Telefone", "Matrícula");

        String nomeEsperado = "Nome";
        String enderecoEsperado = "Endereço";
        String telefoneEsperado = "Telefone";
        String matriculaEsperado = "Matrícula";
        int prazoEsperado = 15;

        Assertions.assertEquals(nomeEsperado, aluno.getNome());
        Assertions.assertEquals(enderecoEsperado, aluno.getEndereco());
        Assertions.assertEquals(telefoneEsperado, aluno.getTelefone());
        Assertions.assertEquals(matriculaEsperado, aluno.getMatricula());
        Assertions.assertEquals(prazoEsperado, aluno.getPrazoMaximoDevolucao());
    }

    @Test
    void toStringTeste() throws Exception {

        Aluno aluno = new Aluno("Nome", "Endereço", "Telefone", "Matrícula");

        String esperado = aluno.toString();

        Assertions.assertEquals(esperado, "Nome");
    }
}