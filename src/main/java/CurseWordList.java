import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class CurseWordList
{
//    private CurseWordList()
//    {
//
//    }

//    public static final HashSet<String> CURSE_WORDS;
//
//    static{
//        HashSet<String> wordSet =new HashSet<>(Arrays.asList(
//
//                "ship", "miss", "duck", "punt", "rooster", "mother"
//        ));
//        wordSet.add("bits");
//
//        CURSE_WORDS = (HashSet<String>) Collections.unmodifiableSet(wordSet);
//    }

    public static final Set<String> CURSE_WORDS;

    static
    {
        Set<String> wordSet =new HashSet<String>();
        wordSet.add("ship");
        wordSet.add("miss");
        wordSet.add("duck");
        wordSet.add("punt");
        wordSet.add("rooster");
        wordSet.add("mother");
        wordSet.add("bits");

        CURSE_WORDS = Collections.unmodifiableSet(wordSet);
    }
}