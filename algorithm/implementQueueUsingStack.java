class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    // Push element x to the back of queue.
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        stack2.pop();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
    }

    // Get the front element.
    public int peek() {
         while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int temp = stack2.peek();
        while(!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return temp;
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return stack1.empty();
    }
}
