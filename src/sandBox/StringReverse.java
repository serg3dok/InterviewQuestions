package sandBox;

/**
 * Created by Sergey on 4/8/2017.
 */
public class StringReverse {

    public static void main(String[] args) {
        StringReverse s = new StringReverse();
        System.out.println(s.reverse1("Hello!"));

    }

    String reverse(String str) {
        if (str.length() == 1) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

    String reverse1(String str) {
        StringBuilder result = new StringBuilder();
        for (char i : str.toCharArray()) {
            result.insert(0, i);
        }

        return result.toString();
    }

}
