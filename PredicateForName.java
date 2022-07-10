package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int length = Integer.parseInt(scan.nextLine());
        List<String> names = new LinkedList<>();
        Arrays.stream(scan.nextLine().split("\\s+"))
                .filter(s -> s.length() <= length)
                .forEach(System.out::println);
    }
}

//4
//Sara Sam George Mark John