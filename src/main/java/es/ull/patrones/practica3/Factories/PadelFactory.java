package es.ull.patrones.practica3.Factories;

import es.ull.patrones.practica3.Elements.*;
import es.ull.patrones.practica3.GUI.PadelElementViewer;
import es.ull.patrones.practica3.GUI.SportsElementViewer;

public class PadelFactory implements SportFactory {
    @Override
    public Ball createBall() {
        return new PadelBall(); // Implementa TennisBall
    }

    @Override
    public Footwear createFootwear() {
        return new PadelFootwear(); // Implementa TennisFootwear
    }

    @Override
    public TShirt createTShirt() {
        return new PadelTShirt();
    }

    @Override
    public SportsElementViewer createViewer() {
        return (SportsElementViewer) new PadelElementViewer(); // Pasa la instancia de PadelFactory al constructor de PadelElementViewer
    }

}