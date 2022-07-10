package Advanced.FuntionalProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] input = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = Integer.parseInt(scan.nextLine());
        input = Arrays.stream(input).filter(s -> s % n != 0).toArray();
        for (int i = input.length - 1; i >= 0; i--) {
            System.out.print(input[i] + " ");
        }
    }
}
