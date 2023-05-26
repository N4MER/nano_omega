import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Combat {

    ArrayList<Enemy> enemies = new ArrayList<>();
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    private int enemyNum = 1;
    private int indexE;
    Enemy dummy = new Enemy("dummy", 0, 0);

    public void generateEnemy(int size) {
        for (int i = 0; i < size * size; i++) {
            int random = r.nextInt(2) + 1;
            Enemy e = null;
            switch (random) {
                case 1://attack enemy
                    e = new Enemy("Bob", 100, 20);
                    enemies.add(e);
                    break;
                case 2://def enemy
                    e = new Enemy("Touny", 200, 10);
                    enemies.add(e);
                    break;
            }
        }
    }



    public void defeatedEnemy(String direction, int size) {
        switch (direction) {
            case "d"://east
                enemies.set(enemyNum - 1, dummy);
                enemyNum += 1;
                break;
            case "a"://west
                enemies.set(enemyNum - 1, dummy);
                if (enemyNum > 0) {
                    enemyNum -= 1;
                }
                break;
            case "s"://north
                enemies.set(enemyNum - 1, dummy);
                enemyNum += size;
                break;
            case "w"://south
                enemies.set(enemyNum - 1, dummy);
                enemyNum -= size;
        }
    }

    public String result(ArrayList<Enemy> enemyArrayList, int size) {
        int points = 0;
        for (int i = 0; i < size * size; i++) {
            if (enemyArrayList.get(i).equals(dummy)) {
                points++;
            }
        }
        if (points == size * size) {
            return "you have defeated all enemies!";
        } else {
            return "you didn't defeat all enemies :(";
        }
    }

    public String encounterBob(Combat combat, Player player,Rooms r, String direction, int mapSize) {
        while (combat.getEnemies().get(combat.getEnemyNum() - 1).getHealth() > 0 && player.getHealth() > 0) {
            System.out.println(combat.getEnemies().get(combat.getEnemyNum() - 1).attack(player) + "\n");
            System.out.println(player.attackEnemy(combat.getEnemies().get(combat.getEnemyNum() - 1)) + '\n');
        }
        if (combat.getEnemies().get(combat.getEnemyNum() - 1).getHealth() == 0) {
            combat.defeatedEnemy(direction, mapSize);
            r.getMap().set(r.getCoordinate()-2,"❎");
            return "you have defeated a Bob!!!";
        } else {
            return "you died." + '\n' + "GAMEOVER";
        }
    }

    public String encounterTouny(Combat combat, Player player,Rooms r, String direction, int mapSize) {
        while (combat.getEnemies().get(combat.getEnemyNum() - 1).getHealth() > 0 && player.getHealth() > 0) {
            System.out.println(player.attackEnemy(combat.getEnemies().get(combat.getEnemyNum() - 1)) + '\n');
            System.out.println(combat.getEnemies().get(combat.getEnemyNum() - 1).attack(player) + '\n');
        }
        if (combat.getEnemies().get(combat.getEnemyNum() - 1).getHealth() == 0) {
            combat.defeatedEnemy(direction, mapSize);
            r.getMap().set(r.getCoordinate()-2,"❎");
            return "you have defeated a Touny!!!";
        } else {
            return "you died." + '\n' + "GAMEOVER";
        }
    }

    public int getEnemyNum() {
        return enemyNum;
    }

    public int getIndexE() {
        return indexE;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    /*public String removeBraces() {
        String result = enemies.toString().replace(", ", String.valueOf('\n'));
        return result.substring(1, result.length() - 1);
    }*/

}
