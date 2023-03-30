import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Game {

    TextUtils TU = new TextUtils();
    InitWizard IWiz = new InitWizard();
    Skirmishes sk = new Skirmishes();

    // Wizard
    Wizard wizard;

    // Forbidden Spells
    ForbiddenSpell avadaKedavra = new ForbiddenSpell("Avada Kedavra", 50, 10, 20);
    ForbiddenSpell imperio = new ForbiddenSpell("Imperio", 40, 7, 15);
    ForbiddenSpell crucio = new ForbiddenSpell("Crucio", 30, 5, 10);

    // Enemies
    Enemy Basilisk = new Enemy("Basilisk", 40, 15);
    Enemy Dementor = new Enemy("Dementor", 30, 10);
    Enemy DeathEater = new Enemy("Death Eater", 20, 5);

    // Boss
    Boss Troll = new Boss("Troll", 50, 15, null, 0);
    Boss Voldemort = new Boss("Voldemort", 100, 30, new ArrayList<>(Arrays.asList(avadaKedavra, crucio)), 50);
    Boss PeterPettigrew = new Boss("Peter Pettigrew", 50, 20, new ArrayList<>(Arrays.asList(imperio, crucio)), 30);
    Boss DoloresUmbridge = new Boss("Dolores Umbridge", 60, 25, new ArrayList<>(Arrays.asList(imperio, crucio)), 30);
    Boss BellatrixLestrange = new Boss("Bellatrix Lestrange", 60, 25, new ArrayList<>(Arrays.asList(avadaKedavra, imperio)), 30);

    Level[] levels = new Level[]{
            new Level(new Library(),"Bibliothèque", null, null),
            new Level(new DungeonsToilets(),"Toilettes du donjon", null, new ArrayList<>(Collections.singletonList(Troll))),
            new Level(new SecretChamber(),"Chambre des secrets", new ArrayList<>(Collections.singletonList(Basilisk)), null),
            new Level(new ForbiddenForestLake(),"Lac dans la Forêt Interdite", new ArrayList<>(Arrays.asList(Dementor, Dementor, Dementor)), null),
            new Level(new LittleHangletonCemetery(), "Cimetière de Little Hangleton", null, new ArrayList<>(Arrays.asList(Voldemort, PeterPettigrew))),
            new Level(new PoudlardExamRoom(), "Salle d’examen de Poudlard", null, new ArrayList<>(Arrays.asList(DoloresUmbridge))),
            new Level(new AstronomyTower(), "Tour d’astronomie", new ArrayList<>(Arrays.asList(DeathEater, DeathEater, DeathEater)), null),
            new Level(new Hogwarts(), "Poudlard", null, new ArrayList<>(Arrays.asList(Voldemort, BellatrixLestrange)))
    };

    int lastLevel = 0;
    boolean alreadyWentLibrary = false;
    boolean running = false;

    public void start() {
        TextUtils TU = new TextUtils();
        TU.printHeading("Harry Potter RPG");
        initialisation();
    }

    public void initialisation() {
        String name = TU.askStr("Quel est votre nom ?\n--> ", true);
        int wandSize = switch (TU.askInt("Quelle taille de baguette voulez-vous ? \n(1) 9cm \n(2) 11cm \n(3) 13cm\n--> ", 3)) {
            case 1 -> 9;
            case 2 -> 11;
            case 3 -> 13;
            default -> 0;
        };
        Wand wand = new Wand(IWiz.WandCoreSetter(), wandSize);
        wizard = new Wizard(name, wand, 100, 30);
        House house = IWiz.HouseSetter();
        wizard.setHouse(house);
        wizard.addSpell(sk.getSpells()[0]);
        wizardInfo();

        running = true;
        loopMenu();
    }

    public void wizardInfo() {
        TU.printHeading("Informations du sorcier");
        TU.printConsole("Nom : " + wizard.getName());
        TU.printConsole("Baguette : " + wizard.getWand().getSize() + "cm de longueur et de " + wizard.getWand().getCore().getName() + " comme noyau.");
        TU.printConsole("Maison : " + wizard.getHouse().getName());
        TU.printConsole("Points de vie : " + wizard.getHp());
        TU.printConsole("Niveau : " + wizard.getCurrentLevel());
        TU.printConsole("Dernier niveau atteint : " + lastLevel);
        TU.printConsole("Sorts : " + showKnownSpells());
    }

    public String showKnownSpells() {
        StringBuilder spellsKnown = new StringBuilder();
        for (Spell spell : wizard.getKnownSpells()) {
            spellsKnown.append(spell.getName()).append(", ");
        }
        return spellsKnown.toString();
    }

    public void loopMenu(){
        while (running) {
            TU.printHeading("Vous êtes au niveau " + wizard.getCurrentLevel() + " : " + levels[wizard.getCurrentLevel()].getName());
            TU.printConsole("Le dernier niveau que vous avez atteint est le niveau " + lastLevel + " : " + levels[lastLevel].getName());
            switch (TU.askInt("Que voulez-vous faire ? \n(1) Aller au niveau suivant \n(2) Aller à la bibliothèque \n(3) Info de votre sorcier \n(4) Quitter le jeu \n--> ", 3)) {
                case 1 -> nextLevel();
                case 2 -> goToLibrary();
                case 3 -> wizardInfo();
                case 4 -> running = false;
            }
            TU.printSeparator(20);
        }
    }

    public void nextLevel() {
        alreadyWentLibrary = false;
        lastLevel++;
        if (lastLevel > 7) {
            TU.printConsole("Vous avez gagné !");
            lastLevel = 7;
            return;
        }
        wizard.setCurrentLevel(lastLevel);
        exploreLevel(levels[wizard.getCurrentLevel()]);
    }

    public void goToLibrary() {
        if (alreadyWentLibrary) {
            TU.printConsole("Vous avez déjà été dans la bibliothèque.");
            return;
        }
        wizard.setCurrentLevel(0);
        exploreLevel(levels[wizard.getCurrentLevel()]);
    }

    public void exploreLevel(Level level) {
        TU.printHeading("Vous êtes au niveau " + wizard.getCurrentLevel() + " : " + level.getName());
        LevelAction action = level.getLevelAction();
        if (action != null) {
            action.performAction(wizard, (ArrayList<Enemy>) level.getEnemies(), (ArrayList<Boss>) level.getBosses());
            loopMenu();
        }
    }

}
