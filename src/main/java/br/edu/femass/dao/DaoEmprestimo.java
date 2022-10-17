package br.edu.femass.dao;

import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DaoEmprestimo extends Persistence<Emprestimo> implements Dao<Emprestimo> {

    private final static String NOMEARQUIVO = "emprestimos.json";

    public void save(Emprestimo emprestimo) throws Exception{
        List<Emprestimo> emprestimos = getAll();

        emprestimos.add(emprestimo);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(emprestimos);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Emprestimo> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Emprestimo> emprestimos = getObjectmapper().readValue(json, new TypeReference<List<Emprestimo>>(){});
            return emprestimos;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }

    public void update(Emprestimo emprestimoAtualizado) throws Exception {

        List<Emprestimo> emprestimos = getAll();
        List<Emprestimo> emprestimosAtualizados = new ArrayList<>();

        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.equals(emprestimoAtualizado)) {
                emprestimo.setDataDevolucao(emprestimoAtualizado.getDataDevolucao());
            }
            emprestimosAtualizados.add(emprestimo);
        }

        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(emprestimosAtualizados);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }
}