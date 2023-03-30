import java.util.ArrayList;

public class DungeonsToilets implements LevelAction {

    TextUtils TU = new TextUtils();
    Skirmishes sk = new Skirmishes();

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        String bossName = bosses.get(0).getName();
        TU.printHeading("You enter the dungeon toilets");
        TU.printConsole("A " + bossName + " appears !");
        while (wizard.getHp() > 0 && bosses.get(0).getHp() > 0) {
            TU.printConsole("You can try knocking the club on its head with Wingardium Leviosa.");
            switch (TU.askInt("What do you want to do ? \n(1) Attack \n(2) Use Wingardium Leviosa\n--> ", 2)) {
                case 1 -> {
                    wizard.attack(bosses.get(0), wizard.getDamage());
                    trollAttack(wizard, bosses.get(0));
                }
                case 2 -> {
                    if (Math.random() * 100 <= 60 && wizard.getKnownSpells().contains(sk.getSpells()[0])) {
                        TU.printConsole("You managed to make it fall on the head of the " + bossName + " !");
                        sk.specialDeath(bossName, bosses.get(0));
                        sk.learningSpell(wizard, sk.getSpells()[4]);
                    } else {
                        TU.printConsole("You missed your spell !");
                        wizard.getKnownSpells().get(0).castSpell(wizard, bosses.get(0));
                        trollAttack(wizard, bosses.get(0));
                    }
                }
            }
        }

    }

    public void trollAttack(Wizard wizard, Boss boss) {
        TU.printConsole("The " + boss.getName() + " attacks you with his club !");
        boss.attack(wizard, boss.getDamage());
        TU.printConsole("You still have " + wizard.getHp() + " life points .");
        TU.printConsole("The stone is wobbly...");
    }

}

