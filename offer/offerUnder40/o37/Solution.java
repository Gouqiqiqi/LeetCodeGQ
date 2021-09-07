package offer.offerUnder40.o37;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) {
          val = x;
      }

     TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Solution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return null;
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        sb.append("["+root.val);
        q.add(root.left);
        q.add(root.right);

        TreeNode p;
        while (!q.isEmpty()) {

            p=q.poll();
            if(p==null)
                sb.append(",null");
            else{
                sb.append(","+p.val);
                q.add(p.left);
                q.add(p.right);
            }
        }
        System.out.println(sb);
        sb.append("]");
        return sb.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode p,temp,root=null;
        if(data== null) return root;
        String[] sp = data.split(",");
        Queue<TreeNode> que = new LinkedList<>();
        for (int i = 0; i < sp.length; i++) {
            if(i==0)
                sp[i]=sp[i].split("\\[")[1];
            if(i==sp.length-1)
                sp[i]=sp[i].split("]")[0];
            if(!sp[i].equals("null")){
                p = new TreeNode(Integer.parseInt(sp[i]));
                if(i==0) root= p;
                if(!que.isEmpty()){
                    temp=que.peek();
                    if(que.size()%2==0){
                        temp.left=p;
                    }
                    else temp.right=p;
                    que.poll();
                }
                que.add(p);
                que.add(p);

            }
            else {
                que.poll();
            }
        }

        return root;
    }
    public static void main(String[] args) {

        Queue<TreeNode> q = new ArrayDeque<>();

        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3,
                        new TreeNode(4),
                        new TreeNode(5)));
        new Solution().deserialize(new Solution().serialize(root));
    }
}
