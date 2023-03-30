import java.util.ArrayList;

public interface LevelAction {

    void performAction(Wizard wizard, ArrayList<Enemy> enemies, ArrayList<Boss> bosses);

}
