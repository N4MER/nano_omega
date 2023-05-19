import java.util.ArrayList;
import java.util.Random;

public class Rooms {
    ArrayList<String> map = new ArrayList<>();

    public void generateMap(Integer size) {
        String room = "[]";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map.add(room);
            }
        }
    }

    private int coordinateX = 1;
    private int coordinateY = 1;

    public void currentLocation(String direction) {
        int index;
        switch (direction) {
            case "e"://east
                map.set(coordinateX * (coordinateY - 1), "()");
                index = coordinateX * coordinateY;
                map.set(index, "{}");
                coordinateY++;
                break;
            case "w"://west
                map.set(coordinateX * (coordinateY - 1), "()");
                index = -1 * coordinateX * coordinateY;
                map.set(index, "{}");
                break;
        }
    }

    StringBuilder sb = new StringBuilder();

    public String showMap(int size) {
        map.set(0, "\uD83C\uDFE0");
        String result = map.toString().replace(", ", "");
        return result.substring(1, result.length() - 1);
    }

    public void sort(int size) {
        switch (size) {
            case 2:
                map.add(2, String.valueOf('\n'));
                break;
            case 3:
                map.add(3, String.valueOf('\n'));
                map.add(7, String.valueOf('\n'));

                break;
            case 4:
                map.add(4, String.valueOf('\n'));
                map.add(9, String.valueOf('\n'));
                map.add(14, String.valueOf('\n'));
                break;
            case 5:
                map.add(5, String.valueOf('\n'));
                map.add(11, String.valueOf('\n'));
                map.add(17, String.valueOf('\n'));
                map.add(23, String.valueOf('\n'));
                break;
        }
    }

    public void removeSort(int size) {
        switch (size) {
            case 2:
                map.remove(2);
                break;
            case 3:
                map.remove(7);
                map.remove(3);
                break;
            case 4:
                map.remove(14);
                map.remove(9);
                map.remove(4);
                break;
            case 5:
                map.remove(23);
                map.remove(17);
                map.remove(11);
                map.remove(5);
                break;
        }

        //problem with sort on last line of the array
        //current location {}
        //unexplored []
        //explored ()


    }
}
