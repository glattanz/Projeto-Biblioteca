package br.edu.femass.dao;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DaoLivro extends Persistence<Livro> implements Dao<Livro>{

    private final static String NOMEARQUIVO = "livros.json";

    public void save(Livro livro) throws Exception{
        List<Livro> livros = getAll();

        livros.add(livro);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(livros);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Livro> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Livro> livros = getObjectmapper().readValue(json, new TypeReference<List<Livro>>(){});
            return livros;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }

    public void update(Livro livroAtualizado) throws Exception {

        List<Livro> livros = getAll();
        List<Livro> livrosAtualizados = new ArrayList<>();

        for (Livro livro : livros) {
            if (livro.getCodigo() == livroAtualizado.getCodigo()) {
                livro.setTitulo(livroAtualizado.getTitulo());
                livro.setListaAutores(livroAtualizado.getListaAutores());
                livro.setListaExemplares(livroAtualizado.getListaExemplares());
                livro.setAno(livroAtualizado.getAno());
            }
            livrosAtualizados.add(livro);
        }

        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(livrosAtualizados);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }
}