import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Object String;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("choose size of your map:");
        int mapSize = sc.nextInt();

        Combat c = new Combat();
        Rooms r = new Rooms();
        Player p = new Player();
        Enemy e = new Enemy();

        r.generateMap(mapSize);
        r.nextLine(mapSize);
        System.out.println(r.showMap(mapSize));
        r.removeNextLine(mapSize);
        c.generateEnemy(mapSize);

        while (true) {
            try {
                for (int i = 0; i >= 0; i++) {
                    if (p.getHealth() <= 0) {
                        System.out.println("you died." + '\n' + "GAMEOVER");
                        break;
                    }
                    System.out.println("⬇️ s, ⬆️ w, ➡️ d, ⬅️ a");
                    System.out.println("enter: x to end the game");
                    String direction = sc.next();
                    r.movement(direction, mapSize);
                    switch (c.getEnemies().get(c.getEnemyNum() - 1).getName()) {
                        case "Bob":
                            System.out.println("you found a Bob prepare for combat.");
                            while (c.getEnemies().get(c.getEnemyNum() - 1).getHealth() > 0 && p.getHealth() > 0) {
                                System.out.println(c.getEnemies().get(c.getEnemyNum() - 1).attack(p) + "\n");
                                System.out.println(p.attackEnemy(c.getEnemies().get(c.getEnemyNum() - 1)) + '\n');
                            }
                            if (c.getEnemies().get(c.getEnemyNum() - 1).getHealth() == 0) {
                                System.out.println("you have defeated a Bob!!!");
                                c.defeatedEnemy(direction, mapSize);
                            }
                            break;
                        case "Touny":
                            System.out.println("you found a Touny! Choose 1 to attack it,choose 2 to ignore it");
                            int chooseAction = sc.nextInt();
                            switch (chooseAction) {
                                case 1:
                                    while (c.getEnemies().get(c.getEnemyNum() - 1).getHealth() > 0 && p.getHealth() > 0) {
                                        System.out.println(p.attackEnemy(c.getEnemies().get(c.getEnemyNum() - 1)) + '\n');
                                        System.out.println(c.getEnemies().get(c.getEnemyNum() - 1).attack(p) + '\n');
                                    }
                                    if (c.getEnemies().get(c.getEnemyNum() - 1).getHealth() == 0) {
                                        System.out.println("you have defeated a Touny!!!");
                                        c.defeatedEnemy(direction, mapSize);
                                    }
                                    break;
                                case 2:
                                    r.getMap().get(r.getCoordinate()).replace(r.getMap().get(r.getCoordinate() - 1), "♿");
                                    break;
                            }
                    }
                    r.nextLine(mapSize);
                    System.out.println(r.showMap(mapSize));
                    r.removeNextLine(mapSize);
                    if (direction.equals("x")) {
                        System.out.println("GAME OVER");
                        break;
                    }

                }
                break;
            } catch (IndexOutOfBoundsException exception) {

                System.out.println('\n' + "!!!No space.Try a different direction!!!");
                r.nextLine(mapSize);
                System.out.println(r.showMap(mapSize));
                r.removeNextLine(mapSize);
            } catch (InputMismatchException exception) {
                System.out.println('\n' + "!!!wrong input!!!");
            }
        }


    }
}