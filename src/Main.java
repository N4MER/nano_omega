import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Object String;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("choose size of your map:");
        int mapSize = sc.nextInt();
        Rooms r = new Rooms();
        r.generateMap(mapSize);
        System.out.println(r.showMap(mapSize));

        for (int i = 0; i >=0; i++) {
            System.out.println("where do you want to go?(South: s, North: n, East: e, West: w");
            System.out.println("enter: x to end the game");
            String direction = sc.next();
            r.currentLocation(direction);
            System.out.println(r.showMap(mapSize));
            if (direction.equals("x")){
                break;
            }
        }



        /*r.getRooms().add("[]");
        r.getRooms().add("[]");
        r.getRooms().add("[]");
        r.getRooms().add("[]");
        r.getRooms().add("[]");

        System.out.println(r.generateMap());*/


    }
}