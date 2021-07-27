package offer.o10;

class Solution {
    int[] f= new int[100+1];
    public int fib(int n) {
        if(n<0) return -1;

        if(n==0){f[0] = 0;return f[0];};
        if(n==1){f[1] = 1;return f[1];};
        if(f[n-1]!=0 && f[n-2] != 0) {
            f[n]=(f[n-1]+f[n-2])%1000000007;
            return f[n];
        }
        f[n] =  (fib(n-1)+fib(n-2))%1000000007;
        return f[n];
    }
}