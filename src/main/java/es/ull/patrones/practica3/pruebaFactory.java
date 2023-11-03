package es.ull.patrones.practica3;

import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolBall;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolBoots;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolTShirt;
import es.ull.patrones.practica3.Factories.FutbolFactory;

import java.io.IOException;

public class pruebaFactory {
    public static void main(String[] args) throws CsvValidationException, IOException {
        FutbolFactory ff = new FutbolFactory("sports_elements.csv");
        FutbolBall fb = (FutbolBall) ff.createBall();
        System.out.println(fb.getLink());
        System.out.println(fb.getPrice());
        System.out.println(fb.getExistencias());

        FutbolBoots fboots = (FutbolBoots) ff.createFootwear();
        System.out.println(fboots.getLink());
        System.out.println(fboots.getPrice());
        System.out.println(fboots.getExistencias());

        FutbolTShirt fts = (FutbolTShirt) ff.createTShirt();
        System.out.println(fts.getLink());
        System.out.println(fts.getPrice());
        System.out.println(fts.getExistencias());
    }
}
