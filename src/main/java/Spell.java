public class Spell extends AbstractSpell {
    Spell(String name, int damage, int manaCost) {
        setName(name);
        setDamage(damage);
        setManaCost(manaCost);
    }

    public void castSpell(Character caster, Character target) {

        if (this.manaCost > caster.getMana()) {
            System.out.println("Pas assez de mana !");
            return;
        }

        int aimCoef = 10;
        int bonusDmgDealt = 0;
        if (caster instanceof Wizard wizard) {
            if (wizard.getHouse() == House.SLYTHERIN) {
                bonusDmgDealt = 10;
            }
            if (wizard.getHouse() == House.RAVENCLAW) {
                aimCoef = 15;
            }
        }

        int accuracy = (int) (Math.random() * aimCoef);
        int damageDealt = this.getDamage() * accuracy + bonusDmgDealt;

        target.damage(damageDealt);
        caster.useMana(this.manaCost);
    }

}
