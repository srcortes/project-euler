package sumsquarediference;

public class SumSquareDiference {
    public static void main(String[] args) {
        SumSquareDiference.calculateSquareSum(100);
    }

    public static void calculateSquareSum(int n) {
       int outcomeWithoutSquare = (int) Math.pow((double) (n * (n + 1)) /2, 2);
       int outcomeWithSquare =  (n * (n + 1) * (2 * n + 1)) / 6;
       System.out.println( outcomeWithoutSquare - outcomeWithSquare);
    }
}
