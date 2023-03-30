import java.util.ArrayList;

public class Hogwarts implements LevelAction {

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        System.out.println("You are in Hogwarts. You can find a treasure here.");
    }

}
