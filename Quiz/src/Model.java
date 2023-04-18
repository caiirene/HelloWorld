import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

  private int direction;
  private Random rnd;
  List<Coordinate> snake_loc;
  private Coordinate apple_loc;
  private int dot_size = 10;


  public Model(){
    rnd = new Random();
    // Init the location of the apple
    apple_loc = new Coordinate(200, 200);
    // Init the location of the snake.
    // It starts with head only
    // The list head is the snake head.
    // Assume the radius of each dot is 10.
    snake_loc = new ArrayList<>();
    snake_loc.add(new Coordinate(50, 50));
    snake_loc.add(new Coordinate(50 + dot_size, 50));
    snake_loc.add(new Coordinate(50 + 2 * dot_size, 50));


    // 1 - up
    // 2 - down
    // 3 - left
    // 4 - right
    direction = 1;
  }


  public void regenApple() {
    // Random location within the panel.
    int new_x = rnd.nextInt(400);
    int new_y = rnd.nextInt(400);
    // Round the location to dot_size.
    apple_loc = new Coordinate((new_x / dot_size) * dot_size, (new_y / dot_size) * dot_size);
  }

  public Coordinate getApple_loc() {
    return apple_loc;
  }

  public Coordinate getSnakeLoc() {
    return snake_loc.get(0);
  }

  public List<Coordinate> getSnake() {
    return snake_loc;
  }

  public int getDirection() {
    return direction;
  }

  public int getDot_size(){
    return dot_size;
  }

}
