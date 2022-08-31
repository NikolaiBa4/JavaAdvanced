package OOP.oopTwo.barracksWars.core.commands;

import OOP.oopTwo.barracksWars.annototions.Inject;
import OOP.oopTwo.barracksWars.interfaces.Repository;

public class Report extends Command {

    @Inject
    private Repository repository;

    public Report(String[] data) {
        super(data);
    }

    @Override
    public String execute() {
        return this.repository.getStatistics();
    }
}
