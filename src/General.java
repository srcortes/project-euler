import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class General {

    public static void main(String[] args) {
        General general = new General();
        /*Integer nums[] = {1, 2, 2, 4, 5, 6, 7, 7, 9, 10};
        Stream<Integer> stream = Stream.of(nums);
        List<Integer> map = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().distinct()
                .map(Map.Entry::getKey).toList();
        nums = map.toArray(new Integer[0]);
        System.out.println(Arrays.toString(nums));*/


        int nums2[] = {1, 3, 6, 4, 1, 2};
        System.out.println(general.solution(nums2));
        /*int nums3[] = {1, 2, 3};
        System.out.println(general.solution(nums3));
        int nums4[] = {-1, -3};
        System.out.println(general.solution(nums4));*/


    }

    public int solution(int[] A) {
        int min = Arrays.stream(A).min().orElse(0);
        for(int j = 0; j < A.length; j++) {
            if(A[j] < 0){
                return 1;
            }
            if(A[j] > 0){
                if(A[j] == (min)) {
                    min++;
                }
            }
        }
        return min;
    }

}
