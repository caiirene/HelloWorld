package Controller;

import Model.Food.Apple;
import Model.Food.Diesel;
import Model.Food.FoodBox;
import Model.Food.FoodBoxInterface;
import Model.Food.FoodInterface;
import Model.Food.Screwworm;
import Model.Food.Strawberry;
import Model.Pet.PetImpl;
import Model.Pet.PetInterface;
import View.FoodPenal;
import View.TotalView;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class PetController implements ActionListener, PropertyChangeListener {

  FoodBoxInterface foodBox;
  private PetInterface pet;
  private TotalView view;
  private Timer hungerTimer;
  private Timer checkDeathTimer;
  private Timer speakRandomlyTimer;
  private Timer tiredTimer;
  private Timer emergencyLoseHealthTimer;
  private Timer foodGeneratorTimer;

  /**
   * new game constructor
   * new pet with none parameters
   */
  public PetController() {
    pet = new PetImpl();
    //pet.getSupport().addPropertyChangeListener(this);
    view = new TotalView();
    view.basicPenal.getEatButton().addActionListener(this);
    view.basicPenal.getPlayButton().addActionListener(this);
    view.basicPenal.getDreamButton().addActionListener(this);

    pet.getSupport().addPropertyChangeListener(this);
    //System.out.println("Listeners count: " + pet.getSupport().getPropertyChangeListeners().length);

    //System.out.println("start create food box");
    foodBox = new FoodBox();
    foodBox.addFood(new Apple());
    foodBox.addFood(new Strawberry());
    foodBox.addFood(new Screwworm());
    foodBox.addFood(new Diesel());
    if (foodBox==null) {System.out.println("null food box");}

    //
    foodGeneratorTimer = new FoodGeneratorTimer(30000,foodBox);

    //创建timer
    createHungerTimer();
    createCheckDeathTimer();
    createSpeakRandomlyTimer();
    createTiredTimer();

  }
  /**
   * load game from recorded file
   * new pet object with a lot of parameters
   * NO TIME TO FINISH
   */
  public PetController(int anything) {
    // ......
  }


  @Override
  public void actionPerformed(ActionEvent e) {

    //feed按键
    if (e.getSource() == view.basicPenal.getEatButton()) {
      //先从foodBox中获取一串不重复的String名单
      List<String> foodList = foodBox.getDistinctListOfFoodName();

      FoodPenal foodPenal = new FoodPenal(foodList);
      //从foodPanel中获取list
      List<JButton> foodButtonList = foodPenal.getFoodButtonList();
      //遍历每个按键，安装监听器为一个新建的ActionListener，使用空降类
      for (JButton button : foodButtonList) {
        button.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e2) {
            FoodInterface providedFood = foodBox.provideFood(button.getText());
            if(providedFood!=null) {
              pet.eat(providedFood);
              //显示3秒的吃饭动画
              view.frame.setPetGif(view.frame.eatingGifPath);
              int delay = 3000; // 3 seconds in milliseconds
              Timer timer = new Timer(delay, event -> {
                view.frame.updateGifBasedOnHunger(pet.getHunger());
              });
              timer.setRepeats(false);
              timer.start();
            }
            else {pet.eatApple();} //如果暂时还没有食物就吃过苹果吧
            view.frame.getContentPane().remove(foodPenal); // 删除 temFoodPanel
            view.frame.revalidate(); // 触发界面重新布局
            view.frame.repaint(); // 重绘界面
          }
        });
      }

      view.frame.getContentPane().add(foodPenal, BorderLayout.WEST);
      //view.basicPenal.add(foodPenal); // 添加 foodPenal 到 basicPenal
      view.basicPenal.revalidate(); // 触发界面重新布局
      view.basicPenal.repaint(); // 重绘界面
    }

    if (e.getSource() == view.basicPenal.getPlayButton()) {
      pet.increaseHappiness();
      //显示3秒的玩耍动画
      view.frame.setPetGif(view.frame.eatingGifPath);
      int delay = 3000; // 3 seconds in milliseconds
      Timer timer = new Timer(delay, event -> {
        view.frame.updateGifBasedOnHunger(pet.getHunger());
      });
      timer.setRepeats(false);
      timer.start();

    } else if (e.getSource() == view.basicPenal.getDreamButton()) {
      JTextArea dreamTextArea = new JTextArea(10, 30); // 设置行数和列数
      dreamTextArea.setLineWrap(true);
      dreamTextArea.setWrapStyleWord(true);
      JScrollPane scrollPane = new JScrollPane(dreamTextArea);

      int result = JOptionPane.showConfirmDialog(view.frame, scrollPane, "Enter your pet's dream:", JOptionPane.OK_CANCEL_OPTION);

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
    System.out.println("监听器收到");
    if ("dead".equals(evt.getPropertyName())) {
      //System.out.println("监听器收到");
      boolean isDead = (boolean) evt.getNewValue();
      if (isDead == true) {
        System.out.println("在这里触发死亡 GIF");
        // 在这里触发死亡 GIF
        view.frame.updateGifBasedOnHealth(pet.getHealth());

        /////////////////////////
        // 停止所有 hungerTimer //
        /////////////////////////

        hungerTimer.stop();
        checkDeathTimer.stop();
        speakRandomlyTimer.stop();
        tiredTimer.stop();
        if (emergencyLoseHealthTimer!=null) {
          emergencyLoseHealthTimer.stop();
        }
        // 调用生成 txt 文件的方法，例如：
        pet.generateTxtFileFromDreams();
      }
    } else if ("hungerChange".equals(evt.getPropertyName())) {
      //System.out.println("hunger监听器已收到");
      int newHunger = (int)evt.getNewValue();
      if (newHunger<=0) {
        createEmergencyLoseHealth();
        String reallyHungry = pet.sayHungry();
        view.showSpeach(reallyHungry);
        speakRandomlyTimer.stop();
        hungerTimer.stop();
      } else if (newHunger > 0 && emergencyLoseHealthTimer!=null) {
        emergencyLoseHealthTimer.stop();
        speakRandomlyTimer.start();
        hungerTimer.start();
      }
      view.frame.updateGifBasedOnHunger(newHunger);
    } else if ("healthChange".equals(evt.getPropertyName())) {
      view.frame.updateGifBasedOnHealth(pet.getHealth());
      pet.checkDeath();
    } else if ("happinessChange".equals(evt.getPropertyName())) {
      view.frame.updateGifBasedOnHappiness(pet.getHappiness());
    }
  }

  private void createEmergencyLoseHealth() {
    int emergencyInterval = 5000; // 10 seconds in milliseconds
    emergencyLoseHealthTimer = new Timer(emergencyInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("controller 中触发紧急掉血");
        pet.loseHealthEmergency();
      }
    });
    emergencyLoseHealthTimer.start();
  }



  private void createHungerTimer() {
    int hungerInterval = 15000; // 10 seconds in milliseconds
    hungerTimer = new Timer(hungerInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.loseHungerWhileTimePass();
      }
    });
    hungerTimer.start();
    view.frame.updateGifBasedOnHunger(pet.getHunger());
  }
  private void createTiredTimer() {
    int hungerInterval = 50000; // 10 seconds in milliseconds
    tiredTimer = new Timer(hungerInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.loseHealth_GetTiredWhileTimePass();
      }
    });
    tiredTimer.start();
    view.frame.updateGifBasedOnHealth(pet.getHealth());
  }
  private void createSpeakRandomlyTimer() {
    int initialDelay = generateRandomInterval(5, 15);
    speakRandomlyTimer = new Timer(initialDelay * 1000, e -> {
      String message = pet.speakRandomly();
      view.showSpeach(message);

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
  private void createCheckDeathTimer() {
    int checkInterval = 100; // Check every 0.1 seconds (100 milliseconds)
    checkDeathTimer = new Timer(checkInterval, new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //System.out.println("death check in death timer");
        pet.checkDeath();
      }
    });
    checkDeathTimer.start();
  }

}