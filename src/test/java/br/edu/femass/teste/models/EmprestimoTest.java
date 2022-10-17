package br.edu.femass.teste.models;
import br.edu.femass.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class EmprestimoTest {

    @Test
    void criarEmprestimo() throws Exception {

        Leitor leitor = new Leitor("Nome", "Endereço", "Telefone");
        List<Autor> autores = new ArrayList<>();
        Livro livro = new Livro("Título", autores, 2000);
        Exemplar exemplar = new Exemplar(livro);
        Emprestimo emprestimo = new Emprestimo(leitor, livro);

        LocalDate dataEmprestimoEsperado = LocalDate.now();
        LocalDate dataPrevistaDevolucaoEsperado = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
        LocalDate dataDevolucaoEsperado = null;
        String exemplarEsperado = exemplar.toString();
        Boolean exemplarDisponivel = false;

        Assertions.assertEquals(dataEmprestimoEsperado, emprestimo.getDataEmprestimo());
        Assertions.assertEquals(dataPrevistaDevolucaoEsperado, emprestimo.getDataPrevistaDevolucao());
        Assertions.assertEquals(dataDevolucaoEsperado, emprestimo.getDataDevolucao());
        Assertions.assertEquals(exemplarEsperado, emprestimo.getExemplar().toString());
        Assertions.assertEquals(exemplarDisponivel, exemplar.getDisponivel());
    }

    @Test
    void toStringTeste() throws Exception {
        Leitor leitor = new Leitor("Nome", "Endereço", "Telefone");
        List<Autor> autores = new ArrayList<>();
        Livro livro = new Livro("Título", autores, 2000);
        Exemplar exemplar = new Exemplar(livro);
        Emprestimo emprestimo = new Emprestimo(leitor, livro);

        String nomeEmprestimoEsperado = exemplar.getTituloExemplar() + " - " + exemplar.getCodigo() + " - Nome";

        Assertions.assertEquals(nomeEmprestimoEsperado, emprestimo.toString());
    }

    @Test
    void realizarDevolucao() throws Exception {
        Leitor leitor = new Leitor("Nome", "Endereço", "Telefone");
        List<Autor> autores = new ArrayList<>();
        Livro livro = new Livro("Título", autores, 2000);
        Exemplar exemplar1 = new Exemplar(livro);
        Emprestimo emprestimo = new Emprestimo(leitor, livro);

        LocalDate dataDevolucaoEsperada = LocalDate.now();
        Boolean exemplarDisponivelEsperado = true;

        emprestimo.realizarDevolucao();

        Assertions.assertEquals(dataDevolucaoEsperada, emprestimo.getDataDevolucao());
        Assertions.assertEquals(exemplarDisponivelEsperado, emprestimo.getExemplar().getDisponivel());
    }
}