package mechanics;

import global.Variables;
import design.ConsoleColor;

public class Card {
  private int id;
  private String name;
  private String description;

  ConsoleColor Color = new ConsoleColor();

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Card(int id) {
    this.id = id;

    switch (id) {
      case 1:
        this.name = Color.setColor("yellow", "Curar");
        this.description = Color.setColor("yellow", "[!] Cura 5 pontos de vida, mas elimina 1 cavaleiro. ");
        break;
      case 2:
        this.name = Color.setColor("cyan", "Recrutar");
        this.description = Color.setColor("cyan", "[!] Aumenta em 2 a quantidade total de cavaleiros. ");
        break;
      case 3:
        this.name = Color.setColor("purple", "Reunir");
        this.description = Color.setColor("purple",
            "[!] Aumenta o poder de cada cavaleiro baseado na quantidade total de cavaleiros. ");
        break;
      case 4:
        this.name = Color.setColor("red", "Sacrificar");
        this.description = Color.setColor("red",
            "[!] Sacrifica 2 cavaleiros, mas aumenta em 1 ponto o poder de cada cavaleiro remanescente. ");
        break;
      case 5:
        this.name = Color.setColor("green", "Treinar");
        this.description = Color.setColor("green", "[!] Aumenta em 1 ponto o poder de cada cavaleiro. ");
        break;
    }
  }

  public void useCard(int id, Variables Global) {
    switch (this.id) {
      case 1:
        Curar(Global);
        break;
      case 2:
        Recrutar(Global);
        break;
      case 3:
        Reunir(Global);
        break;
      case 4:
        Sacrificar(Global);
        break;
      case 5:
        Treinar(Global);
        break;
    }
  }

  public void Curar(Variables Global) {
    if (Global.getKnightQuantity() >= 2) {
      Global.setPlayerHealth(Global.getPlayerHealth() + 5);
      Global.setKnightQuantity(Global.getKnightQuantity() - 1);
    } else {
      System.out
          .println(Color.setColor("blue", "\n[?] A carta desapareceu de suas mãos ao utilizá-la, mas nada aconteceu."));
    }
    Global.computeFinalDamage();
  }

  public void Recrutar(Variables Global) {
    Global.setKnightQuantity(Global.getKnightQuantity() + 2);
    Global.computeFinalDamage();
  }

  private void Reunir(Variables Global) {
    Global.setKnightPower(Global.getKnightPower() + (Global.getKnightQuantity() / 3));
    Global.computeFinalDamage();
  }

  public void Sacrificar(Variables Global) {
    if (Global.getKnightQuantity() >= 3) {
      Global.setKnightQuantity(Global.getKnightQuantity() - 2);
      Global.setKnightPower(Global.getKnightPower() * 1);
    } else {
      System.out
          .println(Color.setColor("blue", "\n[?] A carta desapareceu de suas mãos ao utilizá-la, mas nada aconteceu."));
    }
    Global.computeFinalDamage();
  }

  public void Treinar(Variables Global) {
    Global.setKnightPower(Global.getKnightPower() + 1);
    Global.computeFinalDamage();
  }

}
