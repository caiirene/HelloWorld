package View;
import javax.swing.*;

public class Something {
  public static void main(String[] args) {
    JFrame frame = new JFrame("BasicPenal Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 200);

    BasicPenal basicPenal = new BasicPenal();
    frame.add(basicPenal);

    frame.setVisible(true);
  }
}
