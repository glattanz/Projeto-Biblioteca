package br.edu.femass.dao;

import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.core.type.TypeReference;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class DaoExemplar extends Persistence<Exemplar> implements Dao<Exemplar> {

    private final static String NOMEARQUIVO = "exemplares.json";

    public void save(Exemplar exemplar) throws Exception{
        List<Exemplar> exemplares = getAll();

        exemplares.add(exemplar);
        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(exemplares);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }

    public List<Exemplar> getAll() throws Exception{
        try{
            FileInputStream in = new FileInputStream(NOMEARQUIVO);
            String json = new String(in.readAllBytes());
            List<Exemplar> exemplares = getObjectmapper().readValue(json, new TypeReference<List<Exemplar>>(){});
            return exemplares;
        } catch (FileNotFoundException f){
            return new ArrayList();
        }
    }

    public void update(Exemplar exemplarAtualizado) throws Exception {

        List<Exemplar> exemplares = getAll();
        List<Exemplar> exemplaresAtualizados = new ArrayList<>();

        for (Exemplar exemplar : exemplares) {
            if (exemplar.getCodigo() == exemplarAtualizado.getCodigo()) {
                exemplar.setDisponivel(exemplarAtualizado.getDisponivel());
            }
            exemplaresAtualizados.add(exemplar);
        }

        String json = getObjectmapper().writerWithDefaultPrettyPrinter().writeValueAsString(exemplaresAtualizados);

        FileOutputStream out = new FileOutputStream(NOMEARQUIVO);
        out.write(json.getBytes());
        out.close();
    }
}
