import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PetView implements PropertyChangeListener {
  public JFrame frame;
  public JLabel petLabel;
  private JButton eatButton;
  private JButton playButton;
  private JButton dreamButton;
  private JLabel petSpeechLabel;
  private JButton closeButton;
  private Point mouseClickPoint;
  private Pet pet;
  public String normalGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使.gif";
  public String lowHungerGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使1.gif";
  public String eatingGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使2.gif";
  //public String normalGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\ChatGPTTeachingPet\\src\\天使死亡.png";
  public String deadGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使死亡.png";


  public PetView(Pet pet) { // 添加 Pet 参数
    this.pet = pet;
    this.frame = new JFrame("Desktop Pet");
    this.frame.setSize(100,400);
    frame.setUndecorated(true);
    frame.setBackground(new Color(0, 0, 0, 0));
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // 设置窗口在屏幕右下角
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    frame.setLocation(screenSize.width - frame.getWidth()-200, screenSize.height - frame.getHeight()+100);


    // 创建关闭按钮
    closeButton = new JButton("X");
    closeButton.addActionListener(e -> frame.dispose());
    closeButton.setContentAreaFilled(false); // 设置按钮背景透明
    closeButton.setFocusPainted(false); // 去掉焦点边框
    closeButton.setBorder(BorderFactory.createEmptyBorder()); // 去掉边框
    closeButton.setFont(new Font("Arial", Font.PLAIN, 10)); // 设置字体大小

    frame.getContentPane().add(closeButton, BorderLayout.NORTH);
    closeButton.addActionListener(e -> {
      frame.dispose();
      System.exit(0); // 结束程序
    });

    //设置宠物图像
    ImageIcon imageIcon = new ImageIcon(normalGifPath);

    this.petLabel = new JLabel(imageIcon);
    this.frame.getContentPane().add(petLabel);

    //设置基本选项
    this.eatButton = new JButton("Feed");
    playButton = new JButton("Play");
    dreamButton = new JButton("Let's dream");

    JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
    buttonPanel.add(eatButton);
    buttonPanel.add(playButton);
    buttonPanel.add(dreamButton);

    frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    this.frame.pack();
    this.frame.setVisible(true);
    //updateGifBasedOnHunger(pet.getHunger());

    //宠物对话框初始化
    petSpeechLabel = new JLabel();
    petSpeechLabel.setFont(new Font("Arial", Font.PLAIN, 12));
    petSpeechLabel.setHorizontalAlignment(JLabel.CENTER);
    petSpeechLabel.setVerticalAlignment(JLabel.TOP);
    petSpeechLabel.setBounds(20, 200, 200, 30);
    frame.add(petSpeechLabel);


    //添加鼠标监听器，为了能够拖动无框宠物
    frame.addMouseListener(new MouseAdapter() {
      @Override
      public void mousePressed(MouseEvent e) {
        mouseClickPoint = e.getPoint();
      }
    });
    frame.addMouseMotionListener(new MouseAdapter() {
      @Override
      public void mouseDragged(MouseEvent e) {
        Point currentPoint = e.getLocationOnScreen();
        frame.setLocation(currentPoint.x - mouseClickPoint.x, currentPoint.y - mouseClickPoint.y);
      }
    });
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

  public void setPetGif(String gifPath) {
    petLabel.setIcon(new ImageIcon(gifPath));
  }

  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if ("hunger".equals(evt.getPropertyName())) {
      int newHunger = (int) evt.getNewValue();
      updateGifBasedOnHunger(newHunger);
    }
  }

  public void updateGifBasedOnHunger(int hunger) {
    if (hunger <= 60) {
      setPetGif(lowHungerGifPath);
    } else {
      setPetGif(normalGifPath);
    }
  }

  public void updateGifBasedOnDeath(boolean dead) {
    if (dead) {
      setPetGif(deadGifPath);
    }
  }

  public void showMessage(String message) {
    petSpeechLabel.setText(message);
  }
}
