package nowCode.NC78;


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class Solution {
    public ListNode ReverseList(ListNode head) {
        ListNode q,t;
        q=head.next;
        head.next=null;
        do{
            t=new ListNode(q.val);
            t.next=head.next;
            head.next=t;
            q=q.next;
        }while(q!=null);
        return head;
    }

}