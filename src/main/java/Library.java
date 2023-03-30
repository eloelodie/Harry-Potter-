import java.util.ArrayList;

public class Library implements LevelAction {

    Skirmishes sk = new Skirmishes();
    TextUtils TU = new TextUtils();

    boolean hasTakenPotion = false;

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        TU.printHeading("You enter the library.");
        sk.rest(wizard);

        libraryAction(wizard);
    }

    public void libraryAction(Wizard wizard) {
        boolean stayInLibrary = true;
        while (stayInLibrary) {
            switch (TU.askInt("What do you want to do ?\n(1) Take a potion\n(2) Leave\n--> ", 2)) {
                case 1 -> {
                    if (hasTakenPotion) {
                        TU.printConsole("You have already taken a potion.");
                    } else {
                        Potion randomPotion = Potion.values()[(int) (Math.random() * Potion.values().length)];
                        TU.printConsole("" +
                                "You take the potion " + randomPotion.getName());
                        wizard.addPotion(randomPotion);
                        hasTakenPotion = true;
                    }
                }
                case 2 -> {
                    TU.printConsole("You leave the library.");
                    hasTakenPotion = false;
                    stayInLibrary = false;
                }
                default -> System.out.println("Invalid choice.");
            }
        }

    }

}
