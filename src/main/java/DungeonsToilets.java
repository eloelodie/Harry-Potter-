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
            TU.printConsole("Vous pouvez essayer de faire tomber une pierre sur sa tête avec Wingardium Leviosa.");
            switch (TU.askInt("Que voulez-vous faire ? \n(1) Attaquer \n(2) Utiliser Wingardium Leviosa\n--> ", 2)) {
                case 1 -> {
                    wizard.attack(bosses.get(0), wizard.getDamage());
                    TU.printConsole("Vous lui infligez " + wizard.getDamage() + " points de dégâts.");
                    TU.printConsole("Il lui reste " + bosses.get(0).getHp() + " points de vie.");
                    trollAttack(wizard, bosses.get(0));
                }
                case 2 -> {
                    if (Math.random() * 100 <= 60) {
                        TU.printConsole("Vous avez réussi à faire tomber la pierre sur la tête du " + bossName + " !");
                        TU.printConsole("Le " + bossName + " est mort !");
                        bosses.get(0).setHp(0);
                        wizard.setCurrentLevel(wizard.getCurrentLevel() + 1);
                        TU.printConsole("Vous passez au niveau suivant !");
                        TU.printConsole("Vous avez gagné !");

                    } else {
                        TU.printConsole("Vous avez raté votre sort !");
                        trollAttack(wizard, bosses.get(0));
                    }
                }
            }
        }

    }

    public void trollAttack(Wizard wizard, Boss boss) {
        TU.printConsole("Le " + boss.getName() + " vous attaque !");
        boss.attack(wizard, boss.getDamage());
        TU.printConsole("Il vous reste " + wizard.getHp() + " points de vie.");
        TU.printConsole("La pierre est bancale...");
    }

}
