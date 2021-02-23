import java.util.HashMap;

public class StringExtractWordMaxTimes {

    public static void main(String[] args) {

    }

    public int solution(String s){
        int c = 0;

        HashMap<Character, Integer> hm = getCharacterIntegerHashMap(s);

        c = getMaxCountMatch(hm, "BALLOON");

        return c;
    }

    private HashMap<Character, Integer> getCharacterIntegerHashMap(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i<= s.length(); i ++){
            if (!hm.containsKey(s.charAt(i))) {
                hm.put(s.charAt(i), 1);
            }
            else hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
        }
        return hm;
    }

    private int getMaxCountMatch(HashMap<Character, Integer> hm, String t) {

        int c = 0;

        for (int i = 0; i<t.length(); i++){

        }

        return c;

    }
}


/*---A string S consisting of uppercase English letters is given. In one move we can delete seven letters from S, forming the word "BALLOON" (one 'B', one 'A', two 'L's, two 'O's and one 'N'), and leave a shorter word in S.
If the remaining letters in the shortened S are sufficient to allow another instance of the word "BALLOON" to be removed, next move can be done. What is the maximum number of such moves that we can apply to S?
Write a function: class Solution public int solution(String s); } that, given a string S of length N, returns the maximum number of moves that can be applied.
Examples: 1. Given S="BAONXXOLL", the function should return 1. BAONXXOLL-XX
2. Given S="BACOLLNNOLOLGBAX, the function should return BASTOLLA NOLASGHAR BOLGAXGX
Given S="QAWABAWONL", the function should return 0. QAWABAWONL
Given S="ONLABLABLOON', the function should return 1. ONLABLABLOON OLABN
Write an efficient algorithm for the following assumptions:
• N is an integer within the range 1.200,000):
• string S consists only of uppercase letters (A-2).
ANSWER COMMENTS:

def removeCountOptimized(S):
countLetters = Counter(S)
if 'B' not in countLetters or 'A' not in countLetters or 'L' not in countLetters or 'O' not in countLetters or 'N' not in countLetters:
return 0 #no deletion possible
return countDeletions(countLetters)

def countDeletions(countLetters):
countSingle = min(countLetters['B'], countLetters['A'], countLetters['N'])
countDoubles = min(countLetters['L'] // 2, countLetters['O']//2)
if countSingle == 0 or countDoubles == 0:
    return 0
return min(countDoubles, countSingle)

this is what i came up with. my brute force was to iterate and make the removals naturally, but all we care about is the minimum single char count (B A N) and the minimum double char count (L O)

ANOTHER COMMENT:
Count the frequency of all the characters in "Ballon," namely "B," "A," "L"...... in the string. Now notice that the frequency of a letter will dictate how many words can be formed from it. For example, if "L" occurs x times, we can use it to create floor(x/2) instances of "Ballon", if "B" occurs x times, we can use it to create x instances of "Ballon".
Now combining these observations, your answer would be the minimum instances of the word "Ballon" that can be formed using the character counts.

*/