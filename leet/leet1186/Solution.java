package leet.leet1186;

import java.util.Arrays;

class Solution {
    public int maximumSum2(int[] arr) {
        int[] dp = new int[arr.length+1];
        int[] dp2= new int[dp.length];
        Arrays.fill(dp,Integer.MIN_VALUE);
        Arrays.fill(dp2,Integer.MIN_VALUE);
        dp[1]=arr[0];
        dp2[0]=0;
        dp2[1]=0;
        int res = dp[1];
        for(int i =2 ; i < dp.length ; i++){
            dp[i]=Math.max(arr[i-1],dp[i-1]+arr[i-1]);
            dp2[i]=Math.max(dp2[i-1]+arr[i-1],dp[i-1]);//已经删过了，继续求最大连续；没删过，删当前这个
            res=Math.max(dp[i],Math.max(dp2[i],res));
        }
        return res;
    }
    public int maximumSum(int[] arr) {
        int dp = arr[0];
        int dp2= Arrays.stream(arr).min().getAsInt();
        int res = dp;
        for(int i =1 ; i < arr.length ; i++){
            dp2 = Math.max(dp,dp2+arr[i]);
            dp = Math.max(arr[i],dp+arr[i]);
            res = Math.max(res,Math.max(dp,dp2));
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().maximumSum(new int[]{2,1,-2,-5,-2});
    }
}