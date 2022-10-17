package br.edu.femass.gui.autor;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.gui.livro.GuiCadastrarLivro;
import br.edu.femass.model.Autor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiCadastrarAutor {
    private JPanel jPanelCadastrarAutor;
    private JTextField campoNome;
    private JTextField campoSobrenome;
    private JTextField campoNacionalidade;
    private JButton botaoSalvar;
    public JList listaAutores;

    public GuiCadastrarAutor() {

        updateList();

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if(campoNome.getText().isEmpty() || campoSobrenome.getText().isEmpty() || campoNacionalidade.getText().isEmpty()){
                        JOptionPane.showMessageDialog(getjPanelCadastrarAutor(), "Preencha todos os campos!");
                    }else {
                        Autor autor = new Autor(campoNome.getText(), campoSobrenome.getText(), campoNacionalidade.getText());
                        new DaoAutor().save(autor);
                        updateList();

                        JOptionPane.showMessageDialog(jPanelCadastrarAutor, "Autor salvo!");
                    }
                }catch (Exception e){
                    JOptionPane.showMessageDialog(getjPanelCadastrarAutor(), e.getMessage());
                }
            }
        });
    }

    public void updateList(){
        try {
            List<Autor> autores = new DaoAutor().getAll();
            this.listaAutores.setListData(autores.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public JPanel getjPanelCadastrarAutor() {
        return jPanelCadastrarAutor;
    }
}
