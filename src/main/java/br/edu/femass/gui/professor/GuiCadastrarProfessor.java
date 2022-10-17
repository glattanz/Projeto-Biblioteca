package br.edu.femass.gui.professor;

import br.edu.femass.dao.DaoProfessor;
import br.edu.femass.model.Professor;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class GuiCadastrarProfessor {
    private JPanel jPanelCadastrarProfessor;
    private JTextField campoNome;
    private JTextField campoEndereco;
    private JButton salvarButton;
    private JFormattedTextField campoTelefone;
    private JTextField campoDisciplina;
    private JList listaProfessores;

    public JPanel getjPanelCadastrarProfessor() {
        return jPanelCadastrarProfessor;
    }

    public GuiCadastrarProfessor() {

        try {
            MaskFormatter mascara = new MaskFormatter("(##) ####-####");
            mascara.install(campoTelefone);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        updateList();

        salvarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(campoNome.getText().isEmpty() || campoEndereco.getText().isEmpty() || campoTelefone.getText().isEmpty() || campoDisciplina.getText().isEmpty())
                        JOptionPane.showMessageDialog(getjPanelCadastrarProfessor(), "Preencha todos os campos!");

                    Professor professor = new Professor(campoNome.getText(), campoEndereco.getText(), campoTelefone.getText(), campoDisciplina.getText());

                    new DaoProfessor().save(professor);
                    updateList();

                    JOptionPane.showMessageDialog(null, "Professor salvo!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
    }

    public void updateList(){
        try {
            List<Professor> professores = new DaoProfessor().getAll();
            this.listaProfessores.setListData(professores.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
