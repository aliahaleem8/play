import java.util.ArrayDeque;
//    -4    2    -5    1    -1    6
//assume no duplicates? unsorted

// if length < window (return -1?)
// compare first windowSize number of elements; record max
// now for remaining elements for each 1 element remove previous if it was max
//
public class E_MaxSlidingWindow {

    public static ArrayDeque<Integer> findMaxSlidingWindow(int[] arr, int windowSize) {
        ArrayDeque<Integer> result = new ArrayDeque<>();
        if (arr.length < windowSize){
            return null;
        }
        SlidingWindow w = new SlidingWindow();
        w.initizlieWindow(arr,windowSize); //w:[ 2    -4    -5 ], m: 2:    1    -1    6
        result.add(w.getMax(0)); //m: 2

        for (int i = windowSize; i<arr.length; i++){
            result.add(w.addNum(arr[i]));
        }
        return result;
    }

    public void main(String[] args) {
     System.out.println(this.findMaxSlidingWindow(new int[]{1, 3, 4, 5, 6}, 3).stream().toString());
    }
}
class SlidingWindow{
    int[] arr;
    int max;
    int lastIndex;
    int windowSize;

    public int addNum(int n){
    //return new max with each entered value and remove older from list
        if (arr[this.lastIndex] != this.max){
            this.lastIndex++;
            if (n > this.max){
                this.max = n;
            }
            return this.max;
        }
        else { return getMax( this.lastIndex+1);
            // the number to be removed was max; determine new max from rest elements again
        }


    }
    public void initizlieWindow(int[] arr, int windowSize){
     //return first max

        this.arr= arr;
        this.windowSize = windowSize;
    }

    public int getMax(int n){

        this.max = arr[n];
        for (int i = n+1; i< n+windowSize ; i++){
            if (arr[i]>this.max){
                this.max=arr[i];
            }
        }
        this.lastIndex = n;
        return this.max;
    }

}