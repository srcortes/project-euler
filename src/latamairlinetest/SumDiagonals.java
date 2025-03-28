package latamairlinetest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class SumDiagonals {
    public static void main(String[] args) {

        List<List<Integer>>  list = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6), Arrays.asList(7, 8, 9));


        int principalDiagonal = IntStream.range(0, list.size()).map(i -> list.get(i).get(i))
                .peek(System.out::println)
                .sum();


        int  secondaryDiagonal = IntStream.range(0, list.size())
                .map(i -> list.get(i).get((list.size() -1) - i))
                .peek(System.out::println)
                .sum();
        System.out.println("Principal Diagonal: " + principalDiagonal);
        System.out.println("Secondary Diagonal: " + secondaryDiagonal);
        System.out.println("Diagonals: " + Math.abs(principalDiagonal - secondaryDiagonal));








    }
}
