package OOP.oopTwo.barracksWars.core.commands;

import OOP.oopTwo.barracksWars.annototions.Inject;
import OOP.oopTwo.barracksWars.interfaces.Repository;

public class Retire extends Command {

    @Inject
    private Repository repository;

    public Retire(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        try {
            this.repository.removeUnit(this.getData()[1]);
        } catch (Exception e) {
            return e.getMessage();
        }
        return this.getData()[1] + " retired!";
    }
}


