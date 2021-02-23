import java.util.regex.Pattern;

public class IsRotation {

    public static boolean isRotation(String str1, String str2) {

        return (str1 + str1).matches("(?i).*"

                + Pattern.quote(str2) + ".*");

    }

    public static void main(String[] args) {
        System.out.println(isRotation("helloworld", "orldhellow"));
    }


}
