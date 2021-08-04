package offer.offerUnder20.o10_2;

class Solution {
    public int numWays(int n) {
        int[] res = new int[n+1];
        if(n==0) return 1;
        if(n==1) return 1;
        res[0]=1;res[1]=1;
        for(int i = 2 ; i < n+1 ; i++){
            res[i]=(res[i-1]+res[i-2])%1000000007;
        }
        return res[n];
    }

    public static void main(String[] args) {
        new Solution().numWays(46);
    }
}