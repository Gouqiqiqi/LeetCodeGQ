package offer.offerUnder60.o49;

import java.util.HashSet;

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 6) return n;
        int[] dp = new int[n];
        for (int i = 0; i < 6; i++) {
            dp[i] = i + 1;
        }
        int p1=3,p2=2,p3=4;
        for(int i  = 6 ; i < dp.length ; i++){
            dp[i]=Math.min(dp[p1]*2,Math.min(dp[p2]*3,dp[p3]*5));
            if(dp[i]==dp[p1]*2) p1+=1;
            if(dp[i]==dp[p2]*3) p2+=1;
            if(dp[i]==dp[p3]*5) p3+=1;
        }

        return  dp[n-1];
    }

    public static void main(String[] args) {
        new Solution().nthUglyNumber(10);
    }
}