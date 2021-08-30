package offer.offerUnder40.o34;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
//        LinkedList<TreeNode> que2 = new LinkedList<>();

        que.addLast(root);
        TreeNode p;
        int count =0;

        while(!que.isEmpty()){
            List<Integer> partRes = new LinkedList<>();
            for (int i = que.size(); i > 0; i--) {
                p= que.pollFirst();
                partRes.add(p.val);
                count++;
                if(p.left!=null) que.addLast(p.left);
                if(p.right!= null ) que.addLast(p.right);
            }
            if(count%2 == 0 ) {
                Collections.reverse(partRes);
            }
            res.add(partRes);

        }


        return res;
    }
}
