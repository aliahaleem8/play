import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MyStack {

    private int arr[];
    private int size;
    private int index = 0;

    public MyStack(int size) {
        this.size = size;
        arr = new int[size];
    }

    public void push(int element) {

        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }

        arr[index] = element;
        index++;
    }

    public int pop() throws Exception {

        if (isEmpty()) {
            throw new Exception();
        }
        return arr[--index];
    }

    public boolean isEmpty() {
        if (index == 0) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if (index == size) {
            return true;
        }
        return false;
    }

    public int size() {
        return index;
    }

    public void sortArr(){
        Instant start = Instant.now();
        Arrays.sort(this.arr);
        for (int i = 0; i < size(); i++)
        {
            System.out.println(this.arr[i]);
        }
        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nTime taken array Sort: "+ timeElapsed.toMillis() +" milliseconds");


    }
    public void printSort(){
        Instant start = Instant.now();
    PriorityQueue<Integer> p = new PriorityQueue<Integer>();

    for (int i = 0; i<size() ; i++){
        p.add(this.arr[i]);
    }
    while (true){
        Integer i = p.poll();
        System.out.print(i);
        if (i == null) break;
    }


        Instant end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("\nTime taken priority queue: "+ timeElapsed.toMillis() +" milliseconds");


    }
}