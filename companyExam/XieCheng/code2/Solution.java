package companyExam.XieCheng.code2;

import java.util.*;

/**
 * @author Hu Yilv
 * @date 2021年09月16日 19:57
 */
public class Solution {
    static class pos{
        int x ,y;

        public pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] height = new int[n+1][m+1];
        for (int i = 0; i < height.length; i++) {
            Arrays.fill(height[i],n*m*1000);
        }
        //key是高度 value是同高度的坐标
        HashMap<Integer, LinkedList<pos>> map = new HashMap<>();
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                height[i][j]=sc.nextInt();

                if(map.containsKey(height[i][j]))
                     map.get(height[i][j]).add(new pos(i,j));
                else{
                    LinkedList<pos> p = new LinkedList<>();
                    p.add(new pos(i,j));
                    map.put(height[i][j],p);
                }
            }
        }
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],n*m*1000);
        }
        dp[1][1]=0;
        for(int i =1 ;i<n+1 ; i++){
            for(int j = 1 ; j < m+1 ; j++){;
                LinkedList<pos> p = map.get(height[i][j]);
                for (int k = 0; k < p.size(); k++) {
                    dp[i][j]=Math.min(dp[i][j], dp[p.get(k).x][p.get(k).y]);
                }
                if(i==1 && j==1) continue;
                dp[i][j]=Math.min(dp[i][j],Math.min(
                        dp[i-1][j]+Math.abs(height[i][j]-height[i-1][j]),
                        dp[i][j-1]+Math.abs(height[i][j]-height[i][j-1]))
                );
            }
        }
        System.out.println( dp[n][m]);
    }

}
