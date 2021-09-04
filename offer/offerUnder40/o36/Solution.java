package offer.offerUnder40.o36;

import java.util.LinkedList;

class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
public class Solution {
    private boolean flag = false;
    public Node treeToDoublyList(Node root) {
        //非递归的中序遍历
        LinkedList<Node> stack = new LinkedList<>();
        Node p=root,temp=null,head=null;
        while(p!=null || !stack.isEmpty()){
            if(p!=null){
                stack.addLast(p);
                p=p.left;
            }
            else{
                p=stack.pollLast();

                if(temp==null) head=p;
                else {
                    p.left=temp;
                    temp.right=p;
                }
                temp=p;
                p=p.right;
            }
        }
        p=head;
        while(p.right!=null){
            p=p.right;
        }
        p.right=head;
        head.left=p;
        return  head;
    }

    public static void main(String[] args) {
        Node root = new Node(4,
                new Node(2,
                        new Node(1),
                        new Node(3)),
                new Node(5));
        Node a =new Solution().treeToDoublyList(root);
    }

}
