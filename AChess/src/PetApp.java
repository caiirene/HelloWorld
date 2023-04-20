import javax.swing.SwingUtilities;

public class PetApp {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Pet pet = new Pet("Fluffy");
      PetView petView = new PetView(pet);
      PetController petController = new PetController(pet, petView);
    });
  }
}