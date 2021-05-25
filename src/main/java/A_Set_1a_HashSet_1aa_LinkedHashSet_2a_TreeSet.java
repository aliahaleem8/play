// Java program to demonstrate the
// Sorted Set (interface) <----- NavigableSet(interface) <------ Treeset
import java.util.*;

public class A_Set_1a_HashSet_1aa_LinkedHashSet_2a_TreeSet {

    public static void main(String[] args)
    {
        callTreeSetMethods();
        callHashSetMethods();
        callLinkedHashSetMethods();

    }

    private static void callTreeSetMethods() {

//        SortedSet<String> ts = new TreeSet<String>();
        SortedSet<String> ts = new TreeSet<String>(Arrays.asList("India", "Australia", "South Africa"));
        int count = ts.size();
        ts.add("India");
        if (count == ts.size()) System.out.println("same size, duplicates not saved");

        System.out.println("sorted set: " + ts);
        ts.remove("Australia");   System.out.println("Set after removing Australia:" + ts);

        // Iterating over Tree set items
        System.out.println("2 Iterating over set if return or save values:");
        for(String s : ts){
            System.out.println(s);
        }

        // Iterating over Tree set items
        System.out.println("3 Iterating over set if return or save values:");
        ts.forEach(t->{
            if (t.contains("bal")) System.out.println("yah");

        });




        System.out.println("4 Iterating over set old way:");
        Iterator<String> i = ts.iterator();
        while (i.hasNext())
            System.out.println(i.next());


    }

    private static void callLinkedHashSetMethods() {
        LinkedHashSet<String> linkedset =
                new LinkedHashSet<String>();

        // Adding element to LinkedHashSet
        linkedset.add("A");
        linkedset.add("B");
        linkedset.add("C");
        linkedset.add("D");

        // This will not add new element as A already exists
        linkedset.add("A");
        linkedset.add("E");

        System.out.println("Size of LinkedHashSet = " +
                linkedset.size());
        System.out.println("Original LinkedHashSet:" + linkedset);
        System.out.println("Removing D from LinkedHashSet: " +
                linkedset.remove("D"));
        System.out.println("Trying to Remove Z which is not "+
                "present: " + linkedset.remove("Z"));
        System.out.println("Checking if A is present=" +
                linkedset.contains("A"));
        System.out.println("Updated LinkedHashSet: " + linkedset);
    }

    private static void callHashSetMethods() {
        //hashset

        Set<Integer> a = new HashSet<Integer>();
        a.addAll(Arrays.asList(new Integer[] { 1, 3, 2, 4, 8, 9, 0 }));
        Set<Integer> b = new HashSet<Integer>();
        b.addAll(Arrays.asList(new Integer[] { 1, 3, 7, 5, 4, 0, 7, 5 }));

        // To find union
        Set<Integer> union = new HashSet<Integer>(a);
        union.addAll(b);
        System.out.print("Union of the two Set");
        System.out.println(union);

        // To find intersection
        Set<Integer> intersection = new HashSet<Integer>(a);
        intersection.retainAll(b);
        System.out.print("Intersection of the two Set");
        System.out.println(intersection);

        // To find the symmetric difference
        Set<Integer> difference = new HashSet<Integer>(a);
        difference.removeAll(b);
        System.out.print("Difference of the two Set");
        System.out.println(difference);
    }


}
