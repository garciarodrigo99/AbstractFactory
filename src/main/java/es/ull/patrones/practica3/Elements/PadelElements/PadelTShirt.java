package es.ull.patrones.practica3.Elements.PadelElements;

import es.ull.patrones.practica3.Elements.TShirt;

public class PadelTShirt implements TShirt {
    private String link;
    private Double price;
    private Integer existencias;

    public PadelTShirt(String link, Double price, Integer existencias){
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
        return "Padel T-Shirts: Name - " + "Camiseta de Padel" + ", Price - $" + getPrice() + ", Stock - " + getExistencias() + " units";
    }

    @Override
    public String toString() {
        return "Camiseta de Padel";
    }
}
