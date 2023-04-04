package Modle.Pet;

import Modle.Food.FoodInterface;
import Modle.Toy.ToyInterface;

public interface PetInterface {

  String getName();
  void setName(String name);

  int getAging();
  void setAging(int age);

  int getHunger();
  void setHunger(int hunger);

  void eat(FoodInterface food);
  void play(ToyInterface toy);

  void askUserDream_andStoreInTXT();

  boolean deadCheck();

  boolean healthCheck();


}
