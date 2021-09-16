package offer.offerUnder60.o48;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] dp = new int[s.length()+1];
        dp[0]=0;dp[1]=1;
        TreeSet<Character> set = new TreeSet<>();
        set.add(s.charAt(0));
        for (int i = 2; i < dp.length; i++) {
            dp[i]=dp[i-1]+1;
            if(set.contains(s.charAt(i-1))){
                boolean flag=false;
                set.clear();
                for(int j = i-dp[i];j<i-1;j++){
                    if(s.charAt(j)!=s.charAt(i-1)&& flag==false){ continue;}
                    else if(flag==false){ flag=true; continue;}
                    if(flag==true) set.add(s.charAt(j));
                }
            }
            set.add(s.charAt(i-1));
            dp[i]=set.size();
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public static void main(String[] args) {
        new Solution().lengthOfLongestSubstring("dvdf");
    }
}
