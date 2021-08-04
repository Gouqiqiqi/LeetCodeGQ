package offer.offerUnder20.o14;

import java.util.HashMap;

public class Solution {
    public int cuttingRope(int n) {
        HashMap<Integer, Integer> integerIntegerHashMap = new HashMap<>();
        if(n==2) return 1;
        if(n==3) return  2;
        int[] res = new int[n+1];
        res[2]=2;res[3]=3;

        for(int i = 4; i<=n ;i++){
            int max=0;
            for( int lenK = 0; lenK<i-1 ;lenK++){
                max = Math.max(max,(res[i-lenK])*res[lenK]);
            }
            res[i]=max;
        }
        return  res[n];
    }
}
