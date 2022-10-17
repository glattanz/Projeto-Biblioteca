package br.edu.femass.model;
import br.edu.femass.dao.DaoExemplar;
import java.time.LocalDate;
import java.util.List;

public class Exemplar {

    private Long codigo = 1L;
    private LocalDate dataAquisicao;
    public boolean disponivel;
    public String tituloExemplar;

    public Exemplar(){
    }

    public Exemplar(Livro livro) throws Exception {
        this.proximoId();
        this.dataAquisicao = LocalDate.now();
        this.disponivel = true;
        this.tituloExemplar = livro.toString();

        livro.addListaExemplares(this);
    }

    @Override
    public String toString() {
        return this.getTituloExemplar() + " " + this.getCodigo().toString();
    }

    public void proximoId() throws Exception {
        Long maior = 0L;

        List<Exemplar> exemplares = new DaoExemplar().getAll();
        for (Exemplar exemplar: exemplares) {
            if (exemplar.getCodigo()>maior) {
                maior = exemplar.getCodigo();
                setCodigo(maior + 1);
            }
        }
    }

    //Getters and Setters
    public Long getCodigo() {
        return codigo;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public String getTituloExemplar() {
        return tituloExemplar;
    }
    public boolean getDisponivel() {
        return disponivel;
    }
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}
