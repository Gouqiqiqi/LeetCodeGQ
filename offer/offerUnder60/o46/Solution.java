package offer.offerUnder60.o46;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;

class Solution {
    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        if(chars.length==1) return 1;
        int[] dp = new int[chars.length+1];
        dp[0]=1;
        dp[1]=1;
        for(int i =2 ; i < chars.length+1; i++){
            dp[i]=dp[i-1];
            StringBuilder sb = new StringBuilder();
            sb.append(chars[i-2]).append(chars[i-1]);// 06不能翻译
            if(chars[i-2]!='0' &&Integer.parseInt(sb.toString())>=0 &&Integer.parseInt(sb.toString())<=25)
                dp[i]+=dp[i-2];
        }
        return  dp[chars.length];
    }

    public static void main(String[] args) {
        new Solution().translateNum(220);
    }
}