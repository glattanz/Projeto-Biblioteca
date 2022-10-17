package br.edu.femass.gui.telaInicial;
import br.edu.femass.dao.*;
import br.edu.femass.gui.emprestimo.GuiEmprestimo;
import br.edu.femass.gui.leitor.GuiLeitor;
import br.edu.femass.model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GuiAtendente {
    private JButton botaoDevolucao;
    private JButton botaoEmprestimo;
    private JButton manterLeitorButton;
    private JPanel jPanelAtendente;
    private JList listaEmprestimos;
    private JButton botaoAtualizarLista;

    public GuiAtendente() {

        updateList();

        botaoEmprestimo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiEmprestimo guiEmprestimo = new GuiEmprestimo();
                JFrame frame = new JFrame("Emprestimo");
                frame.setContentPane(guiEmprestimo.getjPanelEmprestimo());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoDevolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ((Emprestimo) listaEmprestimos.getSelectedValue()).realizarDevolucao();

                    updateList();
                    
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(jPanelAtendente, "Empréstimo devolvido!");
            }
        });

        manterLeitorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiLeitor guiLeitor = new GuiLeitor();
                JFrame frame = new JFrame("Leitores");
                frame.setContentPane(guiLeitor.getjPanelLeitor());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoAtualizarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateList();
            }
        });
    }

    public JPanel getjPanelAtendente() {
        return jPanelAtendente;
    }

    public void updateList(){
        try {
            List<Emprestimo> emprestimos = new DaoEmprestimo().getAll();
            List<Emprestimo> emprestimosPendentes = new ArrayList<>();

            for (Emprestimo emprestimo : emprestimos) {
                if (emprestimo.getDataDevolucao() ==  null) {
                    emprestimosPendentes.add(emprestimo);
                }
            }

            this.listaEmprestimos.setListData(emprestimosPendentes.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
