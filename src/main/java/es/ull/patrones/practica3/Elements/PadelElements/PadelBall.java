package es.ull.patrones.practica3.Elements.PadelElements;

import es.ull.patrones.practica3.Elements.Ball;

public class PadelBall implements Ball {
    private String link;
    private Double price;
    private Integer existencias;

    public PadelBall(String link, Double price, Integer existencias){
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
        return "Padel Ball: Name - " + "Balón de Padel" + ", Price - $" + getPrice() + ", Stock - " + getExistencias() + " units";
    }

    @Override
    public String toString() {
        return "Balón de Padel";
    }
}
