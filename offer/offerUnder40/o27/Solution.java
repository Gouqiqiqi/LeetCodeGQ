package offer.offerUnder40.o27;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null ) return root;


        TreeNode p =mirrorTree(root.right);
        root.right=mirrorTree(root.left );
        root.left=p;
        return root;
    }
}
