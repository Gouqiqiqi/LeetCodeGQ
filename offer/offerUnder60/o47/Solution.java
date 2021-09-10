package offer.offerUnder60.o47;

class Solution {
    public int maxValue(int[][] grid) {
        if(grid.length==0 || grid[0].length==0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0]=0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[grid.length][grid[0].length];
    }
}
