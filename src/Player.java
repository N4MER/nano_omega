import java.util.ArrayList;

public class Player {

    private int health=200;
    private int attack =20;
    private int mana;
    private ArrayList<String>skills = new ArrayList<>();

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getMana() {
        return mana;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    @Override
    public String toString() {
        return "Player{" +
                "skills=" + skills +
                '}';
    }

    public void setHealth(int health) {
        this.health = health;
    }
    public String attackEnemy(Enemy enemy){
        int enemyHp=enemy.getHealth();
        enemyHp-= attack;
        enemy.setHealth(enemyHp);
        return "you did "+attack+" damage"+'\n'+"enemies remaining Hp: "+enemyHp;
    }
}
