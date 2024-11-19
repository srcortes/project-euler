package amadeustest;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TechnicalInterview {

    public static void main(String[] args) {
        System.out.println(percentageLetter("foobar", 'o'));
        System.out.println(percentageLetter("jjjj", 'k'));
        System.out.println(countWords(new String[]{"code", "is", "amazing", "as", "is"},
                new String[]{"amazing","code","is"}));
        System.out.println(countWords(new String[]{"b","bb","bbb"},
                new String[]{"a","aa","aaa"}));
        System.out.println(countWords(new String[]{"a","ab"},
                new String[]{"a","a","a","ab"}));
    }

    private static int percentageLetter(String s, char letter) {
        if(Objects.isNull(s))
            return 0;

        double amount = 0;
        for(char value : s.toCharArray())
            if(value == letter)
                amount += 1;
        return Double.valueOf(amount  / s.length() * 100).intValue();
    }

    private static int countWords(String[] words1, String[] words2) {
        List<String> list1 = new ArrayList<>(Arrays.asList(words1));
        List<String> list2 = new ArrayList<>(Arrays.asList(words2));
        list1.addAll(list2);
        Map<String, Long> map = list1.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        map.values().removeIf(i -> i != 2);
        return map.entrySet().size();
    }
}
