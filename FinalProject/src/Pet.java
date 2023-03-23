public class Pet {
  private int hunger;
  private int health;
  private int happiness;
  private int age;
  private String dream;

  private String imagePath;

  public Pet() {
    this.hunger = 100;
    this.health = 100;
    this.happiness = 100;
    this.age = 0;
    this.imagePath = "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\image.png";
  }

  public void eat(Food food) {
    // Implement logic to feed the pet and increase hunger
  }

  public void sleep() {
    // Implement logic for the pet to sleep and increase health
  }

  public void play(Toy toy) {
    // Implement logic to play with the pet and increase happiness
  }

  public void growUp() {
    // Implement logic to age the pet if it's full, healthy, and happy
  }

  public void askYourDream(String dream) {
    // Store the user's dream
    this.dream = dream;
  }

  public String getImagePath() {
    return this.imagePath;
  }

  public void setImagePath(String newPath) {
    imagePath = newPath;
  }

  public String getOpenEyeImagePath() {
    return "C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\Inkedimage.jpg";
  }

  public String getClosedEyeImagePath() {
    return this.imagePath;
  }
}