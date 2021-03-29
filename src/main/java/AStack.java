import java.lang.module.FindException;
import java.util.Map;
import java.util.TreeMap;

public class AStack {
/*
PART A; implement push, pop, peek; push --> returns LIFO order

PART B; Use pop to retrieve elements and save to collections and print them in sorted order
without using collections sort method.

use native arrays. no more than 5 items will be pushed to stack.
cover every scenarios for each methods to pass unit tests.

example:
Push(1)
Push(2)
Stack[1,2,0,0,0]

Peek()->2
Stack[1,2,0,0,0]

Pop()->2
Stack[1,0,0,0,0]

Pop()->1
Stack[0,0,0,0,0]

 */
    public static void main(String[] args) throws Exception {
        AStack stack = new AStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(1);
        stack.push(2);
        stack.printString();
        stack.push(5);
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.printString();

    }
    int[] a ;
    int index ;
    public AStack(){
        a = new int[5];
        index = -1;
    }

    public int pop() throws Exception{
        if (index == -1){
            throw new IllegalAccessException("No elements in stack");
        }
        int temp = a[index];
        a[index]=0;
        index--;
        return temp;
    }

    public int peek() throws Exception{
        if (index == -1){
            throw new IllegalAccessException("No elements in stack");
        }
        return a[index];
    }

    public void push(int value) throws Exception{
        if (index == 4){
            throw new IllegalAccessException("Can not store more than 5 values in stack");
        }
        index++;
        a[index]=value;
    }

    public void printString() throws Exception {

        TreeMap<Integer,Integer> map = new TreeMap<>();
        while(index>=0){
            map.put(pop(), 1);
        }
        for (Map.Entry<Integer, Integer> e : map.entrySet())
            System.out.println(e.getKey());

    }



}
