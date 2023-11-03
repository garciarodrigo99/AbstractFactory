package es.ull.patrones.practica3.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class ImageDisplayFrame extends JFrame {

    public ImageDisplayFrame(String image) {
        System.out.print(image);
        setTitle("Mostrar Imagen en Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JLabel label = new JLabel();
        add(label);

        try {
            URL imageUrl = new URL(image);
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(imageUrl));
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
