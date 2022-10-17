import br.edu.femass.dao.DaoExemplar;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.gui.telaInicial.GuiTelaInicial;
import com.fasterxml.jackson.core.type.TypeReference;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Exemplar;
import br.edu.femass.model.Livro;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) throws Exception {

        GuiTelaInicial guiTelaInicial = new GuiTelaInicial();
        JFrame frame = new JFrame("Login");
        frame.setContentPane(guiTelaInicial.jPanelTelaInicial);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(1000, 250);
        frame.pack();

        frame.setVisible(true);

        ImageIcon img = new ImageIcon("imagemTelaInicial.jpg", "");
        Image imgResize = img.getImage().getScaledInstance(100, 100, 100);

        guiTelaInicial.imagem.setIcon(new ImageIcon(imgResize, ""));

    }
}
