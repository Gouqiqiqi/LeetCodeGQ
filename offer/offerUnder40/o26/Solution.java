package offer.offerUnder40.o26;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }
public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null || B==null) return false;
        StringBuilder sa = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        dfs(A,sa);
        dfs(B,sb);
        for(int i = 0 ;i <sa.length();i++){
            if(sa.charAt(i)==sb.charAt(0)){
                int j ;
                for(j = 1; j <sb.length();j++){
                    if(sa.charAt(i+j) != sb.charAt(j))break;
                }
                if(j==sb.length()) return true;
            }
        }
        return false;
    }

    private void dfs(TreeNode t, StringBuilder s) {
        if(t.left!=null) dfs(t.left,s);
        if(t.left==null) s.append('!');
        s.append(t.val);
        if(t.right!=null) dfs(t.right,s);
        if(t.right==null) s.append('!');
    }
}
   /* public boolean isSubStructure(TreeNode A, TreeNode B) {
        //比较到两者任意一方尽头，A中有子树B不成立
        if(A==null || B==null)
            return false;

        //A本身包含B，或A左子树包含B，或A右子树包含B时，返回成立
        return contains(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean contains(TreeNode A, TreeNode B) {
        //B为空，A本身包含B成立
        if(B==null)
            return true;
        //否则,A为空，A本身包含B成立不成立
        if(A==null)
            return false;
        //当A、B结点值相等，且A左子树本身包含B左子树，且A右子树本身包含B右子树时，返回成立
        return A.val==B.val && contains(A.left, B.left) && contains(A.right, B.right);
    }*/