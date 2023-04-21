package View;

import java.awt.BorderLayout;
import javax.swing.JFrame;

public class TotalView {

  public WindowFrame frame = new WindowFrame();
  public BasicPenal basicPenal = new BasicPenal();
  public FoodPenal foodPenal;

  public TotalView() {
    frame.getContentPane().add(basicPenal, BorderLayout.SOUTH);
    this.frame.pack();
    this.frame.setVisible(true);
  }

}
