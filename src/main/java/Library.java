public class Library implements LevelAction {

    Skirmishes sk = new Skirmishes();
    TextUtils TU = new TextUtils();

    boolean hasTakenPotion = false;

    @Override
    public void performAction(Wizard wizard) {
        System.out.println("Vous entrez dans la bibliothèque.");
        sk.rest(wizard);
        libraryAction(wizard);
    }

    public void libraryAction(Wizard wizard) {
        switch (TU.askInt("""
                Que voulez-vous faire ?
                1. Prendre une potion
                2. Sortir""", 2)) {
            case 1 -> {
                if (hasTakenPotion) {
                    System.out.println("Vous avez déjà pris une potion.");
                    libraryAction(wizard);
                }
                Potion randomPotion = Potion.values()[(int) (Math.random() * Potion.values().length)];
                System.out.println("Vous prenez la potion " + randomPotion.getName());
                wizard.addPotion(randomPotion);
                libraryAction(wizard);
            }
            case 2 -> {
                System.out.println("Vous retournez dans le couloir.");
            }
            default -> {
                System.out.println("Choix invalide.");
                libraryAction(wizard);
            }
        }
    }

}
