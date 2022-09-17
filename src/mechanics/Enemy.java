package mechanics;

public class Enemy {
    private String name;
    private int health;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void printEnemyData() {
        System.out.println("Nome do inimigo: " + name);
        System.out.println("Vida do inimigo: " + health);
        System.out.println("Dano do inimigo: " + damage);
    }
}
