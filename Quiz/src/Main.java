import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JPanel panel = new View();
    panel.setPreferredSize(new Dimension(400, 400));
    frame.add(panel);
    frame.pack();
    // by default, everything is invisible. Make it visible
    frame.setVisible(true);
  }}