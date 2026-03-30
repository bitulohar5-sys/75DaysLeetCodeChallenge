import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Push element to the back
    public void push(int x) {
        inStack.push(x);
    }

    // Remove element from front
    public int pop() {
        peek(); // ensure outStack has elements
        return outStack.pop();
    }

    // Get front element
    public int peek() {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    // Check if empty
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}