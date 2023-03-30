public enum House {

    GRYFFINDOR("Gryffindor"),
    HUFFLEPUFF("Hufflepuff"),
    RAVENCLAW("Ravenclaw"),
    SLYTHERIN("Slytherin");

    private String name;

    House(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
