package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.Collection;
import java.util.LinkedList;
import java.util.stream.Collectors;

public abstract class BaseField implements Field{

    private String name;
    private int capacity;
    private Collection<Supplement>supplements;
    private Collection<Player>players;

    public BaseField(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        supplements=new LinkedList<>();
        players=new LinkedList<>();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplement() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int sumEnergy() {
      int totalEnergy=  0;
        for (Supplement supplement : supplements) {
           totalEnergy+= supplement.getEnergy();
        }
      return totalEnergy;
    }

    @Override
    public void addPlayer(Player player) {
        if(players.size()>=capacity){
            throw new IllegalStateException("Not enough capacity.");
        }
        players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {

        supplements.add(supplement);

    }

    @Override
    public void drag() {
        players.stream().forEach(p->p.stimulation());
    }



    @Override
    public String getInfo(){
        StringBuilder player=new StringBuilder();
        for (Player player1 : players) {
          player.append( player1.getName()+" ");
        }

       String info= String.format("%s (%s):%n" +
                "Player: %s%n" +
                "Supplement: %d%n" +
                "Energy: %d",this.getName(),this.getClass().getSimpleName()
                ,player.toString().trim(),this.supplements.size(),sumEnergy());
        return info;
    }

}
