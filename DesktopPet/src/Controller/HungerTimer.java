package Controller;

import Model.Pet.PetInterface;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HungerTimer extends Timer {
  private PetInterface pet;

  public HungerTimer(int interval, PetInterface pet) {
    //interval = interval*1000;
    super(interval, null);
    this.pet = pet;
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.loseHungerWhileTimePass();
        System.out.println("hunger timer");
      }
    });
    //start();
  }

}
