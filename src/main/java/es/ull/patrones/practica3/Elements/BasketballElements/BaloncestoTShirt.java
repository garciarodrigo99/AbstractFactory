package es.ull.patrones.practica3.Elements.BasketballElements;

import es.ull.patrones.practica3.Elements.TShirt;

public class BaloncestoTShirt implements TShirt {

    private double price;
    private int existences;
    private String imageLink;

    public BaloncestoTShirt(String imageLink, double price, int existences) {
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
    public void wearTShirt() {}

    @Override
    public String getDescription() {
        return this.price + " " + this.existences + " " + this.imageLink;
    }

    @Override
    public String toString() {
        return "Camisa de Baloncesto";
    }

}
