package offer.offerUnder20.o18;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head==null) return head;
        ListNode p = new ListNode(-1);
        p.next= head;
        while(p.next!=null){
            if(p.next.val== val){
                if(p.next==head) head=head.next;
                p.next=p.next.next;
                break;
            }
            p=p.next;
        }
        return head;
    }
}
