package specialpythagoreantriplet;

import java.util.ArrayList;
import java.util.List;

public class PythagoreanTriplet {

    public static void main(String[] args) {
        List<Integer[]>  list = new ArrayList<>();
       for(int j = 2; j < 1000; j++) {
           for(int k = 1; k < 1000; k++) {
               if(j > k) {
                    int a = (int) (Math.pow(j, 2) - Math.pow(k, 2));
                    int b = 2 * j * k;
                    int c = (int) (Math.pow(j, 2) + Math.pow(k, 2));
                    list.add(new Integer[]{a, b, c});
               } else{
                   break;
               }
           }
       }
        list.forEach((arr) -> {
            if(arr[0] + arr[1] + arr[2] == 1000) {
                System.out.println(arr[0] * arr[1] * arr[2]);
            }
        });
    }

}
