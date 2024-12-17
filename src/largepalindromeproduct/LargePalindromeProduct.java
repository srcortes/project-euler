package largepalindromeproduct;

public class LargePalindromeProduct {

    private static int maxPalindrome = 0;
    public static void main(String[] args) {
        LargePalindromeProduct.calculatePalindromeNumberOptimizationV1();
        LargePalindromeProduct.calculatePalindromeNumberOptimizationV2();

    }

    private static void calculatePalindromeNumberOptimizationV1(){
        for(int j = 999; j >= 100 ; j--){
            for(int i = j; i >= 100; i--){
                int value = j * i;
                if(value < maxPalindrome)
                    break;

                if(isPalindrome(value))
                    maxPalindrome = value;
            }
        }
        System.out.println("1.) " + System.currentTimeMillis());
        System.out.println(maxPalindrome);
    }

    private static void calculatePalindromeNumberOptimizationV2(){
       for(int j = 999; j >= 100; j--){
           int initial = j % 11 == 0 ? 999:990;
           int step = j % 11 == 0 ? 1:11;

           for(int b= initial; b >= 100; b -= step){
               int value = j * b;
               if(value < maxPalindrome)
                   break;

               if(isPalindrome(value))
                   maxPalindrome = value;

           }
       }
        System.out.println("2.) "+System.currentTimeMillis());
        System.out.println(maxPalindrome);
    }
    private static boolean isPalindrome(int value){
        String number = Integer.toString(value);
        int increment = 0;
        int decrement = number.length() - 1;
        while(increment < decrement){
            if(number.charAt(increment) != number.charAt(decrement)){
              return false;
            }
            increment++;
            decrement--;
        }
        return true;
    }
}
