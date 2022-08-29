package football.repositories;

import football.entities.supplement.Supplement;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class SupplementRepositoryImpl implements SupplementRepository{

    private Collection<Supplement>supplements;

    public SupplementRepositoryImpl() {
        this.supplements = new LinkedList<>();
    }



    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public void add(Supplement supplement) {
        supplements.add(supplement);

    }

    @Override
    public boolean remove(Supplement supplement) {
        if (supplements.remove(supplement)){
            return true;
        }
        return false;
    }

    @Override
    public Supplement findByType(String type) {
       Supplement supplement=null;
        for (Supplement supp : supplements) {
            if (supp.getClass().getSimpleName().equals(type)){
                supplement=supp;
                break;

            }else {
                return null;
            }
        }
        return supplement;
    }
}
