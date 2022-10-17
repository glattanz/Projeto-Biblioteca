package br.edu.femass.model;

public class Aluno extends Leitor{

    private String matricula;

    public Aluno(){
    }

    public Aluno(String nome, String endereco, String telefone, String matricula) throws Exception {
        super(nome, endereco, telefone);
        this.matricula = matricula;
        setPrazoMaximoDevolucao(15);
        proximoId();
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    public String getMatricula() {
        return matricula;
    }

}
