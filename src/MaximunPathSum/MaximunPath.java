package MaximunPathSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximunPath {

    private static int outcome = 0;
    private static List<Integer> visitado = new ArrayList<>();
    private static int currentLength = 0;

    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(3));
        triangle.add(Arrays.asList(7, 4));
        triangle.add(Arrays.asList(2, 4, 6));
        triangle.add(Arrays.asList(8, 5, 9, 3));

        for(int i = 0; i < triangle.size(); i++){
            if(triangle.get(i).size() == 1){
                visitado.add(triangle.get(i).get(0));
                currentLength = triangle.get(i).size();
                continue;
            }
           
            currentLength = triangle.get(i).size();
       
             
            System.out.println(triangle.get(i).subList(0, currentLength));
           
        }



    }
}
