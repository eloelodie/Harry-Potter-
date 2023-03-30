import java.util.ArrayList;

public class Wizard extends Character {

    private Pet pet;
    private final Wand wand;
    private House house;
    private ArrayList<Spell> knownSpells;
    private ArrayList<Potion> potions;
    private int currentLevel = 0;

    public Wizard(String name, Wand wand, int maxHp, int maxMana) {
        setName(name);
        this.wand = wand;

        setMaxHp(maxHp);
        setHp(maxHp);
        setDamage(5);
        setMaxMana(maxMana);
        setMana(maxMana);
    }

    public Wand getWand() {
        return wand;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getCurrentLevel() {
        return currentLevel;
    }

    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public ArrayList<Spell> getKnownSpells() {
        return knownSpells;
    }

    public void addSpell(Spell spell) {
        knownSpells.add(spell);
    }

    public ArrayList<Potion> getPotions() {
        return potions;
    }

    public void addPotion(Potion potion) {
        potions.add(potion);
    }

    public void usePotion(Potion potion) {
        int healPoints = potion.getHp();
        if (house == House.HUFFLEPUFF) {
            healPoints += 10;
        }
        heal(healPoints);
        potions.remove(potion);
    }

    public void defend() {
        // TODO
    }

}
