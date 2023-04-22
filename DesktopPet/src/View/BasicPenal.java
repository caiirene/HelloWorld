package View;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BasicPenal extends JPanel {

  public JButton eatButton;
  public JButton playButton;
  public JButton dreamButton;

  public BasicPenal() {
    // 设定布局
    setLayout(new GridLayout(1, 3));

    // 初始化按钮
    eatButton = new JButton("Feed");
    playButton = new JButton("Play");
    dreamButton = new JButton("Let's dream");

    // 将按钮添加到面板上
    add(eatButton);
    add(playButton);
    add(dreamButton);
  }

  public JButton getEatButton() {
    return eatButton;
  }
  public JButton getPlayButton() {
    return playButton;
  }
  public JButton getDreamButton() {
    return dreamButton;
  }

}
