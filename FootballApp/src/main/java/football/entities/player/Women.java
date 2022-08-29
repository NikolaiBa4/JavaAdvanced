package football.entities.player;

public class Women extends BasePlayer{

    private static final double INITIAL_KILOGRAMS=60;
    private static final int INCREASING_RATE=115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(INITIAL_KILOGRAMS);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength()+INCREASING_RATE);
    }

}
