package es.ull.patrones.practica3.Elements.BasketballElements;

import es.ull.patrones.practica3.Elements.Ball;

public class BaloncestoBall implements Ball {

    private String name;
    private double price;
    private int existences;
    private String imageLink;

    public BaloncestoBall(String imageLink, double price, int existences) {
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
    public void throwBall() {}

    @Override
    public String getDescription() {
        return this.price + " " + this.existences + " " + this.imageLink;
    }

    @Override
    public String toString() {
        return "Balón de Baloncesto";
    }
}
