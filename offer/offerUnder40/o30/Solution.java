package offer.offerUnder40.o30;

import java.util.PriorityQueue;

class MinStack {
    int[] nums;
    int[] mins;
    int index;
    /** initialize your data structure here. */
    public MinStack() {
        nums = new int[20000];
        mins = new int[20000];
        index= 0;
    }

    public void push(int x) {
        if(++index>=nums.length)  return;
        nums[index]= x;
        if(index==0){ mins[index]=0; return;}
        if(x>nums[mins[index-1]]) mins[index]=mins[index-1];
        else mins[index]=index;
    }

    public void pop() {
        index-=1;
    }

    public int top() {

        return nums[index];
    }

    public int min() {

        return nums[mins[index]];
    }
}
public class Solution {
}
