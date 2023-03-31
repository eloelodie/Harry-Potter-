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
            new Level(new Library(),"Library", null, null),
            new Level(new DungeonsToilets(),"Dungeon toilets", null, new ArrayList<>(Collections.singletonList(Troll))),
            new Level(new SecretChamber(),"Secrets room", new ArrayList<>(Collections.singletonList(Basilisk)), null),
            new Level(new ForbiddenForestLake(),"Forbidden Forest Lake", new ArrayList<>(Arrays.asList(Dementor, Dementor, Dementor)), null),
            new Level(new LittleHangletonCemetery(), "Little Hangleton Cemetery", null, new ArrayList<>(Arrays.asList(Voldemort, PeterPettigrew))),
            new Level(new HogwartsExamRoom(), "Hogwarts examination room", null, new ArrayList<>(Arrays.asList(DoloresUmbridge))),
            new Level(new AstronomyTower(), "Astronomy tower", new ArrayList<>(Arrays.asList(DeathEater, DeathEater, DeathEater)), null),
            new Level(new Hogwarts(), "Hogwartsd", null, new ArrayList<>(Arrays.asList(Voldemort, BellatrixLestrange)))
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
        String name = TU.askStr("What's your name ?\n--> ", true);
        int wandSize = switch (TU.askInt("What size wand do you want ? \n(1) 9 inch \n(2) 11 inch \n(3) 13 inch\n--> ", 3)) {
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
        TU.printHeading("Wizard information");
        TU.printConsole("Name : " + wizard.getName());
        TU.printConsole("Wand : " + wizard.getWand().getSize() + "inch in length and " + wizard.getWand().getCore().getName() + " as the core.");
        TU.printConsole("House : " + wizard.getHouse().getName());
        TU.printConsole("Life points : " + wizard.getHp());
        TU.printConsole("Level : " + wizard.getCurrentLevel());
        TU.printConsole("Last level reached : " + lastLevel);
        TU.printConsole("Spells : " + showKnownSpells());
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
            TU.printHeading("You are on the level " + wizard.getCurrentLevel() + " : " + levels[wizard.getCurrentLevel()].getName());
            TU.printConsole("The last level you reached is the level " + lastLevel + " : " + levels[lastLevel].getName());
            switch (TU.askInt("What do you want to do ? \n(1) Go to the next level \n(2) Go to the library \n(3) Info from your wizard \n(4) Leave the game \n--> ", 3)) {
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
            TU.printConsole("You win !");
            lastLevel = 7;
            return;
        }
        wizard.setCurrentLevel(lastLevel);
        exploreLevel(levels[wizard.getCurrentLevel()]);
    }

    public void goToLibrary() {
        if (alreadyWentLibrary) {
            TU.printConsole("You have already been in the library.");
            return;
        }
        wizard.setCurrentLevel(0);
        exploreLevel(levels[wizard.getCurrentLevel()]);
    }

    public void exploreLevel(Level level) {
        TU.printHeading("You are on the level " + wizard.getCurrentLevel() + " : " + level.getName());
        LevelAction action = level.getLevelAction();
        if (action != null) {
            action.performAction(wizard, (ArrayList<Enemy>) level.getEnemies(), (ArrayList<Boss>) level.getBosses());
            loopMenu();
        }
    }

}

