package Modle.Pet;

import java.util.Timer;
import java.util.TimerTask;

public class PetTimerManager {
  private Timer hungerTimer;
  private Timer healthTimer;
  private Timer happinessTimer;
  private Pet pet;

  public PetTimerManager(Pet pet) {
    this.pet = pet;
    hungerTimer = new Timer();
    healthTimer = new Timer();
    happinessTimer = new Timer();
    startHungerTimer();
  }

  public void startHungerTimer() {
    TimerTask loseHungerTask = new TimerTask() {
      @Override
      public void run() {
        pet.loseHunger();
      }
    };
    hungerTimer.scheduleAtFixedRate(loseHungerTask, 0, 30000); // Lose hunger every 30 seconds
  }

  public void startHealthTimer() {
    TimerTask loseHealthTask = new TimerTask() {
      @Override
      public void run() {
        pet.loseHealth();
      }
    };
    healthTimer.scheduleAtFixedRate(loseHealthTask, 0, 60000); // Lose health every 60 seconds
  }

  public void startHappinessTimer() {
    // Your happiness timer implementation here...
  }

  public void startHealthLossDueToHunger() {
    healthTimer.cancel(); // Cancel the existing health timer
    healthTimer = new Timer();
    startHealthTimer();
  }

  public void stopAllTimers() {
    hungerTimer.cancel();
    healthTimer.cancel();
    happinessTimer.cancel();
  }
}
