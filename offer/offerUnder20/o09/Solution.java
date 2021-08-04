package offer.offerUnder20.o09;

import java.util.ArrayDeque;

class CQueue {
    ArrayDeque<Integer> stack1;
    ArrayDeque<Integer> stack2;
    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while(!stack2.isEmpty()){
            stack1.push((stack2.pop()));
        }
    }

    public int deleteHead() {
        if(stack1.isEmpty()) return -1;
        else return stack1.pop();
    }
}
public class Solution {

}
