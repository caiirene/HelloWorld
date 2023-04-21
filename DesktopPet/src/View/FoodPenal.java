package View;

import Model.Food.FoodInterface;
import java.awt.GridLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FoodPenal extends JPanel {

  public FoodPenal(List<String> foodList) {
    setLayout(new GridLayout(1, foodList.size())); // 使用 GridLayout 布局管理器，并指定行数和列数

    for (String food : foodList) {
      JButton foodButton = new JButton(food);
      this.add(foodButton);
    }
  }

}
