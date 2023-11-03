package es.ull.patrones.practica3.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
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

    @Override
    public String toString() {
        return this.getName(); // Suponiendo que la clase PadelBall tiene un método getName() que devuelve el nombre del elemento.
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void mostrarImage() {
        SwingUtilities.invokeLater(() -> {
            ImageDisplayFrame frame = new ImageDisplayFrame(image);
            frame.setVisible(true);
        });
    }
}






