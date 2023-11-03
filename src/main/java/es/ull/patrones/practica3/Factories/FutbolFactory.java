package es.ull.patrones.practica3.Factories;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Elements.Ball;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolBall;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolBoots;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolTShirt;
import es.ull.patrones.practica3.Elements.Footwear;
import es.ull.patrones.practica3.Elements.TShirt;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FutbolFactory implements SportFactory{
    private String ID_DEPORTE = "1";
    private List<String> cabecera = null; // Para almacenar la cabecera
    private List<String[]> footballCSV = new ArrayList<>();
    public FutbolFactory(String rutaCSV) throws IOException, CsvValidationException {

        try {
            CSVReader reader = new CSVReader(new FileReader(rutaCSV));
            String[] linea;

            while ((linea = reader.readNext()) != null) {
                if (cabecera == null) {
                    // La primera línea es la cabecera
                    cabecera = List.of(linea);
                } else if (linea.length > 0 && linea[0].equals(ID_DEPORTE)) {
                    // Si la columna 0 es igual a 1, almacenar la fila como un array de String
                    footballCSV.add(linea);
                }
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Ball createBall() {
        String idElemento = "1";
        String idObjeto = "1";
        for (String[] fElement : footballCSV) {
            if (fElement[2].equals(idElemento) && fElement[7].equals(idObjeto)){
                return (new FutbolBall(fElement[4],
                        Double.parseDouble(fElement[5]),
                        Integer.parseInt(fElement[6])));
            }
        }
        return null;
    }

    @Override
    public Footwear createFootwear() {
        String idElemento = "2";
        String idObjeto = "1";
        for (String[] fElement : footballCSV) {
            if (fElement[2].equals(idElemento) && fElement[7].equals(idObjeto)){
                return (new FutbolBoots(fElement[4],
                        Double.parseDouble(fElement[5]),
                        Integer.parseInt(fElement[6])));
            }
        }
        return null;
    }

    @Override
    public TShirt createTShirt() {
        String idElemento = "3";
        String idObjeto = "1";
        for (String[] fElement : footballCSV) {
            if (fElement[2].equals(idElemento) && fElement[7].equals(idObjeto)){
                return (new FutbolTShirt(fElement[4],
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
}
