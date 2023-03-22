import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageDisplayExample {
  public static void main(String[] args) throws Exception {
    // Load the image from a file
    File imageFile = new File("C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\image.png");
    BufferedImage bufferedImage = ImageIO.read(imageFile);

    // Resize the image to fit within the frame
    Image scaledImage = bufferedImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);

    // Create a new ImageIcon from the resized image
    ImageIcon imageIcon = new ImageIcon(scaledImage);

    // Create a label to display the image
    JLabel imageLabel = new JLabel(imageIcon);

    // Create a frame to hold the label
    JFrame frame = new JFrame("Image Display");
    frame.getContentPane().add(imageLabel);
    frame.pack();
    frame.setVisible(true);

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}
