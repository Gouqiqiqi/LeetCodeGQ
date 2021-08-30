package offer.offerUnder40.o33_2;

public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0) return true;
        boolean fe = vPostSub(postorder,0,postorder.length-1,postorder[postorder.length-1]);
        return fe;
    }

    private boolean vPostSub(int[] postorder,int start, int end,int r) {
        if(end <= start) return true;
        int i ;
        for( i = end-1; i>=start ; i--){
            if(postorder[i]<r) break;
        }
        int nextSplit=i>=start?i:start;
        for(;i>=start;i--)
            if(postorder[i]>r) return false;
        return vPostSub(postorder,start,nextSplit,postorder[nextSplit])&& vPostSub(postorder,nextSplit+1,end-1,postorder[end-1]);
    }

}
