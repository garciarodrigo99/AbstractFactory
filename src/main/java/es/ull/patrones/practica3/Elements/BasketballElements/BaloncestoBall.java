package es.ull.patrones.practica3.Elements.BasketballElements;

import es.ull.patrones.practica3.Elements.Ball;

public class BaloncestoBall implements Ball {

    private String name;
    private double price;
    private int existences;
    private String imageLink;

    public BaloncestoBall(String imageLink, double price, int existences) {
        this.price = price;
        this.existences = existences;
        this.imageLink = imageLink;
        getDescription();
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getExistences() {
        return this.existences;
    }

    public String getImageLink() {
        return this.imageLink;
    }

    @Override
    public void throwBall() {}

    @Override
    public String getDescription() {
        return this.price + " " + this.existences + " " + this.imageLink;
    }

    @Override
    public String toString() {
        return "Balón de Baloncesto";
    }


//    public void showImage() {
//        try {
//            URL url = new URL(getImage());
//            BufferedImage image = ImageIO.read(url);
//
//            if (image != null) {
//                // Display the image in a JLabel
//                ImageIcon icon = new ImageIcon(image);
//                JLabel imageLabel = new JLabel(icon);
//
//                // Create a dialog to display the image
//                JFrame imageFrame = new JFrame("Padel Ball Image");
//                imageFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//                imageFrame.getContentPane().add(imageLabel);
//                imageFrame.pack();
//                imageFrame.setVisible(true);
//            } else {
//                System.err.println("Image is null. It may not be in a supported format.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
