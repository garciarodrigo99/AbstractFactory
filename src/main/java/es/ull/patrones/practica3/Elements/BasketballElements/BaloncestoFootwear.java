package es.ull.patrones.practica3.Elements.BasketballElements;

import es.ull.patrones.practica3.Elements.Footwear;

public class BaloncestoFootwear implements Footwear {
    private double price;
    private int existences;
    private String imageLink;

    public BaloncestoFootwear(String imageLink, double price, int existences) {
        this.price = price;
        this.existences = existences;
        this.imageLink = imageLink;
        getDescription();
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getExistences() {
        return this.existences;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    @Override
    public String getDescription() {
        return this.price + " " + this.existences + " " + this.imageLink;
    }
    @Override
    public void putOn() {}

    @Override
    public String toString() {
        return "Tenis de Baloncesto";
    }

}
