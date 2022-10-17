package br.edu.femass.model;

import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoProfessor;

import java.util.ArrayList;
import java.util.List;

public class Leitor {

    private Long codigo = 1L;
    private String nome;
    private String endereco;
    private String telefone;
    private int prazoMaximoDevolucao;

    public Leitor(){
    }

    public Leitor(String nome, String endereco, String telefone){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    //Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getPrazoMaximoDevolucao() {
        return prazoMaximoDevolucao;
    }

    public void setPrazoMaximoDevolucao(int prazoMaximoDevolucao) {
        this.prazoMaximoDevolucao = prazoMaximoDevolucao;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    public void proximoId() throws Exception {
        Long maior = 0L;

        List<Aluno> alunos = new DaoAluno().getAll();
        List<Professor> professores = new DaoProfessor().getAll();
        List<Leitor> leitores = new ArrayList<>();
        leitores.addAll(alunos);
        leitores.addAll(professores);

        for (Leitor leitor: leitores) {
            if (leitor.getCodigo()>maior) {
                maior = leitor.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }
}
