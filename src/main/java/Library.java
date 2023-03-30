import java.util.ArrayList;

public class Library implements LevelAction {

    Skirmishes sk = new Skirmishes();
    TextUtils TU = new TextUtils();

    boolean hasTakenPotion = false;

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        TU.printHeading("Vous entrez dans la bibliothèque.");
        sk.rest(wizard);

        libraryAction(wizard);
    }

    public void libraryAction(Wizard wizard) {
        boolean stayInLibrary = true;
        while (stayInLibrary) {
            switch (TU.askInt("Que voulez-vous faire ?\n(1) Prendre une potion\n(2) Sortir\n--> ", 2)) {
                case 1 -> {
                    if (hasTakenPotion) {
                        TU.printConsole("Vous avez déjà pris une potion.");
                    } else {
                        Potion randomPotion = Potion.values()[(int) (Math.random() * Potion.values().length)];
                        TU.printConsole("Vous prenez la potion " + randomPotion.getName());
                        wizard.addPotion(randomPotion);
                        hasTakenPotion = true;
                    }
                }
                case 2 -> {
                    TU.printConsole("Vous sortez de la bibliothèque.");
                    hasTakenPotion = false;
                    stayInLibrary = false;
                }
                default -> System.out.println("Choix invalide.");
            }
        }

    }

}
