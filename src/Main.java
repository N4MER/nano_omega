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
                    System.out.println("room number: "+r.getCoordinate());
                    System.out.println("⬇️ s, ⬆️ w, ➡️ d, ⬅️ a");
                    System.out.println("enter: x to end the game");
                    String direction = sc.next();
                    r.movement(direction, mapSize);
                    switch (c.getEnemies().get(c.getEnemyNum() - 1).getName()) {
                        case "Bob":
                            System.out.println("you found a Bob prepare for combat.");
                            c.encounterBob(c,p,r,direction,mapSize);
                            break;
                        case "Touny":
                            System.out.println("you found a Touny! Choose 1 to attack it,choose 2 to ignore it");
                            int chooseAction = sc.nextInt();
                            switch (chooseAction) {
                                case 1:
                                    c.encounterTouny(c,p,r,direction,mapSize);
                                    break;
                                case 2:
                                    r.getMap().set(r.getCoordinate()-2,"♿");
                                    break;
                            }
                            case "dummy":
                                System.out.println("no enemy was found in this room.");
                                break;
                    }
                    r.nextLine(mapSize);
                    System.out.println(r.showMap(mapSize));
                    r.removeNextLine(mapSize);
                    if (direction.equals("x")) {
                        System.out.println("You ended the game.");
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
                System.out.println('\n' + "!!!Wrong input.Try again!!!");
            }
        }


    }
}