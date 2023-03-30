public class Skirmishes {

    TextUtils TU = new TextUtils();

    // Spells
    Spell wingardiumLeviosa = new Spell("Wingardium Leviosa", 10, 2);
    Spell expelliarmus = new Spell("Expelliarmus", 15, 3);
    Spell expectoPatronum = new Spell("Expecto Patronum", 20, 4);
    Spell sectumsempra = new Spell("Sectumsempra", 25, 5);
    Spell accio = new Spell("Accio", 30, 6);
    Spell[] spells = new Spell[]{wingardiumLeviosa, expelliarmus, expectoPatronum, sectumsempra, accio};

    public void rest(Wizard wizard) {
        TU.printConsole("Vous vous reposez...");
        wizard.setHp(wizard.getMaxHp());
        wizard.setMana(wizard.getMaxMana());
        TU.printConsole("Vous avez récupéré tous vos points de vie.");
    }

    public Spell[] getSpells() {
        return spells;
    }
}
