package OOP.oopTwo.barracksWars;

import OOP.oopTwo.barracksWars.core.CommandInterpreterImpl;
import OOP.oopTwo.barracksWars.core.Engine;
import OOP.oopTwo.barracksWars.core.factories.UnitFactoryImpl;
import OOP.oopTwo.barracksWars.data.UnitRepository;
import OOP.oopTwo.barracksWars.interfaces.Repository;
import OOP.oopTwo.barracksWars.interfaces.UnitFactory;

public class Main {
    public static void main(String[] args) {

        final Repository repository = new UnitRepository();

        final UnitFactory unitFactory = new UnitFactoryImpl();

        final CommandInterpreterImpl commandInterpreter = new CommandInterpreterImpl(repository, unitFactory);

        final Engine engine = new Engine(commandInterpreter);

        engine.run();
    }
}


