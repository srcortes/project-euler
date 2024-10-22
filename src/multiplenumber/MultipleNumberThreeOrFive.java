package multiplenumber;

import java.util.stream.IntStream;
public class MultipleNumberThreeOrFive {
    public static void main(String[] args) {
        System.out.println(calculate());
        System.out.println(newCalculate(3) + newCalculate(5) - newCalculate(15));
    }
    private static int calculate(){
      return IntStream.rangeClosed(0,999).map(j -> {
           int outcome = 0;
           if(j % 3 == 0 || j % 5 == 0)
               outcome = j;
           return outcome;
       }).sum();
    }

    private static int newCalculate(int value){
        int p = 999 / value;
        return value * (p * (p + 1)) / 2;
    }
}
