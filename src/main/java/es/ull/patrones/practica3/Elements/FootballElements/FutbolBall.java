package es.ull.patrones.practica3.Elements.FootballElements;

import es.ull.patrones.practica3.Elements.Ball;

public class FutbolBall implements Ball {
    private String link;
    private Double price;
    private Integer existencias;

    public FutbolBall(String link, Double price, Integer existencias){
        this.link = link;
        this.price = price;
        this.existencias = existencias;
    }

    public String getLink(){
        return this.link;
    }

    public Double getPrice(){
        return this.price;
    }

    public Integer getExistencias(){
        return this.existencias;
    }

    @Override
    public void throwBall() {

    }

    @Override
    public String getDescription() {
        return "Football Ball: Name - " + "Balón de fútbol" + ", Price - $" + getPrice() + ", Stock - " + getExistencias() + " units";
    }

    @Override
    public String toString() {
        return "Balón de fútbol";
    }
}
