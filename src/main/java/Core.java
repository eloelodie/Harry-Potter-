public enum Core {
    PHOENIX_FEATHER("Phoenix Feather"),
    DRAGON_HEARTSTRING("Dragon Heartstring"),
    UNICORN_HAIR("Unicorn Hair");

    private String name;

    Core(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
