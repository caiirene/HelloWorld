import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {

  private Model model;
  private View view;

  public Controller(Model model, View view){
    this.model = model;
    this.view = view;

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    System.out.println("alarm fired");
    // We reach here every time the alarm fires.

    // We update the snake's location.
    // Make it look like the snake is moving forward
    // Trick: move the tail to become the new head,
    // and keep other nodes the same
    // 1. chop off the tail
    Coordinate old_tail = model.getSnake().remove(model.getSnake().size()-1);
    // TODO: what if size is 1
    // 2. get the loc of the old head
    int old_head_x = model.getSnake().get(0).x;
    int old_head_y = model.getSnake().get(0).y;
    // 3. add a new head. The loc of the new head
    // depends on the direction of movement
    int new_head_x = old_head_x;
    int new_head_y = old_head_y;
    if (model.getDirection() == 1) {
      // up
      new_head_y -= model.getDot_size();
    } else if (model.getDirection() == 2) {
      // down
      new_head_y += model.getDot_size();
    } else if (model.getDirection() == 3) {
      // left
      new_head_x -= model.getDot_size();
    } else if (model.getDirection() == 4) {
      // right
      new_head_x += model.getDot_size();
    }
    model.getSnake().add(0, new Coordinate(new_head_x, new_head_y));

    // check whether the head overlaps with the apple
    if (model.getSnake().get(0).equals(model.getApple_loc())) {
      // eating the apple.
      // Increase size by 1.
      // Added the removed tail back.
      model.getSnake().add(old_tail);

      // also need to regenerate the apple's location
      model.regenApple();
    }

    // Call repaint, which further invokes `paintComponent`.
    view.repaint();
  }

  @Override
  public void keyTyped(KeyEvent e) {
    // do nothing
  }

  @Override
  public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    if (keyCode == KeyEvent.VK_UP) {
      // up key is pressed
      direction = 1;
    } else if (keyCode == KeyEvent.VK_DOWN) {
      // down
      direction = 2;
    } else if (keyCode == KeyEvent.VK_LEFT) {
      // left
      direction = 3;
    } else if (keyCode == KeyEvent.VK_RIGHT) {
      // right
      direction = 4;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

}
