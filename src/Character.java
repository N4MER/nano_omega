import java.util.ArrayList;

public class Character {
    private int hp;
    private int attack;
    private int mana;
    private ArrayList<String> skills = new ArrayList<>();

    public Character(int hp, int attack, int mana) {
        this.hp = hp;
        this.attack = attack;
        this.mana = mana;
    }
}
