package numberlettercounts;

import java.util.ArrayList;
import java.util.List;

public class NumberLetterCounts {

    public static String[] ones = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    public static String[] teens = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
    public static String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
    public static String[] units = {"hundred", "thousand"};
    private static List<String> sb = new ArrayList<>();

    public static String verifyOnesArray(int value) {
        return ones[value];
    }

    public static String verifyTeensAndTensArray(String value) {
        if (value.length() == 2) {
            int index = Integer.parseInt(value.substring(0, 1));
            int index1 = Integer.parseInt(value.substring(1));

            if (index == 1) {
                return teens[index1];
            } else {
                int index2 = Integer.parseInt(value.substring(0, 1));
                int index3 = Integer.parseInt(value.substring(1));

                if (index3 != 0) {
                    return tens[index2 - 2] + ones[index3];
                } else {
                    return tens[index2 - 2];
                }
            }
        }
        return "";
    }

    public static String verifyThousandsArray(String value) {
        if (value.length() == 4) {
            return ones[Integer.parseInt(value.substring(0, 1))] + units[1];
        }
        return "";
    }

    public static String verifyUnitsArray(String value) {
        int index1 = Integer.parseInt(value.substring(0, 1));
        int index2 = Integer.parseInt(value.substring(1, 2));
        int index3 = Integer.parseInt(value.substring(2, 3));
        var indexOne = ones[index1];
        var indexTwo = units[0];
        

        if (index2 == 0 && index3 == 0) {
            return ones[index1] + units[0];
        } else if (index2 == 0 && index3 != 0) {
            return indexOne + indexTwo + "and" + NumberLetterCounts.verifyOnesArray(index3);
        } else if (index2 != 0 && (index3 == 0 || index3 != 0)) {
            return indexOne + indexTwo  + "and" + NumberLetterCounts.verifyTeensAndTensArray(index2 + "" + index3);
        }

        return "";
    }

    public static void main(String[] args) {
        for (int j = 1; j <= 1000; j++) {
            String value = String.valueOf(j);
            switch (value.length()) {
                case 1 -> sb.add(NumberLetterCounts.verifyOnesArray(j));
                case 2 -> sb.add(NumberLetterCounts.verifyTeensAndTensArray(value));
                case 3 -> sb.add(NumberLetterCounts.verifyUnitsArray(value));
                case 4 -> sb.add(NumberLetterCounts.verifyThousandsArray(value));
            }
        }

        System.out.println(sb.stream().mapToInt(String::length).sum());
    }
}
