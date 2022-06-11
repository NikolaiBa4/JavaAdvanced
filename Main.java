package DefiningClasses.Pokemon;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String line = scan.nextLine();
        trainers = fillTrainers(scan, trainers, line);
        String command = scan.nextLine();
        Actions(scan, trainers, command);
        trainers = trainers.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().getBadges().compareTo(e1.getValue().getBadges()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        trainers.forEach((k, v) -> System.out.printf("%s %d %d%n", v.getName(), v.getBadges(), v.getPokemones().size()));
    }

    private static void Actions(Scanner scan, Map<String, Trainer> trainers, String command) {
        while (!command.equals("End")) {
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                Trainer trainer = entry.getValue();
                boolean isContains = trainer.isContains(command, trainer.getPokemones());
                if (isContains) {
                    trainer.setBadges(trainer.getBadges() + 1);
                } else {
                    trainer.getPokemones().stream().forEach(p -> p.setHealth(p.getHealth() - 10));
                }
                for (int i = trainer.getPokemones().size() - 1; i >= 0; i--) {
                    Pokemon pokemon = trainer.getPokemones().get(i);
                    if (pokemon.getHealth() <= 0) {
                        trainer.getPokemones().remove(i);
                    }
                }
            }
            command = scan.nextLine();
        }
    }

    private static Map<String, Trainer> fillTrainers(Scanner scan, Map<String, Trainer> trainers, String line) {
        while (!line.equals("Tournament")) {
            String[] input = line.split("\\s+");
            String name = input[0];
            String pokemonName = input[1];
            String element = input[2];
            int health = Integer.parseInt(input[3]);
            Pokemon pokemon = new Pokemon(pokemonName, element, health);
            if (trainers.containsKey(name)) {
                trainers.get(name).getPokemones().add(pokemon);
            } else {
                Trainer trainer = new Trainer(name, pokemon);
                trainers.put(name, trainer);
            }
            line = scan.nextLine();
        }
        return trainers;
    }
}

//Sam Blastoise Water 18
//Alex Pikachu Electricity 22
//John Kadabra Psychic 90
//Tournament
//Fire
//Electricity
//Fire
//End

//Peter Charizard Fire 100
//George Squirtle Water 38
//Peter Pikachu Electricity 10
//Tournament
//Fire
//Electricity
//End