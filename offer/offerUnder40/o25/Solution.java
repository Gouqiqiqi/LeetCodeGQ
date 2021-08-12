package offer.offerUnder40.o25;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode res = new ListNode(-1);
        res.next= null;
        ListNode p= res,lp=l1.next,lq=l2.next;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                l1.next=p.next;
                p.next=l1;
                l1=lp;
                if(lp!=null)  lp=lp.next;
            }
            else{
                l2.next=p.next;
                p.next=l2;
                l2=lq;
                if(lq!=null)lq=lq.next;
            }
            p=p.next;
        }
        if(l1!=null) p.next=l1;
        if(l2!=null) p.next=l2;

        return res.next;
    }
}
