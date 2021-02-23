import java.util.PriorityQueue;

public class Stack {

    private int arr[];
    private int size;
    private int index = 0;

    public Stack(int size) {
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

    public void printSort(){
    PriorityQueue<Integer> p = new PriorityQueue<Integer>();

    for (int i = 0; i<size() ; i++){
        p.add(this.arr[i]);
        System.out.println(p.toString());
    }
        System.out.println(p.toString());
    while (true){
        Integer i = p.poll();
        System.out.println(i);

        if (i == null) break;
    }

    }
}