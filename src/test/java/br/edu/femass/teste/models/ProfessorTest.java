package br.edu.femass.teste.models;
import br.edu.femass.model.Professor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProfessorTest {

    @Test
    void criarProfessor() throws Exception {

        Professor professor = new Professor("Nome", "Endereço", "Telefone", "Disciplina");

        String nomeEsperado = "Nome";
        String enderecoEsperado = "Endereço";
        String telefoneEsperado = "Telefone";
        String disciplinaEsperado = "Disciplina";
        int prazoEsperado = 30;

        Assertions.assertEquals(nomeEsperado, professor.getNome());
        Assertions.assertEquals(enderecoEsperado, professor.getEndereco());
        Assertions.assertEquals(telefoneEsperado, professor.getTelefone());
        Assertions.assertEquals(disciplinaEsperado, professor.getDisciplina());
        Assertions.assertEquals(prazoEsperado, professor.getPrazoMaximoDevolucao());

    }
}