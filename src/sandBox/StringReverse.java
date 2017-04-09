package sandBox;

/**
 * Created by Sergey on 4/8/2017.
 */
public class StringReverse {

    public static void main(String[] args) {
        StringReverse s = new StringReverse();
        System.out.println(s.reverse("Hello!"));

    }

    String reverse(String str) {
        if (str.length() == 1) return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }

}
