public enum Potion {

    POTION("Potion", 10),
    SUPER_POTION("Super Potion", 20),
    HYPER_POTION("Hyper Potion", 30),
    MAX_POTION("Max Potion", 1000);

    private final String name;
    private final int hp;

    Potion(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }
}
