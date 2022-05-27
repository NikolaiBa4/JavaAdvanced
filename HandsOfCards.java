package SetsAndMaps;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        int sum = 0;
        Map<String, List<String>> persons = new LinkedHashMap<>();
        Map<String, Integer> points = new HashMap<>();
        while (!line.equals("JOKER")) {
            List<String> deque = new ArrayList<>();
            String[] input = line.split(": ");
            String name = input[0];
            points.putIfAbsent(name, sum);
            sum = points.get(name);
            persons.putIfAbsent(name, deque);
            deque = persons.get(name);
            String[] cards = input[1].split(", ");
            for (String card : cards) {
                if (!deque.contains(card)) {
                    deque.add(card);
                    String[] values = card.split("");
                    String type = values[values.length - 1];
                    int multiplier = returnMultiplier(type);
                    String symbol = values[0];
                    int value = returnValue(symbol);
                    sum += multiplier * value;
                }
            }
            points.put(name, sum);
            sum = 0;
            line = scan.nextLine();
        }
        persons.forEach((k, v) -> System.out.printf("%s: %d%n", k, points.get(k)));
    }

    private static int returnValue(String symbol) {
        int value = 2;
        switch (symbol) {
            case "2":
                value = 2;
                break;
            case "3":
                value = 3;
                break;
            case "4":
                value = 4;
                break;
            case "5":
                value = 5;
                break;
            case "6":
                value = 6;
                break;
            case "7":
                value = 7;
                break;
            case "8":
                value = 8;
                break;
            case "9":
                value = 9;
                break;
            case "1":
                value = 10;
                break;
            case "J":
                value = 11;
                break;
            case "Q":
                value = 12;
                break;
            case "K":
                value = 13;
                break;
            case "A":
                value = 14;
                break;
        }
        return value;
    }

    private static int returnMultiplier(String type) {
        int multiplier = 1;
        switch (type) {
            case "S":
                multiplier = 4;
                break;
            case "H":
                multiplier = 3;
                break;
            case "D":
                multiplier = 2;
                break;
            case "C":
                multiplier = 1;
                break;
        }
        return multiplier;
    }
}

//Peter: 2C, 4H, 9H, AS, QS
//Slav: 3H, 10S, JC, KD, 5S, 10S
//Alex: QH, QC, QS, QD
//Slav: 6H, 7S, KC, KD, 5S, 10C
//Alex: QH, QC, JS, JD, JC
//Peter: JD, JD, JD, JD, JD, JD
//JOKER

//Jonathan Davis: JD, JD, JD, JD
//JOKER