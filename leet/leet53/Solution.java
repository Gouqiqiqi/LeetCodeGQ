package leet.leet53;

public class Solution {
//    public int maxSubArray(int[] nums) {
//        int left=0,right = 0;
//        int sum= 0 ;
//        int max = Integer.MIN_VALUE;
//        while(right<nums.length){
//            sum+=nums[right];
//            if(sum>max) max=sum;
//            if(sum<0) sum=0;
//        }
//        return max;
//    }
    public int maxSubArray(int[] nums) {
        Integer dp[]= new Integer[nums.length+1];
        dp[0]=0;
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i < nums.length+1 ; i++){
            dp[i]= Math.max(dp[i-1]+nums[i-1],nums[i-1]);
            max= max>dp[i]?max:dp[i];
        }
        return max;
    }

    public static void main(String[] args) {
        new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
