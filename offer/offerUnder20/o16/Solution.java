package offer.offerUnder20.o16;

public class Solution {
    public double myPow(double x, int n) {
        if( x == 0 ){
            if(n<0) return -1;
        }
        if( n == 0 ) return 1 ;
        if(n < 0 ) x= 1/x;
        double res = 1;

        for(int i = 0 ; i < Math.abs(n) ;i++){
            res=res*x;
        }
        return res;
    }
}
