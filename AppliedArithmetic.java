package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String line = scan.nextLine();
        while (!line.equals("end")) {
            switch (line) {
                case "add":
                    input = add(input);
                    break;
                case "multiply":
                    input = multiply(input);
                    break;

                case "subtract":
                    input = subtract(input);
                    break;
                case "print":
                    print(input);
                    break;
            }
            line = scan.nextLine();
        }
    }

    private static void print(int[] input) {
        Arrays.stream(input).forEach(s -> System.out.print(s + " "));
    }

    private static int[] subtract(int[] input) {
        input = Arrays.stream(input).map(s -> s - 1).toArray();
        return input;
    }

    private static int[] multiply(int[] input) {
        input = Arrays.stream(input).map(s -> s * 2).toArray();
        return input;
    }

    private static int[] add(int[] input) {
        input = Arrays.stream(input).map(s -> s + 1).toArray();
        return input;
    }
}
