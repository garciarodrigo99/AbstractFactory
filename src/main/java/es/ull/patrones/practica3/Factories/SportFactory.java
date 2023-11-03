package es.ull.patrones.practica3.Factories;

import es.ull.patrones.practica3.Elements.Ball;
import es.ull.patrones.practica3.Elements.Footwear;
import es.ull.patrones.practica3.Elements.TShirt;

public interface SportFactory {
    Ball createBall(String name, double price, int stock, String imagePath);
    Footwear createFootwear(String name, double price, int stock, String imagePath);
    TShirt createTShirt(String name, double price, int stock, String imagePath);

    //SportsElementViewer createViewer();
}
