package br.edu.femass.gui.exemplar;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiExemplar {
    private JPanel jPanelExemplar;
    private JButton botaoCadastrarExemplar;
    private JButton botaoAlterarExemplar;
    private JComboBox comboBoxLivros;
    private JList listaExemplares;

    public GuiExemplar() {

        updateCombo();
        updateList();

        botaoCadastrarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    Exemplar exemplar = new Exemplar((Livro) comboBoxLivros.getSelectedItem());
                    new DaoExemplar().save(exemplar);

                    Livro livroSelecionado = (Livro) comboBoxLivros.getSelectedItem();
                    livroSelecionado.addListaExemplares(exemplar);

                    new DaoLivro().update(livroSelecionado);

                    updateList();
                    JOptionPane.showMessageDialog(jPanelExemplar, "Exemplar salvo!");

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        //Fazer depois
        botaoAlterarExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    private void updateCombo() {
        try {
            List<Livro> livros = new DaoLivro().getAll();
            for (Livro livro: livros) {
                comboBoxLivros.addItem(livro);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateList(){
        try {
            List<Exemplar> exemplares = new DaoExemplar().getAll();
            this.listaExemplares.setListData(exemplares.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public JPanel getjPanelExemplar() {
        return jPanelExemplar;
    }
}