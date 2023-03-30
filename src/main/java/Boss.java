import java.util.ArrayList;

public class Boss extends AbstractEnemy {

    ArrayList<ForbiddenSpell> knownForbiddenSpells;

    public Boss(String name, int maxHp, int damage, ArrayList<ForbiddenSpell> knownForbiddenSpells, int maxMana) {
        setName(name);
        setMaxHp(maxHp);
        setHp(maxHp);
        setMaxMana(maxMana);
        setMana(maxMana);
        setDamage(damage);
        this.knownForbiddenSpells = knownForbiddenSpells;
    }

    public ArrayList<ForbiddenSpell> getKnownForbiddenSpells() {
        return knownForbiddenSpells;
    }

}
