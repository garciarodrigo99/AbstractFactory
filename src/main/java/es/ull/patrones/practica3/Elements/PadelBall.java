package es.ull.patrones.practica3.Elements;

import es.ull.patrones.practica3.Elements.Ball;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class PadelBall implements Ball {
    private String name;
    private double price;
    private int stock;
    private String image;

    public PadelBall(String elementName, double elementPrice, int elementStock, String elementImage) {
        this.name = elementName;
        this.price = elementPrice;
        this.stock = elementStock;
        this.image = elementImage;
        getDescription();
    }

    public PadelBall() {

    }

    @Override
    public void throwBall() {

    }

    @Override
    public String getDescription() {
        return "Padel Ball: Name - " + getName() + ", Price - $" + getPrice() + ", Stock - " + getStock() + " units";
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    /*public void showImage() {
        SwingUtilities.invokeLater(() -> {
            JFrame imageFrame = new JFrame(name);
            imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            ImageIcon imageIcon = new ImageIcon(image.getAbsolutePath());
            JLabel imageLabel = new JLabel(imageIcon);

            imageFrame.add(imageLabel);
            imageFrame.pack();
            imageFrame.setVisible(true);
        });
    }*/

    public void showImage() {
        try {
            URL url = new URL(getImage());
            BufferedImage image = ImageIO.read(url);

            if (image != null) {
                // Display the image in a JLabel
                ImageIcon icon = new ImageIcon(image);
                JLabel imageLabel = new JLabel(icon);

                // Create a dialog to display the image
                JFrame imageFrame = new JFrame("Padel Ball Image");
                imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                imageFrame.getContentPane().add(imageLabel);
                imageFrame.pack();
                imageFrame.setVisible(true);
            } else {
                System.err.println("Image is null. It may not be in a supported format.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
