package offer.offerUnder40.o33;

import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class myNode{
    TreeNode node;
    int deep;

    public myNode(TreeNode root, int i) {
        this.node=root;
        this.deep=i;
    }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<myNode> que = new LinkedList<>();
        List<List<Integer>> res = new LinkedList<>();
        List<Integer> resDeep = new LinkedList<>();
        que.addLast(new myNode(root,1));
        myNode p ;
        int height=1;
        while (!que.isEmpty()){
            p = que.pollFirst();

            if(p.node!=null) {
                if(height==p.deep) {
                    resDeep.add( p.node.val);
                }
                else {
                    res.add(resDeep);
                    resDeep = new LinkedList<>();
                    resDeep.add(p.node.val);
                    height=p.deep;
                }
                que.addLast(new myNode(p.node.left,p.deep+1));
                que.addLast(new myNode(p.node.right,p.deep+1));
            }
        }
        res.add(resDeep);
        return  res;
    }

}