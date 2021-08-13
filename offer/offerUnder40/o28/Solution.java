package offer.offerUnder40.o28;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return mirrorTree(root.left, root.right);

    }
    public boolean mirrorTree(TreeNode A,TreeNode B) {
        if(A==null || B== null){
            if(A==null &&  B== null) return true;
            return false;
        }
        return A.val==B.val && mirrorTree(A.left,B.right) && mirrorTree(A.right,B.left);
    }
}

