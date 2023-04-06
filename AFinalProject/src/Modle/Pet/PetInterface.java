package Modle.Pet;

import Modle.Food.FoodInterface;
import Modle.Toy.ToyBox;
import Modle.Toy.ToyInterface;

public interface PetInterface {

  String getName();
  void setName(String name);

  int getAge();
  void setAge(int age);

  int getHunger();
  void setHunger(int hunger);

  void eat(FoodInterface food);
  void play(ToyInterface toy);
  void sleep();

  void askUserDream();

  boolean deadCheck();

  boolean healthCheck();

  ToyBox getToyBox();

  void setToyBox(ToyBox toyBox);

  String speakRandomly();

  String sayThankYou();

  void loseHealth();
  void loseHunger();
  void loseHappiness();

}
