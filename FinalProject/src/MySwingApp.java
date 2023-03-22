import javax.swing.*;
import java.awt.*;

public class MySwingApp {
  public static void main(String[] args) {
    JFrame frame = new JFrame("My Application");
    frame.setSize(400, 300);
    frame.setLocationRelativeTo(null); // center the window on the screen

    JLabel label = new JLabel("Hello, World!");
    JButton button = new JButton("Click me");

    Container contentPane = frame.getContentPane();
    contentPane.setLayout(new BorderLayout());
    contentPane.add(label, BorderLayout.CENTER);
    contentPane.add(button, BorderLayout.SOUTH);

    frame.setVisible(true);
  }
}

