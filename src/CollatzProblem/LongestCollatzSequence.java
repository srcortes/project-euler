package CollatzProblem;

import java.util.*;


public class LongestCollatzSequence {
    static Map<Long,Long> map = new HashMap<>();
     

    public static Long calculate(Long value){
        List<Long> list = new ArrayList<>();
        Long key = value;
        
        if(map.containsKey(value)){
            return map.get(value);
        }

        while(value != 1){
            if(value % 2 == 0){

                value /=  2;
            }else{
                value = (value * 3) + 1;
            }
            list.add(value);
        }
       map.put(key, (long) list.size());

       return map.get(key);
    }

    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (Objects.equals(entry.getValue(), value)) {
                return entry.getKey();
            }
        }
        return null;
    }



    public static void main(String[] args) {
       List<Long>j = new ArrayList<>();
       for(long i=1;i<=1000000;i++){
        j.add(LongestCollatzSequence.calculate(i));
       }
        System.out.println(LongestCollatzSequence.getKeyByValue(map, j.stream().mapToLong(k->k).max().getAsLong()));
    }
}
