package View;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WindowFrame extends JFrame {

  public JButton closeButton;
  public JLabel petLabel;
  public String normalGifPath = ".\\t天使.gif";
  public String lowHungerGifPath = ".\\t天使1.gif";
  public String eatingGifPath = ".\\t天使2.gif";
  //public String normalGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\ChatGPTTeachingPet\\src\\天使死亡.png";
  public String deadGifPath = ".\\t天使死亡.png";

  public WindowFrame() {
    this.setSize(100,400);
    //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    //设置宠物图像
    ImageIcon imageIcon = new ImageIcon(normalGifPath);
    this.petLabel = new JLabel(imageIcon);
    this.getContentPane().add(petLabel);

    // 创建关闭按钮
    closeButton = new JButton("X");
    closeButton.addActionListener(e -> this.dispose());
    closeButton.setContentAreaFilled(false); // 设置按钮背景透明
    closeButton.setFocusPainted(false); // 去掉焦点边框
    closeButton.setBorder(BorderFactory.createEmptyBorder()); // 去掉边框
    closeButton.setFont(new Font("Arial", Font.PLAIN, 10)); // 设置字体大小

    this.getContentPane().add(closeButton, BorderLayout.NORTH);
    closeButton.addActionListener(e -> {
      this.dispose();
      System.exit(0); // 结束程序
    });
  }

  /*
  public static void main(String[] arg) {
    new WindowFrame();
  }
   */

}
