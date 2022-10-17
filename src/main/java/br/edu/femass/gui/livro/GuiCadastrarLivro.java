package br.edu.femass.gui.livro;
import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiCadastrarLivro {
    private JTextField campoTitulo;
    private JPanel jPanelCadastrarLivro;
    private JButton botaoCadastrarLivro;
    public JList listaAutores;
    private JSpinner caixaAno;
    SpinnerNumberModel spinnerNumberModel = new SpinnerNumberModel(2022, 0, 2022, 10);

    public GuiCadastrarLivro() {

        updateList();

        caixaAno.setModel(spinnerNumberModel);

        botaoCadastrarLivro.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(campoTitulo.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(getjPanelCadastrarLivro(), "Preencha todos os campos!");
                    }else {

                        Livro livro = new Livro(campoTitulo.getText(), (List<Autor>) listaAutores.getSelectedValuesList(), (Integer) caixaAno.getValue());
                        new DaoLivro().save(livro);

                        JOptionPane.showMessageDialog(jPanelCadastrarLivro, "Livro salvo!");
                    }
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
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

    public JPanel getjPanelCadastrarLivro() {
        return jPanelCadastrarLivro;
    }
}
