package Controller;

import Model.Food.FoodInterface;
import Model.Pet.PetInterface;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FoodDecayTimer extends Timer{

  private FoodInterface food;

  public FoodDecayTimer(int i, FoodInterface food) {
    super(i,null);
    this.food = food;
    addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (food.getFoodBoolean()!=false) {
          food.lossFoodValueWhileTimePass();
        }
        else {FoodDecayTimer.this.stop();}
      }
    });
    start();
  }

}
