package es.ull.patrones.practica3.GUI;

import es.ull.patrones.practica3.Elements.*;
import es.ull.patrones.practica3.Factories.PadelFactory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PadelElementViewer implements SportsElementViewer {
    private JList<String> elementList;
    private DefaultListModel<String> listModel;
    private List<Object> padelElements = new ArrayList<>();

    private PadelFactory padelFactory;
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
        padelFactory = new PadelFactory();

        //padelElements = padelFactory.getElement();

        // Personaliza la apariencia de los componentes
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Cambia la fuente y el tamaño
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setSize(400,400);

        JFrame image = new JFrame("Elementos de Padel");
        image.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        image.setSize(1000, 1000);
        image.setLocationRelativeTo(null);

        // Agrega un ActionListener al JList para manejar la selección de elementos
        elementList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = elementList.getSelectedIndex();
                Object selectedElement = padelElements.get(selectedIndex);

                if (selectedElement instanceof Ball) {
                    descriptionLabel.setText(((Ball) selectedElement).getDescription());
                    ((PadelBall) selectedElement).mostrarImage();
                } else if (selectedElement instanceof Footwear) {
                    descriptionLabel.setText(((Footwear) selectedElement).getDescription());
                    ((PadelFootwear) selectedElement).mostrarImage();
                } else if (selectedElement instanceof TShirt) {
                    descriptionLabel.setText(((TShirt) selectedElement).getDescription());
                    ((PadelTShirt) selectedElement).mostrarImage();
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
        padelElements = padelFactory.loadPadelElementsFromCSV("sports_elements.csv");

        padelElements.forEach(element -> {
            listModel.addElement(element.toString());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PadelElementViewer::new);
    }

}
