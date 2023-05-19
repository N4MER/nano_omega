import java.util.ArrayList;

public class Rooms {
    ArrayList<String> map = new ArrayList<>();

    public void generateMap(Integer size) {
        String room = "⬛";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map.add(room);
            }
        }
    }

    private int coordinate = 1;
    private int index;

    public void movement(String direction, int size) {
        switch (direction) {
            case "d"://east
                map.set(coordinate - 1, "⬜");
                map.set(coordinate, "⭕");
                coordinate += 1;
                break;
            case "a"://west
                map.set(coordinate - 1, "⬜");
                map.set(coordinate - 2, "⭕");
                if (coordinate > 0) {
                    coordinate -= 1;
                }
                break;
            case "s"://north
                map.set(coordinate - 1, "⬜");
                map.set(coordinate - 1 + size, "⭕");
                coordinate += size;
                break;
            case "w"://south
                map.set(coordinate - 1, "⬜");
                map.set(coordinate - 1 - size, "⭕");
                coordinate -= size;
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

        //✅□⬜⬛❌💥⭕
        //current location {}
        //unexplored []
        //explored ()


    }
}
