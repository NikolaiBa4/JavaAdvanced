package IteratorsAndComparators.Froggy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line=scan.nextLine();
        Lake lake=null;
        while (!line.equals("END")){
            List<Integer> input= Arrays.stream(line.split(", "))
                    .map(Integer::parseInt).collect(Collectors.toList());
            lake=new Lake(input);
            line=scan.nextLine();
        }
        int counter=0;
        for (Integer stone : lake) {
            counter++;
            if (lake.hasNext(counter)){
            System.out.printf("%d, ",stone);
            }else {
                System.out.printf("%d",stone);
            }

        }
    }
}
