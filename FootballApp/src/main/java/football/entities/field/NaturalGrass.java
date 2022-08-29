package football.entities.field;

public class NaturalGrass extends BaseField{

    private static final int CAPACITY= 250;


    public NaturalGrass(String name) {
        super(name, CAPACITY);

    }

    @Override
    public String getInfo() {
        String player=String.join(" ",getPlayers().stream().toString());
        if (super.getPlayers().size()==0){
            player="none";
        }
        String info= String.format("%s (%s):%n" +
                "Player: %s%n" +
                "Supplement: %d%n" +
                "Energy: %.2f%n",super.getName(),this.getClass().getSimpleName(),player,getSupplement().size(),sumEnergy());
        return info;
    }
}
