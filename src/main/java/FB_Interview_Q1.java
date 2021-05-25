/*

given string  = "facebook"
reverse all vowels within string

return "focobeak"

 */

public class FB_Interview_Q1 {


    // utility function to check for vowel
    static boolean isVowel(char c) {
        return (c == 'a' || c == 'A' || c == 'e'
                || c == 'E' || c == 'i' || c == 'I'
                || c == 'o' || c == 'O' || c == 'u'
                || c == 'U');
    }
}
