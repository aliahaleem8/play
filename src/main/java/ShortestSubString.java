package Solution;

public class ShortestSubString {
    public static void main(String[] args) {
        System.out.println(testString("abcabcbb",3));
    }

    public static int lengthOfLongestSubstring(String s) {

        int begin = 0, end = 0;
        Boolean unique = true;


        while (end!=s.length()&&unique){
            end++;
            if(s.substring(begin,end).contains(s.substring(end,end))){
                unique = false;
                begin=begin+1;
            }
        }
        return end-begin+1;

    }

    public static Boolean testString(String s, int i){
        return (lengthOfLongestSubstring(s) == i);
    }

    public static void testValues(){

        System.out.println(testString("abcabcbb",3));

    }

}

