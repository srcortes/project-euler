package smallestmultiple;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallesMultiple {
    public static void main(String[] args) {
        SmallesMultiple smallesMultiple = new SmallesMultiple();
        smallesMultiple.calculate();
        smallesMultiple.calculateNewVersion();

    }

    public void calculate() {
        final long start = System.nanoTime();
        int count = 2, outcome = 1;
        boolean flag = true;
        while (flag) {
            for (int j = 1; j < 21; j++) {
                if (count % j != 0) {
                    outcome = 0;
                    break;
                } else {
                    outcome = count;
                }
                if (j == 20)
                    flag = false;
            }
            count++;
        }
        long end = System.nanoTime();
        long elapsedTimeNs = end - start;
        double elapsedTimeSeconds = elapsedTimeNs / 1_000_000_000.0;
        System.out.println("Outcome: "  + outcome +  " Execution time in seconds: " + elapsedTimeSeconds);
    }

    private void calculateNewVersion() {
        final long start = System.nanoTime();
        Integer count = 1;
        Integer outcome = 1;
        List<Integer> list = IntStream.range(2, 20).boxed().collect(Collectors.toList());
        List<Integer> listPrime = list.stream().filter(this::isPrime).collect(Collectors.toList());
        int val = listPrime.size() - 1;
        for (int j = 0; j < listPrime.size(); j++) {
            for (int i = 0; i < list.size(); i++) {
                count = (int) Math.pow(listPrime.get(j), val == 0 ? 1 : val--);
                if (list.contains(count)) {
                    outcome *= count;
                    break;
                }
            }
        }
        long end = System.nanoTime();
        long elapsedTimeNs = end - start;
        double elapsedTimeSeconds = elapsedTimeNs / 1_000_000_000.0;
        System.out.println("Outcome: "  + outcome +  " Execution time in seconds: " + elapsedTimeSeconds);
    }
    private boolean isPrime(int value) {
        int outcome = (int) Math.sqrt(value);
        return IntStream.rangeClosed(2, outcome)
                .noneMatch(i -> value % i == 0);
    }
}
