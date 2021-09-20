package offer.offerUnder60.o59_II;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Hu Yilv
 * @date 2021年09月20日 14:34
 */
public class Solution {
    class MaxQueue {
        Deque<Integer> que ;
        Deque<Integer> max ;
        public MaxQueue() {
            max=new ArrayDeque<>();
            que=new ArrayDeque<>();
        }

        public int max_value() {
            return max.peek();
        }

        public void push_back(int value) {
            que.addLast(value);
            while(!max.isEmpty() && max.peekLast()<value){
                max.pollLast();
            }
            max.addLast(value);
        }

        public int pop_front() {
            if(que.size()==0) return -1;
            int val = que.poll();
            if(val==max.peek()) max.poll();
            return val;
        }
    }
}
