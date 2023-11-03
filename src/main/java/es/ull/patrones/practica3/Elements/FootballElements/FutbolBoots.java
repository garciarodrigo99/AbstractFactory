package es.ull.patrones.practica3.Elements.FootballElements;

import es.ull.patrones.practica3.Elements.Footwear;

public class FutbolBoots implements Footwear {
    private String link;
    private Double price;
    private Integer existencias;

    public FutbolBoots(String link, Double price, Integer existencias){
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
    public void putOn() {

    }

    @Override
    public String getDescription() {
        return "Football Boots: Name - " + "Botas de fútbol" + ", Price - $" + getPrice() + ", Stock - " + getExistencias() + " units";
    }

    @Override
    public String toString() {
        return "Botas de fútbol";
    }
}
