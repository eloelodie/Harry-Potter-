import java.util.ArrayList;

public class SecretChamber implements LevelAction {

    TextUtils TU = new TextUtils();
    Skirmishes sk = new Skirmishes();

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        String enemyName = enemies.get(0).getName();
        TU.printHeading("Vous entrez dans la Chambre des secrets.");
        if (wizard.getHouse() == House.GRYFFINDOR) {
            TU.printConsole("Vous trouvez l'épée de Gryffondor et venez à bout du Basilic !");
            sk.specialDeath(enemyName, enemies.get(0));
        }
        while (wizard.getHp() > 0 && enemies.get(0).getHp() > 0) {
            TU.printConsole("Vous pouvez essayer de lui arracher un de ses crocs avec Accio.");
            switch (TU.askInt("Que voulez-vous faire ? \n(1) Attaquer \n(2) Utiliser Accio\n--> ", 2)) {
                case 1 -> {
                    wizard.attack(bosses.get(0), wizard.getDamage());
                    basiliskAttack(wizard, enemies.get(0));
                }
                case 2 -> {
                    if (Math.random() * 100 <= 60 && wizard.getKnownSpells().contains(sk.getSpells()[4])) {
                        TU.printConsole("Vous avez réussi à lui arracher un croc !");
                        sk.specialDeath(enemyName, enemies.get(0));
                        sk.learningSpell(wizard, sk.getSpells()[2]);
                        TU.printConsole("Vous utilisez le croc pour détruire le journal de Tom Jedusor !");
                    } else {
                        TU.printConsole("Vous avez raté votre sort !");
                        wizard.getKnownSpells().get(1).castSpell(wizard, enemies.get(0));
                        basiliskAttack(wizard, enemies.get(0));
                    }
                }
            }
        }
    }

    public void basiliskAttack(Wizard wizard, Enemy enemy) {
        TU.printConsole("Le " + enemy.getName() + " vous attaque !");
        enemy.attack(wizard, enemy.getDamage());
        TU.printConsole("Il vous reste " + wizard.getHp() + " points de vie.");
    }

}
