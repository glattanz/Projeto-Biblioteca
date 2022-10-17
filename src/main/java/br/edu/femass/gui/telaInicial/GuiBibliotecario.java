package br.edu.femass.gui.telaInicial;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.gui.autor.GuiCadastrarAutor;
import br.edu.femass.gui.exemplar.GuiExemplar;
import br.edu.femass.gui.livro.GuiCadastrarLivro;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Livro;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiBibliotecario {
    private JPanel jPanelBibliotecario;
    private JButton botaoCadastrarAutores;
    private JButton incluirAlterarExemplaresButton;
    private JButton botaoCadastrarLivro;
    public JList listaLivros;
    private JButton botaoAtualizarLista;
    private JList listaEmprestimosAtrasados;

    public GuiBibliotecario() {

        updateListLivros();
        updateListEmprestimosAtrasados();

        botaoCadastrarAutores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarAutor guiCadastrarAutor = new GuiCadastrarAutor();
                JFrame frame = new JFrame("Cadastar autor");
                frame.setContentPane(guiCadastrarAutor.getjPanelCadastrarAutor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarLivro guiCadastrarLivro = new GuiCadastrarLivro();
                JFrame frame = new JFrame("Cadastrar livro");
                frame.setContentPane(guiCadastrarLivro.getjPanelCadastrarLivro());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        incluirAlterarExemplaresButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiExemplar guiExemplar = new GuiExemplar();
                JFrame frame = new JFrame("Exemplar");
                frame.setContentPane(guiExemplar.getjPanelExemplar());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoAtualizarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateListLivros();
            }
        });
    }

    public void updateListLivros(){
        try {
            List<Livro> livros = new DaoLivro().getAll();
            this.listaLivros.setListData(livros.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateListEmprestimosAtrasados(){
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            List<Emprestimo> emprestimosAtrasados = new ArrayList<>();

            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.verificaAtraso()) {
                    emprestimosAtrasados.add(emprestimo);
                }
            }

            this.listaEmprestimosAtrasados.setListData(emprestimosAtrasados.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public JPanel getjPanelBibliotecario() {
        return jPanelBibliotecario;
    }
}
