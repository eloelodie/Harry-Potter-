import java.util.ArrayList;

public class ForbiddenForestLake implements LevelAction {

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        System.out.println("You are in a forbidden forest lake. You can find a treasure here.");
    }

}
