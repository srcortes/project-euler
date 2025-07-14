package CollatzProblem;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestCollatzSequence {

    public static void calculate(Long value){
        Map<Long,List<Long>> map = new HashMap<>();
        List<Long> list = new ArrayList<>();
        long key = value;

        list.add(key);

        while(value != 1){
            if(value % 2 == 0){
                value /=  2;
            }else{
                value = (value * 3) + 1;
            }
            map.get(value);
            if(Objects.nonNull(map.get(value))){
                list.addAll(map.get(value));
                break;
            }else{
                list.add(value);
            }
            map.put(key, list);
        }
        map.values(


    }

    public static void main(String[] args) {


       for(long i=1;i<=13;i++){
          LongestCollatzSequence.calculate(i);
       }

    }
}
