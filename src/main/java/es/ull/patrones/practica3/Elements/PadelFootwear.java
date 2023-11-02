package es.ull.patrones.practica3.Elements;

import es.ull.patrones.practica3.Elements.Footwear;

public class PadelFootwear implements Footwear {
    private String name;
    private double price;
    private int stock;
    private String image;
    public PadelFootwear(String elementName, double elementPrice, int elementStock, String elementImage) {
        this.name = elementName;
        this.price = elementPrice;
        this.stock = elementStock;
        this.image = elementImage;
        getDescription();
    }

    public PadelFootwear() {

    }

    @Override
    public void putOn() {

    }

    @Override
    public String getDescription() {
        return "Padel Footwear: Name - " + getName() + ", Price - $" + getPrice() + ", Stock - " + getStock() + " units";
    }

    public String getImageName() {
        return null;
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
}
