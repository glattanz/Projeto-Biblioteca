package br.edu.femass.gui.livro;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Livro;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GuiLivro {
    private JButton botaoCadastrarLivro;
    private JButton botaoConsultarLivros;
    private JButton botaoIncluirExemplar;
    private JButton botaoConsultarExemplar;
    private JPanel jPanelLivro;
    private JComboBox comboBoxLivros;


    public GuiLivro() {
        botaoCadastrarLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiCadastrarLivro guiCadastrarLivro = new GuiCadastrarLivro();
                JFrame frame = new JFrame("Cadastrar livro");
                frame.setContentPane(guiCadastrarLivro.getjPanelCadastrarLivro());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocation(1000, 250);
                try {
                    //Cria uma nova lista com todos os autores cadastrados no DaoAutor
                    List<Autor> autores = new DaoAutor().getAll();
                    //Atualiza a lista
                    guiCadastrarLivro.listaAutores.setListData(autores.toArray());
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoConsultarLivros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GuiConsultarLivros guiConsultarLivros = new GuiConsultarLivros();
                JFrame frame = new JFrame("Consultar livro");
                frame.setContentPane(guiConsultarLivros.getjPanelConsultarLivros());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocation(1000, 250);
                frame.pack();
                frame.setVisible(true);
            }
        });

        botaoIncluirExemplar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                GuiCadastrarLivro guiCadastrarLivro = new GuiCadastrarLivro();
//                JFrame frame = new JFrame("Cadastrar livro");
//                frame.setContentPane(guiCadastrarLivro.getjPanelCadastrarLivro());
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setLocation(1000, 250);
//                frame.pack();
//                frame.setVisible(true);
            }
        });

    }

    public void adicionarLivroComboBox(Livro livro){
        comboBoxLivros.addItem(livro);
    }

}
