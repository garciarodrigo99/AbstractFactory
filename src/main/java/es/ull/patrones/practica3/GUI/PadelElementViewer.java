package es.ull.patrones.practica3.GUI;

import es.ull.patrones.practica3.Elements.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PadelElementViewer implements SportsElementViewer {
    private JList<String> elementList;
    private DefaultListModel<String> listModel;
    private List<Object> padelElements = new ArrayList<>();
    private PadelBall padelBall;
    private PadelFootwear padelFootwear;
    private PadelTShirt padelTshirt;
    private JLabel descriptionLabel;

    public PadelElementViewer() {
        JFrame frame = new JFrame("Elementos de Padel");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setLocationRelativeTo(null);


        listModel = new DefaultListModel<>();
        elementList = new JList<>(listModel);
        elementList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Solo se puede seleccionar un elemento a la vez

        JScrollPane scrollPane = new JScrollPane(elementList);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Agrega un margen alrededor del JScrollPane


        descriptionLabel = new JLabel();


        // Personaliza la apariencia de los componentes
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Cambia la fuente y el tamaño
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setSize(400,400);

        // Agrega un ActionListener al JList para manejar la selección de elementos
        elementList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = elementList.getSelectedIndex();
                Object selectedElement = padelElements.get(selectedIndex);

                if (selectedElement instanceof Ball) {
                    descriptionLabel.setText(((Ball) selectedElement).getDescription());
                    ((PadelBall) selectedElement).showImage();
                } else if (selectedElement instanceof Footwear) {
                    descriptionLabel.setText(((Footwear) selectedElement).getDescription());
                } else if (selectedElement instanceof TShirt) {
                    descriptionLabel.setText(((TShirt) selectedElement).getDescription());
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
        List<Object> padelElements = loadPadelElementsFromCSV("sports_elements.csv");

        padelElements.forEach(element -> {
            listModel.addElement(element.toString());
        });
    }

    private List<Object> loadPadelElementsFromCSV(String csvFileName) {
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


                    //URL imageUrl = new URL(imagePath);
                    //BufferedImage image = ImageIO.read(imageUrl);

                    System.out.print(imagePath);
                    double price = Double.parseDouble(parts[5].trim());
                    int stock = Integer.parseInt(parts[6].trim());

                    //System.out.println("Type: " + type);
                    //System.out.println("Name: " + name);

                    if ("Pelota de Padel".equals(name)) {
                        padelBall = new PadelBall(name, price, stock, imagePath);
                        padelElements.add(padelBall);
                    } else if ("Raqueta de Padel".equals(name) || "Zapatilla de Padel".equals(name)) {
                        padelFootwear = new PadelFootwear(name, price, stock, imagePath);
                        padelElements.add(padelFootwear);
                    } else if ("Camiseta de Padel".equals(name)) {
                        padelTshirt = new PadelTShirt(name, price, stock, imagePath);
                        padelElements.add(padelTshirt);
                    }

                    if (type.equals("Padel")) {
                        sportsSet.add(name);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return sportsSet;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PadelElementViewer::new);
    }
}
