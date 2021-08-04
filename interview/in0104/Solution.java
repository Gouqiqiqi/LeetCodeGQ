package interview.in0104;

import java.util.Set;
import java.util.TreeSet;

//类似0103 Set唯一性
public class Solution {
    public boolean canPermutePalindrome(String s) {
        char[] a = s.toCharArray();
        TreeSet<Character> set=new TreeSet<Character>();
        for(int i=0;i<s.length();i++){
            if(set.contains(a[i]))
                set.remove(a[i]);
            else set.add(a[i]);
        }
        return  set.size()<=1?true:false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.canPermutePalindrome("abc");
    }
}
