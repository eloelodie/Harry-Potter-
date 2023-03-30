public class ForbiddenSpell extends AbstractSpell {

    int sacrifiedHp;

    public ForbiddenSpell(String name, int damage, int manacost, int sacrifiedHp) {
        setName(name);
        setDamage(damage);
        setManaCost(manacost);
        this.sacrifiedHp = sacrifiedHp;
    }

    public void castSpell(Character caster, Character target) {
        if (this.manaCost > caster.getMana()) {
            System.out.println("Not enough mana !");
            return;
        }
        caster.setHp(caster.getHp() - this.sacrifiedHp);
        target.damage(this.getDamage());
        caster.useMana(this.manaCost);
    }

}
