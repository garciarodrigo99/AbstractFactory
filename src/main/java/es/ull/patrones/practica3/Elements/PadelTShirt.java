package es.ull.patrones.practica3.Elements;

import es.ull.patrones.practica3.Elements.TShirt;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class PadelTShirt implements TShirt {
    private String name;
    private double price;
    private int stock;
    private String image;
    public PadelTShirt(String elementName, double elementPrice, int elementStock, String elementImage) {
        this.name = elementName;
        this.price = elementPrice;
        this.stock = elementStock;
        this.image = elementImage;
        getDescription();
    }

    public PadelTShirt() {

    }

    @Override
    public void wearTShirt() {

    }

    @Override
    public String getDescription() {
        return "Padel Tshirt: Name - " + getName() + ", Price - $" + getPrice() + ", Stock - " + getStock() + " units";
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

    @Override
    public String toString() {
        return this.getName(); // Suponiendo que la clase PadelBall tiene un método getName() que devuelve el nombre del elemento.
    }

    public void mostrarImage() {
        SwingUtilities.invokeLater(() -> {
            ImageDisplayFrame frame = new ImageDisplayFrame(getImage());
            frame.setVisible(true);
        });
    }
}
