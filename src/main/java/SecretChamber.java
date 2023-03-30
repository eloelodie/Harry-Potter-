import java.util.ArrayList;

public class SecretChamber implements LevelAction {

    TextUtils TU = new TextUtils();
    Skirmishes sk = new Skirmishes();

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        String enemyName = enemies.get(0).getName();
        TU.printHeading("You enter the Chamber of Secrets.");
        if (wizard.getHouse() == House.GRYFFINDOR) {
            TU.printConsole("You find Gryffindor's sword and defeat the Basilisk !");
            sk.specialDeath(enemyName, enemies.get(0));
        }
        while (wizard.getHp() > 0 && enemies.get(0).getHp() > 0) {
            TU.printConsole("You can try to rip one of its fangs out with Accio.");
            switch (TU.askInt("What do you want to do ? \n(1) Attack \n(2) Use Accio\n--> ", 2)) {
                case 1 -> {
                    wizard.attack(bosses.get(0), wizard.getDamage());
                    basiliskAttack(wizard, enemies.get(0));
                }
                case 2 -> {
                    if (Math.random() * 100 <= 60 && wizard.getKnownSpells().contains(sk.getSpells()[4])) {
                        TU.printConsole("You managed to pull a fang out of him !");
                        sk.specialDeath(enemyName, enemies.get(0));
                        sk.learningSpell(wizard, sk.getSpells()[2]);
                        TU.printConsole("You use the fang to destroy Tom Riddle's journal !");
                    } else {
                        TU.printConsole("You missed your spell !");
                        wizard.getKnownSpells().get(1).castSpell(wizard, enemies.get(0));
                        basiliskAttack(wizard, enemies.get(0));
                    }
                }
            }
        }
    }

    public void basiliskAttack(Wizard wizard, Enemy enemy) {
        TU.printConsole("the " + enemy.getName() + " attacks you !");
        enemy.attack(wizard, enemy.getDamage());
        TU.printConsole("You still have " + wizard.getHp() + "life points.");
    }

}
