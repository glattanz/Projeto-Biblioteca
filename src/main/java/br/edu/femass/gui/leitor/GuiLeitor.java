package br.edu.femass.gui.leitor;

import br.edu.femass.gui.aluno.GuiCadastrarAluno;
import br.edu.femass.gui.professor.GuiCadastrarProfessor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiLeitor {

    private JPanel jPanelLeitor;
    private JButton botaoCadastrarAluno;
    private JButton botaoCadastrarProfessor;
    private JButton botaoAlterarAluno;
    private JButton botaoAlterarProfessor;

    public GuiLeitor(){
        botaoCadastrarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarAluno guiCadastrarAluno = new GuiCadastrarAluno();
                JFrame frame = new JFrame("Cadastrar aluno");
                frame.setContentPane(guiCadastrarAluno.getjPanelCadastrarAluno());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoCadastrarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarProfessor guiCadastrarProfessor = new GuiCadastrarProfessor();
                JFrame frame = new JFrame("Cadastrar professor");
                frame.setContentPane(guiCadastrarProfessor.getjPanelCadastrarProfessor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });
        botaoAlterarAluno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                 try {
//                    List<Aluno> alunos = new DaoAluno().getAll();
//                    guiLeitor.listaAluno.setListData(alunos.toArray());
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
//
//

            }
        });
        botaoAlterarProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                try {
//                    List<Professor> professores = new DaoProfessor().getAll();
//                    guiLeitor.listaProfessor.setListData(professores.toArray());
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
            }
        });
    }

    public JPanel getjPanelLeitor() {
        return jPanelLeitor;
    }
}
