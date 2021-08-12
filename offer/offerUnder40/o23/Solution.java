package offer.offerUnder40.o23;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
    ListNode(int x,ListNode node) {
        val = x;
        next = node;
    }
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;
        ListNode p=new ListNode(-1);
        p.next=null;
        ListNode q = head.next;
        while(q!=null){
            head.next=p.next;
            p.next=head;
            head=head.next;
            q=q.next;
        }
        head.next=p.next;
        p.next=head;
        return p.next;
    }
    public ListNode reverseList2(ListNode head) {
        ListNode res = new ListNode(-1);
        res.next=null;
        while(head!=null){
            ListNode p =  new ListNode(head.val);
            p.next=res.next;
            res.next=p;
            head=head.next;
        }
        return res.next;
    }
    public static void main(String[] args) {
        ListNode p4 = new ListNode(5, null);
        ListNode p3 = new ListNode(4, p4);
        ListNode p2 = new ListNode(3, p3);
        ListNode p1 = new ListNode(2, p2);
        ListNode p = new ListNode(1, p1);

        new Solution().reverseList(p);
    }
}
