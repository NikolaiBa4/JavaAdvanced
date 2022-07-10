package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .min()
                .stream()
                .toArray();
        System.out.println(input[0]);
    }
}

//1 2 3 4 6 7 -6 -9