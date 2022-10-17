package br.edu.femass.model;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import java.time.LocalDate;
import java.util.List;

public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao = null;
    private Exemplar exemplar;
//    private Livro livro;
    private String nomeEmprestimo;

    public Emprestimo(){
    }

    public Emprestimo(Leitor leitor, Livro livro) throws Exception {
        this.dataEmprestimo = LocalDate.now();
        this.dataPrevistaDevolucao = LocalDate.now().plusDays(leitor.getPrazoMaximoDevolucao());
//        this.livro = livro;

        List<Exemplar> exemplares = livro.getListaExemplares();

        for (Exemplar exemplar : exemplares) {
            if (exemplar.getDisponivel() == true) {
                exemplar.setDisponivel(false);
                this.exemplar = exemplar;
                new DaoExemplar().update(exemplar);
            }
        }

        new DaoLivro().update(livro);

        this.nomeEmprestimo = exemplar.getTituloExemplar() + " - " + exemplar.getCodigo() + " - " + leitor.getNome();
    }

    public void realizarDevolucao() throws Exception {
        this.dataDevolucao = LocalDate.now();
        this.exemplar.setDisponivel(true);
        new DaoEmprestimo().update(this);
        new DaoExemplar().update(this.exemplar);
//        new DaoLivro().update(this.livro);
    }

    @Override
    public String toString() {
        return this.nomeEmprestimo;
    }

    @Override
    public boolean equals(Object obj) {
        Emprestimo emprestimo = (Emprestimo) obj;
        return emprestimo.getNomeEmprestimo().equals(this.nomeEmprestimo);
    }

    public boolean verificaAtraso(){
        return this.getDataPrevistaDevolucao().isBefore(LocalDate.now());
    }

    //Getters and Setters
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataPrevistaDevolucao() {
        return dataPrevistaDevolucao;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Exemplar getExemplar() {
        return exemplar;
    }

    public String getNomeEmprestimo() {
        return nomeEmprestimo;
    }
}
