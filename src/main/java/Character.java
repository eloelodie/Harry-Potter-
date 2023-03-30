public abstract class Character {

    private String name;
    private int maxHp;
    private int hp;
    private int maxMana;
    private int mana;
    private int damage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public void setMaxMana(int maxMana) {
        this.maxMana = maxMana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void useMana(int mana) {
        this.mana -= mana;
        if (this.mana < 0) {
            this.mana = 0;
        }
    }

    public void heal(int hp) {
        this.hp += hp;
        if (this.hp > maxHp) {
            this.hp = maxHp;
        }
    }

    public void damage(int hp) {
        this.hp -= hp;
        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void attack(Character target, int damage) {
        if (target instanceof Wizard wizard) {
            if (wizard.getHouse() == House.GRYFFINDOR) {
                damage -= 4 * wizard.getCurrentLevel();
            }
        }
        target.damage(damage);
    }

}
