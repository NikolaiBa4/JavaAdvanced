package DefiningClasses.Pokemon;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    String name;
    Integer badges = 0;
    List<Pokemon> pokemones = new ArrayList<>();

    public Trainer(String name, Pokemon Pokemon) {
        this.name = name;
        this.pokemones.add(Pokemon);
    }

    public String getName() {
        return name;
    }

    public void setPokemones(List<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

    public Integer getBadges() {
        return badges;
    }

    public List<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setBadges(Integer badges) {
        this.badges = badges;
    }

    public Boolean isContains(String command, List<Pokemon> pokemones) {
        for (int i = 0; i < pokemones.size(); i++) {
            String element = pokemones.get(i).getElement();
            if (element.equals(command)) {
                return true;
            }
        }
        return false;
    }
}
