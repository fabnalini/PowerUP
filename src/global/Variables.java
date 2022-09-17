package global;

import design.ConsoleColor;

public class Variables {

  private int score = 0;
  private int playerHealth = 50;
  private int knightQuantity = 5;
  private int knightPower = 1;
  private int usedCards = 0;
  private int finalDamage = knightQuantity * knightPower;

  ConsoleColor Color = new ConsoleColor();

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public int getPlayerHealth() {
    return playerHealth;
  }

  public void setPlayerHealth(int playerHealth) {
    this.playerHealth = playerHealth;
  }

  public int getKnightQuantity() {
    return knightQuantity;
  }

  public void setKnightQuantity(int knightQuantity) {
    this.knightQuantity = knightQuantity;
  }

  public int getKnightPower() {
    return knightPower;
  }

  public void setKnightPower(int knightPower) {
    this.knightPower = knightPower;
  }

  public int getUsedCards() {
    return usedCards;
  }

  public void setUsedCards(int usedCards) {
    this.usedCards = usedCards;
  }

  public int getFinalDamage() {
    return finalDamage;
  }

  public void setFinalDamage(int finalDamage) {
    this.finalDamage = finalDamage;
  }

  public void showGlobalData() {
    System.out.println("\n----------- Informações do jogador -----------");
    System.out.println(Color.setColor("red", "Vida: " + playerHealth));
    System.out.println(Color.setColor("cyan", "Quantidade de cavaleiros: " + knightQuantity));
    System.out.println(Color.setColor("purple", "Poder de cada cavaleiro: " + knightPower));
    System.out.println(Color.setColor("green", "Poder final: " + finalDamage));
    System.out.println("----------------------------------------------");
  }

  public void computeFinalDamage() {
    finalDamage = knightQuantity * knightPower;
  }
}
