/* two stack: one for push, one for pop, o(n) */
public class MyQueue {
    Stack<Integer> element = new Stack<>(); /* for push */
    Stack<Integer> temp = new Stack<>(); /* for pop */
    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        element.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        /* could write this part as a individual function */
        if(temp.empty()){
            while(!element.empty()){
                temp.push(element.pop());
            }
        }
        return temp.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(temp.empty()){
            while(!element.empty()){
                temp.push(element.pop());
            }
        }
        return temp.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return element.empty() && temp.empty();
    }
}
