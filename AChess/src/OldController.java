import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer; // 使用正确的 Timer 类

public class OldController implements ActionListener,PropertyChangeListener{
  private Pet pet;
  private PetView petView;
  private Timer hungerTimer;
  private Timer checkDeathTimer;
  private Timer speakRandomlyTimer;


  public OldController(Pet pet, PetView petView) {
    this.pet = pet;
    this.petView = petView;
    petView.getEatButton().addActionListener(this);
    petView.getPlayButton().addActionListener(this);
    petView.getDreamButton().addActionListener(this);

    pet.addPropertyChangeListener(petView);
    pet.getSupport().addPropertyChangeListener(this);

    // 创建一个定时器，每隔一段时间（例如10秒）调用一次 getHungryWhileTimePass()
    createHungerTimer();
    createCheckDeathTimer();
    createSpeakRandomlyTimer();

  }


  private void createHungerTimer() {
    int hungerInterval = 15000; // 10 seconds in milliseconds
    hungerTimer = new Timer(hungerInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.getHungryWhileTimePass();
      }
    });
    hungerTimer.start();
    updateViewGifBasedOnHunger();
  }

  private void createCheckDeathTimer() {
    int checkInterval = 100; // Check every 0.1 seconds (100 milliseconds)
    checkDeathTimer = new Timer(checkInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //System.out.println("death check in death timer");
        checkDeath();
      }
    });
    checkDeathTimer.start();

  }

  private void checkDeath() {
    if (pet.getHealth() == 0 && !pet.isDead()) {
      pet.setDead(true);
      System.out.println("hunger time should stop now\n");
      updateViewGifBasedOnDeath();
      hungerTimer.stop();
    }
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
    if (e.getSource() == petView.getPlayButton()) {
      pet.increaseHappiness();

    } else if (e.getSource() == petView.getDreamButton()) {
      JTextArea dreamTextArea = new JTextArea(10, 30); // 设置行数和列数
      dreamTextArea.setLineWrap(true);
      dreamTextArea.setWrapStyleWord(true);
      JScrollPane scrollPane = new JScrollPane(dreamTextArea);

      int result = JOptionPane.showConfirmDialog(petView.frame, scrollPane, "Enter your pet's dream:", JOptionPane.OK_CANCEL_OPTION);

      if (result == JOptionPane.OK_OPTION) {
        String dream = dreamTextArea.getText();
        if (dream != null && !dream.trim().isEmpty()) {
          pet.addDream(dream);
        }
      }
    }
  }



  @Override
  public void propertyChange(PropertyChangeEvent evt) {
    if ("dead".equals(evt.getPropertyName())) {
      boolean isDead = (boolean) evt.getNewValue();
      if (isDead) {
        // 在这里触发死亡 GIF
        petView.setPetGif(petView.deadGifPath);
        // 停止 hungerTimer
        hungerTimer.stop();

        // 调用生成 txt 文件的方法，例如：
        pet.generateTxtFileFromDreams();
      }
    } else if ("hunger".equals(evt.getPropertyName())) {
      // 处理 hunger 属性更改
      // ...
    }
  }



  public void updateViewGifBasedOnHunger() {
    petView.updateGifBasedOnHunger(pet.getHunger());
  }

  public void updateViewGifBasedOnDeath() {
    petView.updateGifBasedOnDeath(pet.isDead());
  }


  private void createSpeakRandomlyTimer() {
    int initialDelay = generateRandomInterval(5, 15);
    speakRandomlyTimer = new Timer(initialDelay * 1000, e -> {
      String message = pet.speakRandomly();
      petView.showMessage(message);

      // 设置下一次说话的时间间隔
      int nextInterval = generateRandomInterval(5, 15);
      speakRandomlyTimer.setInitialDelay(nextInterval * 1000);
      speakRandomlyTimer.restart();
    });
    speakRandomlyTimer.setRepeats(false);
    speakRandomlyTimer.start();
  }

  private int generateRandomInterval(int minSeconds, int maxSeconds) {
    Random random = new Random();
    return random.nextInt(maxSeconds - minSeconds + 1) + minSeconds;
  }
}
