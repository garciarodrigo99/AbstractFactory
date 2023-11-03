package es.ull.patrones.practica3.Factories;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Elements.Ball;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoBall;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoFootwear;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoTShirt;
import es.ull.patrones.practica3.Elements.Footwear;
import es.ull.patrones.practica3.Elements.TShirt;
import es.ull.patrones.practica3.GUI.SportsElementViewer;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class BaloncestoFactory implements SportFactory {

//    private List<Object> lo;

    private final String ID_DEPORTE = "4";

    private List<String> cabecera; // Para almacenar la cabecera
    private List<String[]> basketballCsv = new ArrayList<>();

    public BaloncestoFactory(String rutaCSV) throws IOException, CsvValidationException {
        cabecera = null; // Inicialmente, la cabecera es nula

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
        }
    }

    public BaloncestoFactory() {}

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
//
//    @Override
//    public SportsElementViewer createViewer() {
//        return null;
//    }
}
