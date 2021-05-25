import java.lang.reflect.Array;
import java.util.*;

public class Apple_Three_Lists {
    public static void main(String[] args) {
        int[] a = { 0, 3, 1, 2, 0, 1, 2};
        int t = 3;

        Map<Integer, Integer> hm = new HashMap<>();

//        List<int[]> rowList = new ArrayList<int[]>();
//
//        rowList.add(new int[] { 1, 2, 3 });
//        rowList.add(new int[] { 4, 5, 6 });
//        rowList.add(new int[] { 7, 8 });
//
//        for (int[] row : rowList) {
//            System.out.println("Row = " + Arrays.toString(row));
//        }

        boolean[] status = new boolean[3];
        for (int i = 0 ; i < status.length; i++){
            status[i]=false;
        }

        List<Integer> l1= new ArrayList<>();
        List<Integer> l2= new ArrayList<>();
        List<Integer> l3= new ArrayList<>();
        for (int i = 0 ; i < a.length; i++){
            if (a[i] == 0){
                l1.add(a[i]);
            }
            else if ((a[i]==t)&& (!status[0])){
                l1.add(a[i]);
                status[0]=true;
            }
            else if (hm.containsKey(a[i])){
                hm.put(a[i], hm.get(a[i])+1);
            }
            else hm.put(a[i], 1);
        }

        hm.forEach( (hk,hv) ->{
            if (hm.containsKey(t-hk)){

                if (!status[1]) {
                    l2.add(t - hk);
                    l2.add(hk);

                    hm.put(hk, hm.get(hk) - 1);
                    hm.put(t - hk, hm.get(t - hk) - 1);
                    status[1] = true;
                }
                else if (!status[2]) {
                    l3.add(t - hk);
                    l3.add(hk);

                    hm.put(hk, hm.get(hk) - 1);
                    hm.put(t - hk, hm.get(t - hk) - 1);
                    status[1] = true;
                }

            }

        });


        System.out.println(hm.toString());
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        System.out.println(l3.toString());
    }
}


//[0, 3, 1, 2, 0, 1, 2 ] put them in three lists with sum = 3 for each.