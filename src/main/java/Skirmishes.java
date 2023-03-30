public class Skirmishes {

    TextUtils TU = new TextUtils();

    // Spells
    private Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 10, 2);
    private Spell expelliarmus = new Spell("Expelliarmus", 15, 3);
    private Spell expectoPatronum = new Spell("Expecto Patronum", 20, 4);
    private Spell sectumsempra = new Spell("Sectumsempra", 25, 5);
    private Spell accio = new Spell("Accio", 30, 6);
    private Spell[] spells = new Spell[]{wingardiumLeviosa, expelliarmus, expectoPatronum, sectumsempra, accio};

    public Spell[] getSpells() {
        return spells;
    }

    public void rest(Wizard wizard) {
        TU.printConsole("You rest...");
        wizard.setHp(wizard.getMaxHp());
        wizard.setMana(wizard.getMaxMana());
        TU.printConsole("You have recovered all your life points.");
    }

    public void specialDeath(String name, AbstractEnemy enemy) {
        TU.printConsole("The " + name + " is dead !");
        enemy.setHp(0);
        TU.printConsole("You go to the next level !");
        TU.printConsole("You win !");
    }

    public void learningSpell(Wizard wizard, Spell spell) {
        TU.printConsole("You learned the spell " + spell.getName() + " !");
        wizard.addSpell(spell);
    }

}
