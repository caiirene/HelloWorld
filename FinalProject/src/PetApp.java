// PetApp.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetApp {

  private JFrame frame;
  private JLabel petImage;
  private JButton eatButton;
  private JButton sleepButton;
  private JButton playButton;
  private JButton growUpButton;
  private JButton askDreamButton;
  private Pet pet;
  private Timer blinkTimer;


  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      try {
        PetApp window = new PetApp();
        window.frame.setVisible(true);
      } catch (Exception e) {
        e.printStackTrace();
      }
    });
  }

  public PetApp() {
    pet = new Pet();
    initialize();
  }


  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

    // Create a Pet object
    pet = new Pet();

    // Load the pet image
    ImageIcon petImageIcon = new ImageIcon(pet.getImagePath());
    petImage = new JLabel(petImageIcon);
    int width = petImageIcon.getIconWidth();
    int height = petImageIcon.getIconHeight();
    int x = 50;
    int y = 50;
    petImage.setBounds(x, y, width, height);
    frame.getContentPane().add(petImage);

    // Create a JPanel for the control panel
    JPanel controlPanel = new JPanel();
    controlPanel.setBounds(300, 50, 120, 100);
    frame.getContentPane().add(controlPanel);
    controlPanel.setLayout(new GridLayout(3, 1));

    // Create buttons for feed, sleep, and play
    JButton feedButton = new JButton("Feed");
    JButton sleepButton = new JButton("Sleep");
    JButton playButton = new JButton("Play");

    // Add buttons to the control panel
    controlPanel.add(feedButton);
    controlPanel.add(sleepButton);
    controlPanel.add(playButton);

    // Create dummy food, toy, and bath tool objects
    Food food = new Food("Pet Food");
    Toy toy = new Toy("Pet Toy");
    BathTool bathTool = new BathTool("Pet Bath Tool");



    // Blinking effect
    ImageIcon openEyeIcon = new ImageIcon(pet.getOpenEyeImagePath());
    ImageIcon closedEyeIcon = new ImageIcon(pet.getClosedEyeImagePath());
    Timer blinkTimer = new Timer(1000, new ActionListener() {
      boolean isOpen = true;

      @Override
      public void actionPerformed(ActionEvent e) {
        if (isOpen) {
          petImage.setIcon(closedEyeIcon);
        } else {
          petImage.setIcon(openEyeIcon);
        }
        isOpen = !isOpen;
      }
    });

    blinkTimer.start();


    // Add action listeners to the buttons
    feedButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // Pause blinking timer
        blinkTimer.stop();

        // Perform the feed action and update the pet image
        pet.eat(food);
        ImageIcon newPetImageIcon = new ImageIcon("C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\222.png");
        petImage.setIcon(newPetImageIcon);

        // Force components to repaint
        frame.getContentPane().repaint();

        // Use a Timer to resume the blinking timer after 5 seconds
        Timer resumeBlinkingTimer = new Timer(5000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            // Resume the blinking timer
            blinkTimer.start();
          }
        });

        // Set the resumeBlinkingTimer to be a one-time timer
        resumeBlinkingTimer.setRepeats(false);
        resumeBlinkingTimer.start();
      }
    });


    sleepButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.sleep();
        pet.setImagePath("C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\222.png");
        updatePetImage();
      }
    });

    playButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        pet.play(toy);
        pet.setImagePath("C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\111.png");
        updatePetImage();
      }
    });


  }

  /*
  private void initialize() {
    frame = new JFrame();
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(null);

// Load the image
    ImageIcon petImageIcon = new ImageIcon("C:\\Users\\asus\\Documents\\GitHub\\cs5004-irene-new\\FinalProject\\src\\image.png");

// Create a JLabel with the ImageIcon
    JLabel petImage = new JLabel(petImageIcon);

// Get the image dimensions
    int width = petImageIcon.getIconWidth();
    int height = petImageIcon.getIconHeight();

// Set the position and size of the JLabel
    int x = 50;
    int y = 50;
    petImage.setBounds(x, y, width, height);

// Add the JLabel to the frame
    frame.getContentPane().add(petImage);




    // Add pet image and buttons to the frame
    // Add action listeners to the buttons


    // Create a JPanel for the control panel
    JPanel controlPanel = new JPanel();
    controlPanel.setBounds(300, 50, 120, 100);
    frame.getContentPane().add(controlPanel);
    controlPanel.setLayout(new GridLayout(3, 1));

// Create buttons for feed, sleep, and play
    JButton feedButton = new JButton("Feed");
    JButton sleepButton = new JButton("Sleep");
    JButton playButton = new JButton("Play");

// Add buttons to the control panel
    controlPanel.add(feedButton);
    controlPanel.add(sleepButton);
    controlPanel.add(playButton);

  }

   */


  private void updatePetImage() {
    ImageIcon newPetImageIcon = new ImageIcon(pet.getImagePath());
    petImage.setIcon(newPetImageIcon);
  }
}
