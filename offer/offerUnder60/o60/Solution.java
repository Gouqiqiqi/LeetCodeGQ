package offer.offerUnder60.o60;

/**
 * @author Hu Yilv
 * @date 2021年09月20日 15:35
 */
public class Solution {
    public double[] dicesProbability(int n) {
        // res between [n*1,n*6]
        double[] res = new double[5*n+1];
        double[] p = new double[]{1/6d,1/6d,1/6d,1/6d,1/6d,1/6d};
        if(n==1) return p;
        double[] t= dicesProbability(n-1);

        for (int i = 0; i < res.length-5; i++) {
            for (int j = 0; j < 6; j++) {
                res[i+j]+=t[i]*p[j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().dicesProbability(2);
    }
}
