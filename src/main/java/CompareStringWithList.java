import java.io.IOException;
import java.util.Set;
import java.util.SortedSet;

public class CompareStringWithList {

    public static void main(String[] args) throws IOException {
//            List<Integer> list=Arrays.asList(1, 2, 3);
//            System.out.println("NO".equalsIgnoreCase(FindNumInList.findNumber(list, 4)));
//            System.out.println("NO".equalsIgnoreCase(FindNumInList.findNumber(list, 0)));
//            System.out.println("YES".equalsIgnoreCase(FindNumInList.findNumber(list, 2)));

        Set<String> hset = CurseWordList.CURSE_WORDS;
        System.out.println(containsCurses(" alia is cool", hset));

        System.out.println(containsCurses(" alia rooster is cool", hset));


    }

    public static boolean containsCurses(String s, Set<String> curses){

     //   System.out.println(curses.toString());
//        boolean result = false;
//        curses.forEach( curse ->
//        {
//            if (s.toLowerCase().contains(curse))
//            {
//                System.out.println( true);
//            }
//
//        });

       // SortedSet<String> scur
        for(String curse: curses) {
           // System.out.println(curse);
            if (s.toLowerCase().contains(curse)){
                return true;
            }


        }
        //   System.out.println(false);

        return false;

    }



}
