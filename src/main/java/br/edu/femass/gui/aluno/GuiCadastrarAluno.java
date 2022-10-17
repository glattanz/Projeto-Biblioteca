package br.edu.femass.gui.aluno;
import br.edu.femass.dao.DaoAluno;
import br.edu.femass.model.Aluno;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

public class GuiCadastrarAluno {
    private JTextField campoNome;
    private JTextField campoMatricula;
    private JFormattedTextField campoTelefone;
    private JTextField campoEndereco;
    private JButton botaoSalvar;
    private JPanel jPanelCadastrarAluno;
    private JList listaAlunos;

    public JPanel getjPanelCadastrarAluno() {
        return jPanelCadastrarAluno;
    }

    public GuiCadastrarAluno() {

        try {
            MaskFormatter mascara = new MaskFormatter("(##) ####-####");
            mascara.install(campoTelefone);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        updateList();

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(campoNome.getText().isEmpty() || campoEndereco.getText().isEmpty() || campoTelefone.getText().isEmpty() || campoMatricula.getText().isEmpty())
                        JOptionPane.showMessageDialog(getjPanelCadastrarAluno(), "Preencha todos os campos!");

                    Aluno aluno = new Aluno(campoNome.getText(), campoEndereco.getText(), campoTelefone.getText(), campoMatricula.getText());


                    new DaoAluno().save(aluno);
                    updateList();

                    JOptionPane.showMessageDialog(null, "Aluno salvo!");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }

            }
        });

    }

    public void updateList(){
        try {
            List<Aluno> alunos = new DaoAluno().getAll();
            this.listaAlunos.setListData(alunos.toArray());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
