import java.util.ArrayList;

public class DungeonsToilets implements LevelAction {

    TextUtils TU = new TextUtils();
    Skirmishes sk = new Skirmishes();

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        String bossName = bosses.get(0).getName();
        TU.printHeading("Vous entrez dans les toilettes du dongeons");
        TU.printConsole("Un " + bossName + " apparait !");
        while (wizard.getHp() > 0 && bosses.get(0).getHp() > 0) {
            TU.printConsole("Vous pouvez essayer de faire tomber la massue sur sa tête avec Wingardium Leviosa.");
            switch (TU.askInt("Que voulez-vous faire ? \n(1) Attaquer \n(2) Utiliser Wingardium Leviosa\n--> ", 2)) {
                case 1 -> {
                    wizard.attack(bosses.get(0), wizard.getDamage());
                    trollAttack(wizard, bosses.get(0));
                }
                case 2 -> {
                    if (Math.random() * 100 <= 60 && wizard.getKnownSpells().contains(sk.getSpells()[0])) {
                        TU.printConsole("Vous avez réussi à la faire tomber sur la tête du " + bossName + " !");
                        sk.specialDeath(bossName, bosses.get(0));
                        sk.learningSpell(wizard, sk.getSpells()[4]);
                    } else {
                        TU.printConsole("Vous avez raté votre sort !");
                        wizard.getKnownSpells().get(0).castSpell(wizard, bosses.get(0));
                        trollAttack(wizard, bosses.get(0));
                    }
                }
            }
        }

    }

    public void trollAttack(Wizard wizard, Boss boss) {
        TU.printConsole("Le " + boss.getName() + " vous attaque avec sa massue !");
        boss.attack(wizard, boss.getDamage());
        TU.printConsole("Il vous reste " + wizard.getHp() + " points de vie.");
        TU.printConsole("La pierre est bancale...");
    }

}
