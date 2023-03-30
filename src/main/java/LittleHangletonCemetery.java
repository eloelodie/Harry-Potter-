import java.util.ArrayList;

public class LittleHangletonCemetery implements LevelAction {

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        System.out.println("You are in a cemetery. You can find a treasure here.");
    }

}
