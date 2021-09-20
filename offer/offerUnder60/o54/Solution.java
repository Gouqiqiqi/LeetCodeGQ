package offer.offerUnder60.o54;

import java.util.*;

/**
 * @author Hu Yilv
 * @date 2021年09月18日 17:18
 * 二叉搜索树第k大
 * 中序遍历的下标n-k位
 */
  class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    public int kthLargest(TreeNode root, int k) {
        if(root==null) return root.val;
        LinkedList<TreeNode> s = new LinkedList<>();
        LinkedList<TreeNode> inOrder = new LinkedList<>();
        TreeNode p = root;
        while(p!=null || !s.isEmpty()){
            if(p!=null){
                s.addLast(p);
                p=p.left;
            }
            else{
                p=s.pollLast();
                inOrder.add(p);
                p=p.right;
            }
        }
        for(int i = 0 ; i < k-1 ; i++){
            inOrder.pollLast();
        }
        p=inOrder.pollLast();
        if(p==null) return -1;
        return p.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,new TreeNode(3,
                new TreeNode(2,
                        new TreeNode(1),
                        null),
                new TreeNode(4)),
                new TreeNode(6));
        new Solution().kthLargest(root,1);
    }
}
