package leet.leet152;

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        if(nums.length==1 ) return nums[0];
        int len =nums.length;
        int dp[][] = new int[len+1][2];
        int max= Integer.MIN_VALUE;
        dp[0][0]=1;dp[0][1]=1;
        dp[1][0]=nums[0];dp[1][1]=nums[0];
        for(int i = 2; i<len+1 ; i++){
            dp[i][0] = Math.max(dp[i-1][0] *nums[i-1],nums[i-1]);
            dp[i][0]  = Math.max(dp[i][0],dp[i-1][1]*nums[i-1]);

            dp[i][1] = Math.min(dp[i-1][0] *nums[i-1],nums[i-1]);
            dp[i][1]  = Math.min(dp[i][1],dp[i-1][1]*nums[i-1]);
            max= max>dp[i][0]?max:dp[i][0];
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().maxProduct(new int[]{2,-1,1,1});
    }
}
