package View;

import Model.Food.FoodInterface;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;


public class FoodPenal extends JPanel {

  private List<JButton> foodButtonList = new ArrayList<JButton>();

  public FoodPenal(List<String> foodList) {
    if (foodList.size()==0) {
      System.out.println("创建foodPanel的时候就没有食物，我好心送一个苹果吧");
      JButton temApple = new JButton("apple");
      this.add(temApple);
      foodButtonList.add(temApple);
    }
    else {
      setLayout(new GridLayout(foodList.size(), 1)); // 使用 GridLayout 布局管理器，并指定行数和列数

      //System.out.println("food panel内部");
      for (String food : foodList) {
        JButton foodButton = new JButton(food);
        this.add(foodButton);
        foodButtonList.add(foodButton);
        System.out.println(foodButton.getText());
      }
    }
  }

  public List<JButton> getFoodButtonList() {
    return foodButtonList;
  }

}
