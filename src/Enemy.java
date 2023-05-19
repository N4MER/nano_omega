import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    private String attackingEnemy="John";
    private String defendingEnemy="Bob";
    private int hp;
    private int attack;

    Random r = new Random();
    private ArrayList<String> enemies = new ArrayList();
    public void generateEnemies(int size){
        int random=r.nextInt(2)+1;
        switch (random){
            case 1:
                enemies.add(attackingEnemy);
                break;
            case 2:
                enemies.add(defendingEnemy);
                break;
        }
    }


}



