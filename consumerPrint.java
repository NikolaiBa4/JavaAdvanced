package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class consumerPrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Consumer<String> consumer = System.out::println;
        String[] input = scan.nextLine().split("\\s+");
        Arrays.stream(input).forEach(consumer);
    }
}