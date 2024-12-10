package largepalindromeproduct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargePalindromeProduct {

    private static List<Integer> outcome = new ArrayList<>();
    public static void main(String[] args) {
        LargePalindromeProduct.calculatePalindromeNumberOptimizationV1();
        //LargePalindromeProduct.calculatePalindromeNumberOptimizationV2();

    }

    private static void calculatePalindromeNumberOptimizationV1(){
        List<Integer> list = IntStream.rangeClosed(100, 999).boxed()
                .collect(Collectors.toList());
        for(int j = list.size()-1; j >= 0 ; j--){
            for(int i = j; i >= 0; i--){
                int value = list.get(j) * list.get(i);
                acumulateNumberPalindrome(value);
            }
        }
        System.out.println(outcome.stream().max(Comparator.comparing(Function.identity())).get());

    }
    private static void acumulateNumberPalindrome(int value){
        String number = Integer.toString(value);
        int increment = 0;
        int decrement = number.length() - 1;
        boolean isNotPalindrome = false;
        while(increment < decrement && !isNotPalindrome){
            if(number.charAt(increment) == number.charAt(decrement)){
                increment++;
                decrement--;
            } else {
                isNotPalindrome = true;
            }
        }
        if(!isNotPalindrome)
            outcome.add(value);
    }


}
