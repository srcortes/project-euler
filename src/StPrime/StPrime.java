package StPrime;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StPrime {
    public static void main(String[] args) {
       StPrime.calculateNumberPosition();

    }

    public static void calculateNumberPosition(){
        List<Integer> listPrime = IntStream.rangeClosed(1, 1000000).boxed().collect(Collectors.toList())
                .stream().filter(StPrime::isPrime).collect(Collectors.toList());
        System.out.println(listPrime.get(10001));

    }

    private static boolean isPrime(int value){
        int outcome = (int) Math.sqrt(value);
        return IntStream.rangeClosed(2, outcome)
                .noneMatch(i -> value % i == 0);
    }
}
