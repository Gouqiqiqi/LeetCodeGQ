package interview.in0105;

import java.util.TreeSet;

public class Solution {
    public boolean oneEditAway(String first, String second) {
        if(first.equals(second)) return  true;
        int b=first.length()-second.length();
        if(Math.abs(b)>1) return false;
        int i=0,j=0,count=0;
        for(;i<first.length() && j<second.length() ;){
            if(first.charAt(i)!=second.charAt(j)){
                if(b==1){i++;count+=1;continue;}
                if(b==-1){j++;count+=1;continue;}
                count+=1;
            }
            i++;j++;
        }
        if(count>1) return false;
        return true;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        System.out.println(a.oneEditAway("park",
                "spake"));
    }
}
