package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class FindSmallest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int smallest = Arrays.stream(input).min().getAsInt();
        for (int i = input.length - 1; i >= 0; i--) {
            if (input[i] == smallest) {
                System.out.println(i);
                break;
            }
        }
    }
}
