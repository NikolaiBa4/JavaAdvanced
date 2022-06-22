package IteratorsAndComparators.StackIterator;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        Stack stack = new Stack();
        while (!line.equals("END")) {
            String[] commandParts = line.split(" ");
            String command = commandParts[0];
            switch (command) {
                case "Push":
                    Pattern pattern=Pattern.compile("(?<Digit>[\\d]+)");
                    Matcher matcher= pattern.matcher(line);
                    while (matcher.find()){
                        int number=Integer.parseInt(matcher.group("Digit"));
                        stack.getStack().add(number);
                    }
                    break;
                case "Pop":
                    try {
                        stack.delete();
                    } catch (NullPointerException e) {
                        System.out.println("No elements");
                    }catch (IndexOutOfBoundsException e){
                        System.out.println("No elements");
                    }
                    break;
            }
            line = scan.nextLine();
        }
        Print(stack);
    }

    private static void Print(Stack stack) {
        for (int j = 0; j < 2; j++) {
            for (int i = stack.size()-1; i >= 0; i--) {
                System.out.println(stack.getStack().get(i));
            }
        }
    }
}

//Push 1, 2, 3, 4, 5, 6, 7
//Pop
//END