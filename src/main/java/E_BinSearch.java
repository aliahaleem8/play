public class E_BinSearch {
    public static void main(String[] args) {
        int[] a= {0,1,2,4,5,6,7,8,10};
        System.out.println(binSearch(a, 3));
        System.out.println(binSearch(a, 2));
        System.out.println(binSearch(a, 10));

    }
    static int binSearch(int[] a, int key) {
        //TODO: Write - Your - Code
        if (a.length>=0){
            if (a.length ==1) {
                if (a[1]==key) return 1;
                else return -1;
            }
            int l = 0;
            int r = a.length;
            return search(a, key, l, r);

        }
        return -1;
    }
    static int search(int[] a, int key, int l, int r) {
        if (l==r){
            if (a[l]!=key) return -1;
            else return l;
        }
        int n = (l+r)/2;
        System.out.println(" ( "+ l + ",  "+ r + ") a[" +  n + "] " + a[n] + "== "+  key );
        if (a[n]==key) return n;
        else if (a[n]>key)
        { //r = n-1;   check left side
            return search(a, key, l, n-1);
        }
        else {//l = n+1;   check right side
            return search(a, key, n+1, r);
        }

    }


}


class BinarySearch{

}