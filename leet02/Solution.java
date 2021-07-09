package leet02;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res=new ListNode(0,null),p=res;
        int sum=0;//余数，尾数
        while(l1!=null||l2!=null||sum!=0) {
            if (l1 != null) {
                sum += l1.val;
                l1=l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2=l2.next;
            }
            p.next = new ListNode(sum % 10, null);
            p=p.next;
            sum = (int)sum / 10;
        }
        return  res.next;
    }
    public static void  main(String[] args){
        ListNode a=new ListNode(3,null);
        ListNode b=new ListNode(9,null);
        ListNode l1=new ListNode(9,b);
        ListNode c=new ListNode(9,null);
        ListNode d=new ListNode(9,c);
        ListNode d2=new ListNode(9,d);
        ListNode d3=new ListNode(9,d2);
        ListNode l2=new ListNode(9,d3);
        Solution demo =new Solution();
        a=demo.addTwoNumbers(l1,l2);
        do{
            System.out.println(a.val);a=a.next;
        }while(a!=null);
    }
}