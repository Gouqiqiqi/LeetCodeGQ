package offer.offerUnder40.o34_2;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
public class Solution {
    List<List<Integer>> res =new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        DFS(root,0,target,new LinkedList<>());
        ReentrantLock reentrantLock = new ReentrantLock();
        return res;
    }

    private void DFS(TreeNode root,int sum, int target,List<Integer> path) {
        if(root == null || sum + root.val > target) return;
        sum+=root.val;path.add(root.val);
        if(root.left == null && root.right== null && sum == target){
            res.add(List.copyOf(path));path.remove(path.size()-1);
            return;
        }
        else {
            DFS(root.left,sum,target,path);
            DFS(root.right,sum,target,path);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        new Solution().pathSum(root,22);
    }
}
