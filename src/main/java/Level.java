import java.util.List;

public class Level {

    String name;
    List<Enemy> enemies;
    List<Boss> bosses;
    LevelAction levelAction;

    public Level(LevelAction levelAction, String name, List<Enemy> enemies, List<Boss> bosses) {
        this.levelAction = levelAction;
        this.name = name;
        this.enemies = enemies;
        this.bosses = bosses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LevelAction getLevelAction() {
        return levelAction;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Boss> getBosses() {
        return bosses;
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
    }

    public void removeBoss(Boss boss) {
        bosses.remove(boss);
    }

}
