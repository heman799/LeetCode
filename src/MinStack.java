import java.util.*;

public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        stack.push(number);
        //stack.empty() returns boolean
        if (minStack.empty()) {
            minStack.push(number);
        }
        else {
            if (minStack.peek() >= number) {
                minStack.push(number);
            }
        }
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int pop(int a) {
        if (stack.peek().equals(minStack.peek())) {
            minStack.pop();
        }
        return stack.pop();
    }

    /*
     * @param a: An integer
     * @return: An integer
     */
    public int min(int a) {
        return minStack.peek();
    }
}