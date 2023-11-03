package es.ull.patrones.practica3.Factories;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Elements.*;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoBall;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoFootwear;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoTShirt;
import es.ull.patrones.practica3.GUI.SportsElementViewer;

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
    private final String ID_DEPORTE = "4";

    private List<String> cabecera; // Para almacenar la cabecera
    private List<String[]> basketballCsv = new ArrayList<>();

    public List<Object> getElement() {
        return padelElements;
    }
    public PadelFactory(String rutaCSV) {
        cabecera = null; // Inicialmente, la cabecera es nula

        listModel = new DefaultListModel<>();

        try {
            CSVReader reader = new CSVReader(new FileReader(rutaCSV));
            String[] linea;

            while ((linea = reader.readNext()) != null) {
                if (cabecera == null) {
                    // La primera línea es la cabecera
                    cabecera = List.of(linea);
                } else if (linea.length > 0 && linea[0].equals(ID_DEPORTE)) {
                    // Si la columna 0 es igual a 1, almacenar la fila
                    basketballCsv.add(linea);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public SportsElementViewer createViewer() {
        return null;
    }

    /*
        @Override
        public Ball createBall(String name, double price, int stock, String imagePath) {
            return new PadelBall(name, price, stock, imagePath);
        }

        @Override
        public Footwear createFootwear(String name, double price, int stock, String imagePath) {
            return new PadelFootwear(name, price, stock, imagePath);
        }

        @Override
        public TShirt createTShirt(String name, double price, int stock, String imagePath) {
            return new PadelTShirt(name, price, stock, imagePath);
        }
        */
    @Override
    public Ball createBall() {
        String idElemento = "10";
        String idObjeto = "1";
        for (String[] fElement : basketballCsv) {
            System.out.println(fElement[2]+"-"+fElement[7]);
            if (fElement[2].equals(idElemento) && fElement[7].equals(idObjeto)){
                return (new BaloncestoBall(fElement[4],
                        Double.parseDouble(fElement[5]),
                        Integer.parseInt(fElement[6])));
            }
        }
        return null;
    }

    @Override
    public Footwear createFootwear() {
        String idElemento = "11";
        String idObjeto = "1";
        for (String[] fElement : basketballCsv) {
            System.out.println(fElement[2]+"-"+fElement[7]);
            if (fElement[2].equals(idElemento) && fElement[7].equals(idObjeto)){
                return (new BaloncestoFootwear(fElement[4],
                        Double.parseDouble(fElement[5]),
                        Integer.parseInt(fElement[6])));
            }
        }
        return null;
    }

    @Override
    public TShirt createTShirt() {
        String idElemento = "12";
        String idObjeto = "1";
        for (String[] fElement : basketballCsv) {
            System.out.println(fElement[2]+"-"+fElement[7]);
            if (fElement[2].equals(idElemento) && fElement[7].equals(idObjeto)){
                return (new BaloncestoTShirt(fElement[4],
                        Double.parseDouble(fElement[5]),
                        Integer.parseInt(fElement[6])));
            }
        }
        return null;
    }

    @Override
    public List<Object> loadElements() {
        List<Object> lo = new ArrayList<>(); // Inicializa la lista;
        lo.add(createBall());
        lo.add(createFootwear());
        lo.add(createTShirt());
        return lo;
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
                        padelBall = new PadelBall();
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