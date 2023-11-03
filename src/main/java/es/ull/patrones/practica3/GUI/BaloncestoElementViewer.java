package es.ull.patrones.practica3.GUI;

import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Elements.Ball;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoBall;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoFootwear;
import es.ull.patrones.practica3.Elements.BasketballElements.BaloncestoTShirt;
import es.ull.patrones.practica3.Elements.Footwear;
import es.ull.patrones.practica3.Elements.TShirt;
import es.ull.patrones.practica3.Factories.BaloncestoFactory;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaloncestoElementViewer implements SportsElementViewer {
    private JList<String> elementList;
    private DefaultListModel<String> listModel;
    private List<Object> basketballElements = new ArrayList<>();
    private BaloncestoFactory baloncestoFactory;
    private BaloncestoBall baloncestoBall;
    private BaloncestoFootwear baloncestoFootwear;
    private BaloncestoTShirt baloncestoTshirt;
    private JLabel descriptionLabel;


    public BaloncestoElementViewer() throws CsvValidationException, IOException {
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
        baloncestoFactory = new BaloncestoFactory("sports_elements.csv");


        // Personaliza la apariencia de los componentes
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 12)); // Cambia la fuente y el tamaño
        descriptionLabel.setForeground(Color.BLACK);
        descriptionLabel.setSize(400,400);

        // Agrega un ActionListener al JList para manejar la selección de elementos
        elementList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = elementList.getSelectedIndex();
                Object selectedElement = basketballElements.get(selectedIndex);

                if (selectedElement instanceof Ball) {
                    descriptionLabel.setText(((Ball) selectedElement).getDescription());
                    BaloncestoBall baloncestoPel = ((BaloncestoBall) selectedElement);
                    showImage(baloncestoPel.getImageLink(),baloncestoPel.toString());
                } else if (selectedElement instanceof Footwear) {
                    descriptionLabel.setText(((Footwear) selectedElement).getDescription());
                    BaloncestoFootwear baloncestoFoot = ((BaloncestoFootwear) selectedElement);
                    showImage(baloncestoFoot.getImageLink(),baloncestoFoot.toString());
                } else if (selectedElement instanceof TShirt) {
                    descriptionLabel.setText(((TShirt) selectedElement).getDescription());
                    BaloncestoTShirt baloncestoTs = ((BaloncestoTShirt) selectedElement);
                    showImage(baloncestoTs.getImageLink(),baloncestoTs.toString());
                }
            }
        });

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(descriptionLabel, BorderLayout.SOUTH);
        frame.pack();

        loadAndDisplayElements();

        frame.setVisible(true);
    }

    @Override
    public void loadAndDisplayElements() {
        basketballElements = baloncestoFactory.loadElements();

        basketballElements.forEach(element -> {
            listModel.addElement(element.toString());
        });
    }

    private void showImage(String URL, String title){
        SwingUtilities.invokeLater(() -> {
            WindowPicture frame = new WindowPicture(URL,title);
            frame.setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new BaloncestoElementViewer();
            } catch (CsvValidationException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
