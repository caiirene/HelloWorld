import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JPanel;

public class PetView implements PropertyChangeListener {
  public JFrame frame;
  public JLabel petLabel;
  private JButton eatButton;
  private JButton playButton;
  private JButton dreamButton;
  private Pet pet;
  public String normalGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使.gif";
  public String lowHungerGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使1.gif";
  public String eatingGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使2.gif";
  //public String normalGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\ChatGPTTeachingPet\\src\\天使死亡.png";
  public String deadGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\AChess\\src\\t天使死亡.png";


  public PetView(Pet pet) { // 添加 Pet 参数
    this.pet = pet;
    this.frame = new JFrame("Desktop Pet");
    this.frame.setSize(400,400);
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ImageIcon imageIcon = new ImageIcon(deadGifPath);

    this.petLabel = new JLabel(imageIcon);
    this.frame.getContentPane().add(petLabel);

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
}
