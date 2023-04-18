import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class SnakeGrid extends JPanel {

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    g.setColor(Color.GRAY);
    g.fillRect(0, 0, 30, 600);
    g.setColor(Color.BLACK);
    for (int i = 1; i <= 30; i++) {
      g.drawLine(0, 20 * i, 600, 20 * i);
      g.drawLine(20 * i, 0, 20 * i, 600);
    }
  }
}