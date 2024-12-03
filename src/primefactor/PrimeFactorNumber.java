package primefactor;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeFactorNumber {

    public static void main(String[] args) {
        PrimeFactorNumber primeFactorNumber = new PrimeFactorNumber();
        primeFactorNumber.calculate();
    }

    public void calculate(){
        int outcome  = IntStream.rangeClosed(2, 1000000).boxed()
                .collect(Collectors.partitioningBy(this::isPrime)).get(true)
                .stream().filter(i -> 600851475143L % i == 0).collect(Collectors.toList())
                .stream().max(Comparator.comparing(Function.identity())).get();
        System.out.println(outcome);
    }
    private boolean isPrime(int value){
        int outcome = (int) Math.sqrt(value);
        return IntStream.rangeClosed(2, outcome)
                .noneMatch(i -> value % i == 0);
    }
}
