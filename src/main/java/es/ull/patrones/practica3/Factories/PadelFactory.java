package es.ull.patrones.practica3.Factories;

import es.ull.patrones.practica3.Elements.*;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PadelFactory implements SportFactory {
    private DefaultListModel<String> listModel;
    private List<Object> padelElements = new ArrayList<>();
    private PadelBall padelBall;
    private PadelFootwear padelFootwear;
    private PadelTShirt padelTshirt;

    public List<Object> getElement() {
        return padelElements;
    }
    public PadelFactory() {
        listModel = new DefaultListModel<>();

    }
    @Override
    public Ball createBall(String name, double price, int stock, String imagePath) {
        return new PadelBall(name, price, stock, imagePath);
    }

    @Override
    public Footwear createFootwear(String name, double price, int stock, String imagePath) {
        return new PadelFootwear(name, price, stock, imagePath); // Implementa TennisFootwear
    }

    @Override
    public TShirt createTShirt(String name, double price, int stock, String imagePath) {
        return new PadelTShirt(name, price, stock, imagePath);
    }
    public List<Object> loadPadelElementsFromCSV(String csvFileName) {
        List<Object> sportsSet = new ArrayList<>();

        boolean skipFirstLine = true;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String type = parts[1].trim();
                    String name = parts[3].trim();
                    String imagePath = parts[4].trim();

                    double price = Double.parseDouble(parts[5].trim());
                    int stock = Integer.parseInt(parts[6].trim());

                    //System.out.println("Type: " + type);
                    //System.out.println("Name: " + name);

                    if ("Pelota de Padel".equals(name)) {
                        padelBall = new PadelBall(name, price, stock, imagePath);
                        sportsSet.add(padelBall);
                    } else if ("Raqueta de Padel".equals(name) || "Zapatilla de Padel".equals(name)) {
                        padelFootwear = new PadelFootwear(name, price, stock, imagePath);
                        sportsSet.add(padelFootwear);
                    } else if ("Camiseta de Padel".equals(name)) {
                        padelTshirt = new PadelTShirt(name, price, stock, imagePath);
                        sportsSet.add(padelTshirt);
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sportsSet;
    }
}