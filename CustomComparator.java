package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] even = Arrays.stream(input).
                filter(s -> s % 2 == 0)
                .sorted()
                .toArray();
        int[] odd = Arrays.stream(input)
                .filter(s -> s % 2 != 0)
                .sorted()
                .toArray();
        Arrays.stream(even).forEach(s -> System.out.printf("%d ", s));
        Arrays.stream(odd).forEach(s -> System.out.printf("%d ", s));
    }
}

//1 2 3 4 5 6 7 8 9 10