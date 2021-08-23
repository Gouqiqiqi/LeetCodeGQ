package offer.offerUnder40.o32;

import java.util.Arrays;
import java.util.LinkedList;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
public class Solution {
    public int[] levelOrder(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<>();
        LinkedList<Integer> res = new LinkedList<>();
        que.addLast(root);
        TreeNode p ;
        while (!que.isEmpty()){
            p = que.pollFirst();
            if(p!=null) {
                res.add(p.val);

                que.addLast(p.left);
                que.addLast(p.right);
            }
        }
        return res.stream().mapToInt(Integer::valueOf).toArray();
    }
    public static void main(String[] args) {

    }
}
