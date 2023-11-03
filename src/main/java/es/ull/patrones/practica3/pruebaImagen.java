package es.ull.patrones.practica3;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class pruebaImagen extends JFrame {

    public pruebaImagen() {
        setTitle("Mostrar Imagen en Swing");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Crea un JLabel para mostrar la imagen
        JLabel label = new JLabel();
        add(label);

        try {
            // Carga la imagen desde una URL en Internet
            URL imageUrl = new URL("https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/b22a8e9f7f2b428ebeede45b23b6d939_9366/BALON_UCL_PRO_Blanco_IA0953_HM1.jpg");
            ImageIcon imageIcon = new ImageIcon(ImageIO.read(imageUrl));
            label.setIcon(imageIcon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            pruebaImagen frame = new pruebaImagen();
            frame.setVisible(true);
        });
    }
}
