package summationprimes;

import java.math.BigInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SummationOfPrimes {
    public static void main(String[] args) {

        BigInteger a = Stream.iterate(BigInteger.ONE, n -> n.add(BigInteger.ONE))
                .limit(2000000).skip(1).filter(SummationOfPrimes::isPrime)
                .reduce(BigInteger::add).get();
        System.out.println(a);
    }

    private static boolean isPrime(BigInteger value){
        int outcome = value.sqrt().intValue();
        return IntStream.rangeClosed(2, outcome)
                .noneMatch(i -> value.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO));
    }
}
