package powerdigitsum;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class PowerDigitSum {
    public static void main(String[] args) {

       List<BigInteger> digits = new ArrayList<>();
       String twoToThePowerOfFifteen = BigInteger.valueOf(2).pow(1000).toString();
       

        for(Character c : twoToThePowerOfFifteen.toCharArray()) {
            digits.add(new BigInteger(c.toString()));
        }

        System.out.println(digits.stream().mapToInt(BigInteger::intValue).sum());
    }
}
