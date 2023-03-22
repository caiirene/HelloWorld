import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ImageMoveExample extends JFrame implements ActionListener {
  private JLabel imageLabel;
  private Timer timer;
  private int x = 0;
  private int y = 0;

  public ImageMoveExample() {
    // Load the image from a file
    BufferedImage bufferedImage = null;
    try {
      bufferedImage = ImageIO.read(new File("C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\image.png"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }

    // Scale down the image to a new size of 400x300 pixels
    Image scaledImage = bufferedImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);

    // Create a new ImageIcon object from the scaled image
    ImageIcon imageIcon = new ImageIcon(scaledImage);

    // Create a label to display the image
    imageLabel = new JLabel(imageIcon);
    getContentPane().add(imageLabel);

    // Create a timer to update the image position
    timer = new Timer(50, this);
    timer.start();

    // Set the size and visibility of the frame
    setSize(400, 300);
    setVisible(true);
  }

  public void actionPerformed(ActionEvent e) {
    // Update the image position
    x += 5;
    y += 5;
    imageLabel.setLocation(x, y);
  }

  public static void main(String[] args) {
    // Create a new instance of the ImageMoveExample class
    ImageMoveExample frame = new ImageMoveExample();

    frame.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

}
