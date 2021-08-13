package offer.offerUnder40.o29;

import java.util.LinkedList;

public class Solution {
    LinkedList<Integer> list ;
    public int[] spiralOrder(int[][] matrix) {
        if(matrix==null || matrix.length==0) return new int[0];
        list = new LinkedList<>();
        waiquan(matrix,0,matrix[0].length-1,0, matrix.length-1);
        int[] res = list.stream().mapToInt(x->Integer.valueOf(x)).toArray();
        return  res;
    }
    public  void  waiquan(int[][] m,int rs,int re  ,int cs,int ce ){
        int x,y;
        for(x= rs ; x<=re ;x++){
            list.add(m[cs][x]);
        }
        cs+=1;
        if(cs>ce) return;
        for(y=cs ; y <=ce ; y++){
            list.add(m[y][re]);
        }
        re-=1;
        if(re<rs) return;
        for (x = re; x >= rs; x--) {
            list.add(m[ce][x]);
        }

        ce-=1;
        if(ce<cs) return;
        for (y = ce; y >= cs; y--) {
            list.add(m[y][rs]);
        }

        rs+=1;
        if(rs>re) return;
        waiquan(m,rs,re,cs,ce);
    }

    public static void main(String[] args) {
        new Solution().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
    }
}
