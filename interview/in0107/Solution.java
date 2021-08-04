package interview.in0107;

import java.util.ArrayDeque;
import java.util.LinkedList;

public class Solution {
    public void rotate(int[][] matrix) {
        LinkedList<Integer> S = new LinkedList<Integer>();
        int[][] temp = new int[matrix.length][matrix.length];
        for(int i = 0; i < matrix.length ; i++){
            for(int j =0 ; j < matrix.length ; j++){
                temp[i][j]=matrix[i][j];
            }
        }
        for(int i =0 ;i<matrix.length ;i++){
            int j ;
            for( j = matrix[i].length-1; j>=0; j--){
                S.addLast(temp[j][i]);
            }
            for(j=0;j<matrix[i].length;j++){
                matrix[i][j]=S.getFirst();
                S.removeFirst();
            }
        }

    }

    public static void main(String[] args) {
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Solution().rotate(a);
        for(int i =0 ; i<a.length;i++){
            for (int j =0;j<a.length;j++){
                System.out.print(a[i][j]+",");
            }
            System.out.println();
        }
    }
}