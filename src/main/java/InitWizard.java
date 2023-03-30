import java.lang.Math;

public class InitWizard {

    SortingHat SHat = new SortingHat();

    public House HouseSetter() {
        return switch ((int) (Math.random() * 3)) {
            case 0 -> SHat.gryffindor();
            case 1 -> SHat.hufflepuff();
            case 2 -> Math.random() < 0.5 ? SHat.slytherin() : SHat.ravenclaw();
            default -> null;
        };
    }

    public Core WandCoreSetter() {
        return switch ((int) (Math.random() * 3)) {
            case 0 -> Core.PHOENIX_FEATHER;
            case 1 -> Core.DRAGON_HEARTSTRING;
            case 2 -> Core.UNICORN_HAIR;
            default -> null;
        };
    }

    public Pet PetSetter() {
        return switch ((int) (Math.random() * 3)) {
            case 0 -> Pet.OWL;
            case 1 -> Pet.CAT;
            case 2 -> Math.random() < 0.5 ? Pet.RAT : Pet.TOAD;
            default -> null;
        };
    }

}
