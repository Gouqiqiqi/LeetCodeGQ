package offer.o04;

public class Solution {//递归超时,增加辅助数组
    int[][] visited;
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length==0) return false;//空数组处理
        if(target<matrix[0][0]) return false;
        if(target > matrix[matrix.length-1][matrix[0].length-1]) return false;
        this.visited=new int[matrix.length][matrix[0].length];
        //search in range
        boolean res = compAng(matrix, matrix.length-1, matrix[0].length-1,target,false,false);
        return  res;
    }
    public boolean compAng(int[][] matrix , int x,int y, int target,boolean a, boolean b){
        if(x<0 || y<0) return false;
        if(visited[x][y]!=0) return visToBool(visited[x][y]);
        System.out.println(matrix[x][y]);
        if(matrix[x][y]==target) return true;
        else{//剪枝
            if(x-1>=0) a =matrix[x-1][y]<target;
            if(y-1>=0) b= matrix[x][y-1]<target;
            if(a&&b) return false;
        }
        if(x!=0) {
            if (compAng(matrix, x - 1, y, target, false, false) == false) visited[x - 1][y] = -1;
            else visited[x - 1][y] = 1;
        }
        if(y!=0) {
            if (compAng(matrix, x, y - 1, target, false, false) == false) visited[x][y - 1] = -1;
            else visited[x][y - 1] = 1;
        }
        return (x==0?false:visToBool(visited[x-1][y])) || (y==0?false:visToBool(visited[x][y-1]));

    }
    public boolean visToBool(int x){
        switch (x){
            case 1:
                return true;
            default:
                return false;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(new Solution().findNumberIn2DArray(matrix,5));
    }
}
