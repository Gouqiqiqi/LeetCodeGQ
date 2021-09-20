package offer.offerUnder60.o55;

/**
 * @author Hu Yilv
 * @date 2021年09月18日 18:27
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
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int h1=0,h2=0;
        if(root.left!=null) h1 = maxDepth(root.left);
        if(root.right!=null) h2 = maxDepth(root.right);
        return h1>h2?h1+1:h2+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        boolean f1= isBalanced(root.left);

        return Math.abs(getHei(root.left)-getHei(root.right))<=1;
    }

    private int getHei(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        int h1=0,h2=0;
        if(root.left!=null) h1 = getHei(root.left);
        if(root.right!=null) h2 = getHei(root.right);
        return h1>h2?h1+1:h2+1;
    }
}