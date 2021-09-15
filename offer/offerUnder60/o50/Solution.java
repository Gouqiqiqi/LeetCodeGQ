package offer.offerUnder60.o50;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public char firstUniqChar(String s) {
        if(s.length()==0) return ' ';
        int[] nums = new int[26];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i)-'a']+=1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(nums[s.charAt(i)-'a']==1) return s.charAt(i);
        }
        return ' ';
    }
}