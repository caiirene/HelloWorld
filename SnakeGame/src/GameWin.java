import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;


public class GameWin extends JFrame {

  public void launch() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("贪吃蛇");
    this.setSize(620, 640);

    SnakeGrid snakeGrid = new SnakeGrid();
    snakeGrid.setPreferredSize(new Dimension(600, 600));
    this.add(snakeGrid);

    this.pack();
    this.setLocationRelativeTo(null);
    this.setVisible(true);
  }

  public static void main(String arg[]) {
    GameWin myWin = new GameWin();
    myWin.launch();
  }
}