// Java program to add the
// elements in the stack


import java.util.Stack;

public class AInitializeStacks {


    // Main Method
    public static void main(String[] args)
    {

        // Default initialization of Stack
        Stack stack1 = new Stack();
        stack1.push(4);

        // Initialization of Stack
        // using Generics
        Stack<String> stack2 = new Stack<String>();

        // pushing the elements

        stack1.push("All");
        stack1.push("Geeks");

        stack2.push("Geeks");
        stack2.push("For");
        stack2.push("Geeks");

        // Priniting the Stack Elements
        System.out.println(stack1);
        System.out.println(stack2);
        System.out.println(stack2.search("For"));
    }
}
