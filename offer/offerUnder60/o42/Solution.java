package offer.offerUnder60.o42;

class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null) return 0;
        int[] dp= new int[nums.length+1];
        dp[0]=0;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < dp.length ; i++){
            dp[i]= Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            max = max > dp[i] ? max:dp[i];
        }
        return max;
    }
}