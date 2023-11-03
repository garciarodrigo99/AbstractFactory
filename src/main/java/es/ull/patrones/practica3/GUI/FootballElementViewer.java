package es.ull.patrones.practica3.GUI;

import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Elements.*;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolBall;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolBoots;
import es.ull.patrones.practica3.Elements.FootballElements.FutbolTShirt;
import es.ull.patrones.practica3.Factories.FutbolFactory;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FootballElementViewer implements SportsElementViewer {
    private JList<String> elementList;
    private DefaultListModel<String> listModel;
    private List<Object> footballElements = new ArrayList<>();

    private FutbolFactory footballFactory;
    private FutbolBall footballBall;
    private FutbolBoots footballBoots;
    private FutbolTShirt footballTShirt;
    private JLabel descriptionLabel;


    public FootballElementViewer() throws CsvValidationException, IOException {
        JFrame frame = new JFrame("Elementos de Fútbol");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);

        listModel = new DefaultListModel<>();
        elementList = new JList<>(listModel);
        elementList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar un elemento a la vez

        JScrollPane scrollPane = new JScrollPane(elementList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega un margen alrededor del JScrollPane


        descriptionLabel = new JLabel();
        footballFactory = new FutbolFactory("sports_elements.csv");

        // Personaliza la apariencia de los componentes
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Cambia la fuente y el tamaño
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setSize(400,400);

        // Agrega un ActionListener al JList para manejar la selección de elementos
        elementList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = elementList.getSelectedIndex();
                Object selectedElement = footballElements.get(selectedIndex);

                if (selectedElement instanceof Ball) {
                    descriptionLabel.setText(((Ball) selectedElement).getDescription());
                    FutbolBall fb = ((FutbolBall) selectedElement);
                    mostrarImagen(fb.getLink(),fb.toString());
                } else if (selectedElement instanceof Footwear) {
                    descriptionLabel.setText(((Footwear) selectedElement).getDescription());
                    FutbolBoots fb = ((FutbolBoots) selectedElement);
                    mostrarImagen(fb.getLink(),fb.toString());
                } else if (selectedElement instanceof TShirt) {
                    descriptionLabel.setText(((TShirt) selectedElement).getDescription());
                    FutbolTShirt fts = ((FutbolTShirt) selectedElement);
                    mostrarImagen(fts.getLink(),fts.toString());
                }
            }
        });

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(descriptionLabel, BorderLayout.SOUTH);
        frame.pack();

        loadAndDisplayElements();

        frame.setVisible(true);
    }

    public void loadAndDisplayElements() {
        footballElements = footballFactory.loadElements();

        footballElements.forEach(element -> {
            listModel.addElement(element.toString());
        });
    }

    private void mostrarImagen(String URL, String titulo){
        SwingUtilities.invokeLater(() -> {
            ventanaImagen frame = new ventanaImagen(URL,titulo);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new FootballElementViewer();
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

}