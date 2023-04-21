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
    setLayout(new FlowLayout());

    // 初始化按钮
    eatButton = new JButton("Feed");
    playButton = new JButton("Play");
    dreamButton = new JButton("Let's dream");

    // 将按钮添加到面板上
    add(eatButton);
    add(playButton);
    add(dreamButton);
  }

  // 重写 paintComponent 方法
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    // 在面板上绘制字符串
    //g.drawString("Hello, World!", 50, 50);
  }



}
