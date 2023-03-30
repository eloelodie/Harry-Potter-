import java.util.ArrayList;

public class AstronomyTower implements LevelAction {

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        System.out.println("You are in a tower. You can find a treasure here.");
    }

}
