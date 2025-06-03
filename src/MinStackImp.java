import Entity.Interval;

import java.util.PriorityQueue;
import java.util.Stack;

class MinStack {
//    PriorityQueue<Integer> minQueue ;
    Stack<Integer>minStack;
    Stack<Integer>stack;
    public MinStack() {
//        minQueue = new PriorityQueue<>();
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if(minStack.isEmpty()) {
            minStack.push(val);
            return;
        }

        int topVal = minStack.peek();
        if(topVal<val){
            minStack.push(topVal);
        }else{
            minStack.push(val);
        }
//        minQueue.add(val);
    }

    public void pop() {
       stack.pop();
//        minQueue.remove(poped);
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
public class MinStackImp {
}
