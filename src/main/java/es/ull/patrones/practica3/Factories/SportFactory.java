package es.ull.patrones.practica3.Factories;

import es.ull.patrones.practica3.Elements.Ball;
import es.ull.patrones.practica3.Elements.Footwear;
import es.ull.patrones.practica3.Elements.TShirt;
import es.ull.patrones.practica3.GUI.SportsElementViewer;

public interface SportFactory {
    Ball createBall();
    Footwear createFootwear();
    TShirt createTShirt();

    SportsElementViewer createViewer();
}
