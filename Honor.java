package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class Honor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split("\\s+");
        Consumer<String> consumer = s -> System.out.println("Sir " + s);
        Arrays.stream(input).forEach(consumer);
    }
}
