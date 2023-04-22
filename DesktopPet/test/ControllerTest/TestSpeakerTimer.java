package ControllerTest;

import Controller.SpeakTimer;
import Model.Pet.PetImpl;
import Model.Pet.PetInterface;
import View.TotalView;

public class TestSpeakerTimer {

  public static void main(String[] args) {
    // Initialize a PetInterface instance
    PetInterface pet = new PetImpl();

    // Initialize a TotalView instance
    TotalView view = new TotalView();

    // Create a SpeakTimer instance with an interval of 10 seconds
    SpeakTimer speakTimer = new SpeakTimer(10, pet, view);

    // Keep the program running to test the SpeakTimer
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
