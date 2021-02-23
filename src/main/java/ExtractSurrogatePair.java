import java.util.ArrayList;
import java.util.List;

public class ExtractSurrogatePair {

    public static List<Integer> extract(String str) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            int cp = str.codePointAt(i);

            if (i < str.length()-1

                    && str.codePointCount(i, i+2) == 1) {

                result.add(cp);

                result.add(str.codePointAt(i+1));

                i++;

            }

        }

        return result;

    }

    public static List<Integer> extract2(String str) {

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {

            int cp = str.codePointAt(i);

            // the constant 2 means a suroggate pair

            if (Character.charCount(cp) == 2) {

                result.add(cp);

                result.add(str.codePointAt(i+1));

                i++;

            }

        }

        return result;

    }



    public static void main(String[] args) {
        char[] musicalScore = new char[]{'\uD83C', '\uDFBC'};

        char[] smileyFace = new char[]{'\uD83D', '\uDE0D'};

        char[] twoHearts = new char[]{'\uD83D', '\uDC95'};

        char[] cyrillicZhe = new char[]{'\u04DC'};

        String str = "is " + String.valueOf(cyrillicZhe) + " zhe "

                + String.valueOf(twoHearts) + " two hearts "

                + String.valueOf(smileyFace) + " smiley face and, "

                + String.valueOf(musicalScore) + " musical score "
                + String.valueOf(Character.toChars(128149));



        System.out.println(str);

    }
}

/*

Java takes advantage of this representation and exposes it via a suite of methods, such as codePointAt(), codePoints(), codePointCount(), and offsetByCodePoints() (take a look at the Java documentation for details).
Calling codePointAt() instead of charAt(), codePoints() instead of chars(), and so on helps us write solutions that cover ASCII and Unicode characters as well.
 */