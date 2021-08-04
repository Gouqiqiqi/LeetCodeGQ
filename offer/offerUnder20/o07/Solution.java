package offer.offerUnder20.o07;


import java.util.Arrays;

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        TreeNode nowRoot = new TreeNode(preorder[0]);
        int spilt = searchIn(preorder[0],inorder);
        if(spilt!=-1) {
            nowRoot.left = buildTree(Arrays.copyOfRange(preorder, 1, spilt+1), Arrays.copyOfRange(inorder, 0, spilt ));
            nowRoot.right = buildTree(Arrays.copyOfRange(preorder, 1 + spilt, preorder.length ), Arrays.copyOfRange(inorder, spilt + 1, inorder.length ));
        }
        return  nowRoot;
    }
    public int searchIn(int head, int[] in){
        for(int i = 0 ; i < in.length ; i++){
            if(in[i]==head) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        new Solution().buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
    }
}