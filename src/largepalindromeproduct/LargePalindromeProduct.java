package largepalindromeproduct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LargePalindromeProduct {
    public static void main(String[] args) {
        List<Integer> list = IntStream.rangeClosed(100, 999).boxed()
                .collect(Collectors.toList());
        List<Integer> outcome = new ArrayList<>();
        for(int j = list.size()-1; j >= 0 ; j--){
            for(int i = j; i >= 0; i--){
                int value =  list.get(j) * list.get(i);
                StringBuilder builder = new StringBuilder(String.valueOf(value)).reverse();
                if(String.valueOf(value).contentEquals(builder))
                    outcome.add(value);
            }
        }
        System.out.println(outcome.stream().max(Comparator.comparing(Function.identity())).get());
        }







}
