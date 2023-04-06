import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class PetView implements PropertyChangeListener {
  private JFrame frame;
  private JLabel petLabel;
  private JButton eatButton;
  private Pet pet;
  public String normalGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\ChatGPTTeachingPet\\src\\天使.gif";
  public String lowHungerGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\ChatGPTTeachingPet\\src\\天使1.gif";
  public String eatingGifPath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\ChatGPTTeachingPet\\src\\天使2.gif";

  public PetView(Pet pet) { // 添加 Pet 参数
    this.pet = pet;
    this.frame = new JFrame("Desktop Pet");
    this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.petLabel = new JLabel(new ImageIcon(normalGifPath));
    this.eatButton = new JButton("Feed");

    this.frame.getContentPane().add(petLabel, BorderLayout.CENTER);
    this.frame.getContentPane().add(eatButton, BorderLayout.SOUTH);

    this.frame.pack();
    this.frame.setVisible(true);
    updateGifBasedOnHunger(pet.getHunger());

  }

  public JButton getEatButton() {
    return eatButton;
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
}
