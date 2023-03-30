import java.util.ArrayList;

public class PoudlardExamRoom implements LevelAction {

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        System.out.println("You are in a exam room. You can find a treasure here.");
    }

}
