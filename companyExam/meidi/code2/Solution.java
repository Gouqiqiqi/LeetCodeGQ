package companyExam.meidi.code2;

/**
 * @author Hu Yilv
 * @date 2021年09月17日 16:29
 * 约瑟夫环
 */
import java.util.*;
public class Solution {
    public int playNum (int n, int m) {
        if(n==1) return 1;
        // write code here
        int[] vis = new int[n];
        int point = 0;
        while(check(vis)){
            for (int i = 0; i < m; i++) {
                point=nextAva(vis,point);
                point=(point+1)%n;
            }
            point=(point-1+n)%n;
            vis[point]=1;
            point=(point+1)%n;
        }
        for (int i = 0; i < vis.length; i++) {
            if(vis[i]==0) return i+1;
        }
        return -1;
    }

    private int nextAva(int[] vis, int point) {
        while (vis[point]==1){
            point=(point+1)%vis.length;
            if(vis[point]==0) return point;
        }
        return point;
    }

    private boolean check(int[] vis) {
        int count= 0;
        for (int x : vis) {
            if(x==0) count++;
            if(count>1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().playNum(3,3));
    }
}
