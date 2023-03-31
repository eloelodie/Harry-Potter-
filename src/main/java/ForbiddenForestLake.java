import java.util.ArrayList;

public class ForbiddenForestLake implements LevelAction {
    TextUtils TU = new TextUtils();
    Skirmishes sk = new Skirmishes();

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        String enemyName = enemies.get(0).getName();
        TU.printHeading("You enter the Forbidden Forest Lake.");
        TU.printConsole("A " + enemyName + " appears !");
        while (wizard.getHp() > 0 && enemies.get(0).getHp() > 0) {
            TU.printConsole("Dementor is comin");
            switch (TU.askInt("What do you want to do ? \n(1) Attack \n(2) Use Expecto Patronum\n--> ", 2)) {
                case 1 -> {
                    wizard.attack(bosses.get(0), wizard.getDamage());
                    dementorAttack(wizard, enemies.get(0));
                }
                case 2 -> {
                    if (Math.random() * 100 <= 60 && wizard.getKnownSpells().contains(sk.getSpells()[2])) {
                        TU.printConsole("You managed to pull a fang out of him !");
                    } else {
                        TU.printConsole("You missed your spell !");
                        wizard.getKnownSpells().get(2).castSpell(wizard, enemies.get(0));
                        dementorAttack(wizard, enemies.get(0));
                    }
                }
            }
        }
        if (enemies.get(0).getHp() <= 0) {
            sk.specialDeath(enemyName, enemies.get(0));
            sk.learningSpell(wizard, sk.getSpells()[2]);
            TU.printConsole("You use your patronum to flee Dementors !");
        }
    }

    public void dementorAttack(Wizard wizard, Enemy enemy) {
        if (enemy.getHp() <= 0) {
            return;
        }
        TU.printConsole("the " + enemy.getName() + " attacks you !");
        enemy.attack(wizard, enemy.getDamage());
        TU.printConsole("You still have " + wizard.getHp() + "life points.");

    }

}
