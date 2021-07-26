package offer.o06;

import java.util.ArrayDeque;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public int[] reversePrint(ListNode head) {
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        while(head!=null){
            stack.push(head.val);
            head=head.next;
        }
        int[] a = new int[stack.size()];
        for(int i = 0 ;i <a.length ; i++){
            a[i]=stack.pop();
        }
        return  a ;
    }

}