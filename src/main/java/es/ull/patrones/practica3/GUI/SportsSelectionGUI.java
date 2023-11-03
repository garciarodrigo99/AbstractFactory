package es.ull.patrones.practica3.GUI;

import com.opencsv.exceptions.CsvValidationException;
import es.ull.patrones.practica3.Factories.SportFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class SportsSelectionGUI extends JFrame {
    private JComboBox<String> sportComboBox;
    private JButton selectSportButton;
    private Set<String> sports; // Almacena los deportes cargados desde el archivo CSV

    public SportsSelectionGUI() {
        setTitle("Sports Selection");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sports = downloadAndLoadCSV();

        JPanel sportsPanel = new JPanel();
        sportsPanel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);

        for (String sport : sports) {
            JButton sportButton = new JButton(sport);
            sportButton.setFont(new Font("Arial", Font.BOLD, 18));
            sportButton.setBackground(Color.decode("#3498db")); // Cambia el color de fondo
            sportButton.setForeground(Color.WHITE); // Cambia el color del texto
            sportButton.setFocusPainted(false); // Elimina el efecto de enfoque

            selectSportButton = new JButton("Seleccionar Deporte");
            sportButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String selectedSport = sport; // Obtiene el deporte seleccionado desde el botón
                    //SportFactory factory = createFactoryForSport(selectedSport);

                    if (selectedSport != null) {
                        // Por ejemplo, puedes llamar a un método para mostrar los elementos
                        try {
                            SportsElementViewer viewer = createViewerForSport(selectedSport);
                        } catch (CsvValidationException ex) {
                            throw new RuntimeException(ex);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }

                    } else {
                        // Maneja el caso en el que no se encuentre una fábrica o visor adecuado
                        System.out.println("No se encontró una fábrica o visor adecuado para el deporte seleccionado.");
                    }
                }
            });

            constraints.gridx = 0;
            constraints.gridy++;
            sportsPanel.add(sportButton, constraints);
        }

        JScrollPane scrollPane = new JScrollPane(sportsPanel);
        add(scrollPane, BorderLayout.CENTER);
        pack();
    }

    private boolean downloadCSVFromURL(String csvURL, String destinationPath) {
        try {
            URL url = new URL(csvURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                try (InputStream inputStream = connection.getInputStream();
                     FileOutputStream outputStream = new FileOutputStream(destinationPath)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }
                return true;
            } else {
                System.out.println("Error al descargar el archivo CSV. Código de respuesta: " + responseCode);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private Set<String> downloadAndLoadCSV() {
        String csvURL = "https://docs.google.com/spreadsheets/d/15CGlxvh_vx0DjN57niWwfaEO0sGDB-LB_9ls9-SQLQk/export?format=csv";
        String destinationPath = "sports_elements.csv";

        if (downloadCSVFromURL(csvURL, destinationPath)) {
            return sports = loadSportsFromCSV(destinationPath);
        }
        return null;
    }

    private Set<String> loadSportsFromCSV(String csvFileName) {
        Set<String> sportsSet = new HashSet<>();
        boolean skipFirstLine = true; // Variable para omitir la primera línea

        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (skipFirstLine) {
                    skipFirstLine = false; // Salta la primera línea
                    continue;
                }

                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    sportsSet.add(parts[1].trim()); // Suponiendo que N_Deporte está en la segunda columna
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sportsSet;
    }

    private SportsElementViewer createViewerForSport(String sport) throws CsvValidationException, IOException {
        // Implementa la creación de visores según la fábrica seleccionada
        if (sport != null) {
            // Por ejemplo, si tienes una implementación SportsElementViewer para cada deporte
            if(sport.equals("Baloncesto")){
                return new BaloncestoElementViewer();
            } else if(sport.equals("Padel")) {
                return new PadelElementViewer();
            }
            return new FootballElementViewer();
        }
        return null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SportsSelectionGUI gui = new SportsSelectionGUI();
            gui.setVisible(true);
        });
    }
}