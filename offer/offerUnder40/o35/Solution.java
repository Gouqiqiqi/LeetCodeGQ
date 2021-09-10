package offer.offerUnder40.o35;
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public Node copyRandomList(Node head) {
        Node p = head;
        while(p!=null){
            Node add =new Node(p.val);
            add.next=p.next;
            p.next=add;
            p=add.next;
        }
        p= head;
        Node q = head.next;
        Node res = head.next;
        while(p!=null){
            if(p.random!=null){
                q.random=p.random.next;
            }
            p=q.next;
            if(p==null) break;
            q=p.next;
        }
        p=head;q = head.next;
        while(p!=null){
            p.next=q.next;
            if(q.next==null) break;
            q.next=p.next.next;
            p=p.next;
            q=q.next;
        }
        return res;
    }
}
