import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Object String;

    public static void main(String[] args) {
        //System.out.println("⬜");
        Scanner sc = new Scanner(System.in);
        System.out.println("choose size of your map:");
        int mapSize = sc.nextInt();
        Rooms r = new Rooms();
        r.generateMap(mapSize);
        r.sort(mapSize);
        System.out.println(r.showMap(mapSize));
        r.removeSort(mapSize);

        while (true) {
            try {
                for (int i = 0; i >= 0; i++) {
                    System.out.println("where do you want to go?(⬇️ s, ⬆️ w, ➡️ d, ⬅️ a");
                    System.out.println("enter: x to end the game");
                    String direction = sc.next();
                    r.movement(direction,mapSize);
                    r.sort(mapSize);
                    System.out.println(r.showMap(mapSize));
                    r.removeSort(mapSize);
                    if (direction.equals("x")) {
                        break;
                    }
                }
                break;
            } catch (Exception e) {
                System.out.println("No space.Try a different direction"+'\n');
            }
        }


    }
}