import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Pet {
  private String name;
  private int hunger = 100;
  private int happiness = 100;
  private boolean dead;
  private int health = 100;
  private ArrayList<String> dreams = new ArrayList<>();

  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  public int getHunger(){
    return hunger;
  }

  public void addPropertyChangeListener(PropertyChangeListener listener) {
    support.addPropertyChangeListener(listener);
  }

  public PropertyChangeSupport getSupport(){return support;}

  public void removePropertyChangeListener(PropertyChangeListener listener) {
    support.removePropertyChangeListener(listener);
  }

  public void increaseHappiness() {
    int oldHappiness = this.happiness;
    happiness = Math.min(happiness + 10, 100);
    support.firePropertyChange("happiness", oldHappiness, this.happiness);
  }

  public void addDream(String dream) {
    System.out.println("got the dream"+dream);
    dreams.add(dream);
  }

  public void die() {dead= true;}

  public void getHungryWhileTimePass() {
    int oldHunger = this.hunger;
    // 在这里编写逻辑以根据时间流逝增加宠物的饥饿感
    // 例如：hunger = Math.max(hunger - 1, 0);
    System.out.println("hunger-25 in pet");
    hunger = Math.max(hunger - 25, 0);
    System.out.println("hunger, " + this.hunger);
    if (hunger == 0 && !dead) {
      setDead(true);
    }
    support.firePropertyChange("hunger", oldHunger, this.hunger);
  }

  public Pet(String name) {
    this.name = name;
  }


  public void eat() {
    int oldHunger = this.hunger;
    this.hunger = Math.min(this.hunger + 5, 100);
    System.out.println(name + " is eating.");
    System.out.println("after eat, " + this.hunger);
    support.firePropertyChange("hunger", oldHunger, this.hunger);
  }


  public int getHealth() {
    return health;
  }

  public boolean isDead() {
    return dead;
  }

  public void setDead(boolean dead) {
    boolean oldDead = this.dead;
    this.dead = dead;
    System.out.println("dead\n");
    support.firePropertyChange("dead", oldDead, dead);
  }

  public void generateTxtFileFromDreams() {
    File outputFile = new File("dreams.txt");
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
      for (String dream : dreams) {
        writer.write(dream);
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  public String speakRandomly() {
    Random random = new Random();
    // 生成一个 int 类型的随机数
    int randomNumber = random.nextInt(4);
    String birth = "I have came to this world for %d days. Every day of getting here is so happy for me.";
    String miss = "I miss you so much, are you missing me?";
    String love = "I think you are the one I will love forever in this world, don't you think so?";
    String care = "Are you taking good care of yourself? If not, I will worry about you so much.";
    switch (randomNumber) {
      case 0:
        return String.format(birth, 9);
      case 1:
        return miss;
      case 2:
        return love;
      case 3:
        return care;
      default:
        return "I love you.";
    }
  }
}
