package latticepath;

import java.math.BigInteger;

public class LatticePaths {

    public static BigInteger calculatePath(int n, int m){
        BigInteger a = BigInteger.valueOf(n + m);
        BigInteger b = BigInteger.valueOf(n);
        BigInteger c = BigInteger.valueOf(m);

        for(long j = (n + m) -1; j >= 1; j--){
           a = a.multiply(BigInteger.valueOf(j));
        }

        for(long i = n -1; i >= 1; i--){
            b = b.multiply(BigInteger.valueOf(i));
        }

        for(long k = m -1; k >= 1; k--){
            c = c.multiply(BigInteger.valueOf(k));
        }

        return a.divide(b.multiply(c));
    }

    public static void main(String[] args) {
        System.out.println(LatticePaths.calculatePath(20,20));
    }

}
