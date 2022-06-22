package IteratorsAndComparators.StackIterator;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


public class Stack implements Iterable<Integer> {
   private List<Integer> stack=new LinkedList<>();


    public List<Integer> getStack() {
        return stack;
    }

    public void setStack(List<Integer> stack) {
        this.stack = stack;
    }

    public int size() {
        return this.stack.size();
    }

    public void setStack(Integer... ints) {
        this.stack = List.of(ints);
    }

    public int pop() {
        return this.stack.get(stack.size() - 1);
    }

    public void delete() {
        if (!stack.isEmpty()) {
            stack.remove(stack.size() - 1);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public Stack() {
    }

    @Override
    public String toString() {
        return String.format("%s%n", this.getStack().toString());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < stack.size();
            }

            @Override
            public Integer next() {
                int next = stack.get(index);
                index++;
                return next;
            }
        };
    }
}
