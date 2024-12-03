package fibonaccisum;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Formula de binet
 *
 */
public class FibonacciSumEvenValued {

    public static void main(String[] args) {
        FibonacciSumEvenValued fibonacciSumEvenValued = new FibonacciSumEvenValued();
        fibonacciSumEvenValued.calculate();
    }

    private void calculate(){
        //4613732
       int a = Stream.iterate(new int[]{1, 2},
                       j -> new int[]{j[1], j[0] + j[1]})
               .map(j -> j[0])
               .filter(i->i%2==0).takeWhile(i -> i < 4000000).mapToInt(val->val).sum();
        System.out.println("value: " + a);
    }
}
