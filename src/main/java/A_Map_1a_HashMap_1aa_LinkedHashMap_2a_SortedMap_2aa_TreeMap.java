import com.sun.jdi.Value;

import java.security.Key;
import java.util.*;


// hashMap keeps unordered, unsorted keys and values
// linkedHashMap keeps ORDERED keys. iteration will provide fifo.
// treeMap keeps sorted keys,

public class A_Map_1a_HashMap_1aa_LinkedHashMap_2a_SortedMap_2aa_TreeMap {

    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    TreeMap<Key, Value> tm = new TreeMap<>();
    Integer arr[] = { 5, 6, 7, 8, 1, 2, 3, 4, 3 };


    public static void main(String[] args) {
        //callLinkedHashMapExample();
        Integer a[] = { 0,2,3,2,0,1,1 };
        sortIn3List(a);


    }

    private static void sortIn3List(Integer[] a) {
        HashMap<Integer, Integer> hm
                = new LinkedHashMap<Integer, Integer>();
        for (int i =0; i< a.length; i++){
            if (hm.isEmpty())
                hm.put(a[i], 1);
            else hm.put(a[i], hm.get(a[i])+1);
        }
    //    hm.forEach( h -> {
            System.out.println(hm.toString());

      //  });
    }

    private static void callLinkedHashMapExample() {

        // create an instance of LinkedHashMap
        LinkedHashMap<String, String> lhm
                = new LinkedHashMap<String, String>();

        // Add mappings using put method
        lhm.put("one", "practice.geeksforgeeks.org");
        lhm.put("two", "code.geeksforgeeks.org");
        lhm.put("four", "quiz.geeksforgeeks.org");

        // It prints the elements in same order
        // as they were inserted
        System.out.println(lhm);

        System.out.println("Getting value for key 'one': "
                + lhm.get("one"));

        System.out.println("Size of the map: "
                + lhm.size());

        System.out.println("Is map empty? "
                + lhm.isEmpty());

        System.out.println("Contains key 'two'? "
                + lhm.containsKey("two"));

        System.out.println(
                "Contains value 'practice.geeks"
                        + "forgeeks.org'? "
                        + lhm.containsValue("practice"
                        + ".geeksforgeeks.org"));

        System.out.println("delete element 'one': "
                + lhm.remove("one"));

        // print mappings to the console
        System.out.println("Mappings of LinkedHashMap : "
                + lhm);
    }


}
