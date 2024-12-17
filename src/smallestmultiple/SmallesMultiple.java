package smallestmultiple;


public class SmallesMultiple {
    public static void main(String[] args) {
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
        System.out.println(outcome);
    }
}
