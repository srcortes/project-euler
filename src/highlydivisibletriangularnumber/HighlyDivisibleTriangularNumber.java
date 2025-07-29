package highlydivisibletriangularnumber;

public class HighlyDivisibleTriangularNumber {
    static boolean flag = true;

    public static void main(String[] args) {
            int val = 0;
            int outcome = 0;
            while(flag){
                ++val;
                int value = val * (val + 1 ) / 2;
                outcome = verifyDivisors(value);
            }
        System.out.println(outcome);
    }
    public static int verifyDivisors(int value) {
       int count = 0;
       int sqrt = (int) Math.sqrt(value);   

        for(int j = 1; j < sqrt; j++){
             if(value % j == 0)
               count += 2;
        }

        if( count >= 500)
            flag = false;

       return value;
    }
}
