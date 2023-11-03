package es.ull.patrones.practica3.Elements.FootballElements;

import es.ull.patrones.practica3.Elements.TShirt;

public class FutbolTShirt implements TShirt {
    private String link;
    private Double price;
    private Integer existencias;

    public FutbolTShirt(String link, Double price, Integer existencias){
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
    public void wearTShirt() {

    }

    @Override
    public String getDescription() {
        return "Football T-Shirts: Name - " + "Camiseta de fútbol" + ", Price - $" + getPrice() + ", Stock - " + getExistencias() + " units";
    }

    @Override
    public String toString() {
        return "Camiseta de fútbol";
    }
}
