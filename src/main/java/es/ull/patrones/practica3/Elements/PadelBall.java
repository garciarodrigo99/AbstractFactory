package es.ull.patrones.practica3.Elements;

import es.ull.patrones.practica3.Elements.Ball;

import javax.swing.*;
import java.io.File;

public class PadelBall implements Ball {
    private String name;
    private double price;
    private int stock;
    private File image;

    public PadelBall(String elementName, double elementPrice, int elementStock, File elementImage) {
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

    public File getImageName() {
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

    public void showImage() {
        SwingUtilities.invokeLater(() -> {
            JFrame imageFrame = new JFrame(name);
            imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            ImageIcon imageIcon = new ImageIcon(image.getAbsolutePath());
            JLabel imageLabel = new JLabel(imageIcon);

            imageFrame.add(imageLabel);
            imageFrame.pack();
            imageFrame.setVisible(true);
        });
    }
}
