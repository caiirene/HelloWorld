import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer; // 使用正确的 Timer 类

public class PetController implements ActionListener {
  private Pet pet;
  private PetView petView;
  private Timer hungerTimer;

  public PetController(Pet pet, PetView petView) {
    this.pet = pet;
    this.petView = petView;
    petView.getEatButton().addActionListener(this);

    pet.addPropertyChangeListener(petView);

    // 创建一个定时器，每隔一段时间（例如10秒）调用一次 getHungryWhileTimePass()
    int hungerInterval = 10000; // 10 seconds in milliseconds
    hungerTimer = new Timer(hungerInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.getHungryWhileTimePass();
        //System.out.println("hunger-25 in controller");
      }
    });
    hungerTimer.start();
    updateViewGifBasedOnHunger();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == petView.getEatButton()) {
      pet.eat();
      petView.setPetGif(petView.eatingGifPath);

      int delay = 3000; // 3 seconds in milliseconds
      Timer timer = new Timer(delay, event -> {
        updateViewGifBasedOnHunger();
      });
      timer.setRepeats(false);
      timer.start();
    }
  }

  public void updateViewGifBasedOnHunger() {
    petView.updateGifBasedOnHunger(pet.getHunger());
  }
}
