package br.edu.femass.gui.emprestimo;
import br.edu.femass.dao.*;
import br.edu.femass.model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiEmprestimo {
    private JPanel jPanelEmprestimo;
    public JList listaLeitores;
    public JList listaLivros;
    private JButton botaoEmprestimo;
    private JScrollPane scrollPanelLeitor;
    private JScrollPane scrollPanelLivro;

    public GuiEmprestimo() {

        updateListLeitores();
        updateListLivros();

        botaoEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Emprestimo emprestimo = new Emprestimo((Leitor) listaLeitores.getSelectedValue(), (Livro) listaLivros.getSelectedValue());

                    new DaoEmprestimo().save(emprestimo);

                    updateListLivros();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                JOptionPane.showMessageDialog(jPanelEmprestimo, "Emprestimo salvo!");
            }
        });
    }

    public void updateListLeitores(){
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            List<Professor> professores = new DaoProfessor().getAll();
            List<Leitor> leitores = new ArrayList<>();
            leitores.addAll(alunos);
            leitores.addAll(professores);
            this.listaLeitores.setListData(leitores.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public void updateListLivros(){
        try {
            List<Livro> livros = new DaoLivro().getAll();
            List<Livro> livrosDisponiveis = new ArrayList<>();

            for (Livro livro : livros) {
                List<Exemplar> exemplares = livro.getListaExemplares();
                if(!exemplares.isEmpty()) {
//                    boolean disponivel = false;
//                    while (disponivel == false) {
                        for (Exemplar exemplar : exemplares) {
                            if (exemplar.getDisponivel() == true) {
//                                disponivel = true;
                                livrosDisponiveis.add(livro);
                                break;
                            }
                        }
//                        break;
//                    }
                }
            }

            this.listaLivros.setListData(livrosDisponiveis.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public JPanel getjPanelEmprestimo() {
        return jPanelEmprestimo;
    }
}
