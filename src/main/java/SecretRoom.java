import java.util.ArrayList;

public class SecretRoom implements LevelAction {

    @Override
    public void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses) {
        System.out.println("You are in a secret room. You can find a treasure here.");
    }

}
