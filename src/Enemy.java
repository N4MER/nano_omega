public class Enemy {
    private String name;
    private int health;
    private int enemyAttackPower;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.enemyAttackPower = damage;
    }

    public Enemy() {
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getEnemyAttackPower() {
        return enemyAttackPower;
    }


    public String attack(Player player) {
        int playerHp = player.getHealth();
        playerHp -= enemyAttackPower;
        player.setHealth(playerHp);
        return "you took "+enemyAttackPower+" damage"+'\n'+"remaining Hp: "+playerHp;
    }


    @Override
    public String toString() {
        return name + '\n' + "Hp: " + health + '\n' + "Attack: " + enemyAttackPower;

    }

    public void setHealth(int health) {
        this.health = health;
    }
}