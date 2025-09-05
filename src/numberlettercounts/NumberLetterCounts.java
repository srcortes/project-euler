package numberlettercounts;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class NumberLetterCounts {

    public static String[] ones = {"zero","one","two","three","four","five","six","seven","eight","nine"};
    public static String[] teens = {"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    public static String[] tens = {"twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    public static String[] units = {"hundred","thousand"};





    public static void main(String[] args) {
        List<String> sb = new ArrayList<>();
        int oneNumbers = ones.length - 1;
        int teensNumbers = teens.length - 1;

        for(int j = 1; j <= 20 ; j++){
            String value = String.valueOf(j);
            if(value.length()==1){
                sb.add(ones[oneNumbers--]);
            }

            if(value.length() == 2){
               char c = value.charAt(0);
               if(c == '1'){
                   sb.add(teens[teensNumbers--]);
               }
            }
        }

        System.out.println(sb);

    }
}
