package es.ull.patrones.practica3.GUI;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class WindowPicture extends JFrame {

    public WindowPicture(String URL, String titulo) {
        setTitle(titulo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);

        // Crea un JLabel para mostrar la imagen
        JLabel label = new JLabel();
        add(label);

        try {
            // Carga la imagen desde una URL en Internet
            URL imageUrl = new URL(URL);
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(imageUrl));
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}