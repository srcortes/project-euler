package reversestring;

public class ReverseString {
    public static void main(String[] args) {
        String text = "john";
        StringBuilder builder = new StringBuilder();

        for(int j = text.length() - 1; j >= 0; j--){
            builder.append(text.charAt(j));
        }
        System.out.println(builder);
    }
}
