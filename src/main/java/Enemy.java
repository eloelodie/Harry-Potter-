public class Enemy extends AbstractEnemy {

    public Enemy(String name, int maxHp, int damage) {
        setName(name);
        setMaxHp(maxHp);
        setHp(maxHp);
        setDamage(damage);
    }

}
