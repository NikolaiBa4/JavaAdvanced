package IteratorsAndComparators.Froggy;

import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer>{
    private List<Integer>lake;

    public Lake(List<Integer> ints) {
        this.lake = ints;
    }
    public boolean hasNext(int index){
        return index<= lake.size()-1;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Frog();
    }
     class Frog implements Iterator<Integer>{
       private int index=0;
       boolean isFinish=false;
        @Override
        public boolean hasNext() {
            return index< lake.size();
        }

        @Override
        public Integer next() {
            int numberToReturn= lake.get(index);
            index+=2;
            if (index>= lake.size()&& !isFinish){
                index=1;
                isFinish=true;
            }
            return numberToReturn;
        }
    }
}
