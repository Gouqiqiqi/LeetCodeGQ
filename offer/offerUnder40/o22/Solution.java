package offer.offerUnder40.o22;
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int count=0;
        ListNode p=head,kp=head;
        while(kp!=null){
            kp=kp.next;count++;
            if(count>=k+1)
                p=p.next;
        }
        return p;
    }
}
}
