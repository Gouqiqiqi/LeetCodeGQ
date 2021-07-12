package interview.in0101;


//暴力循环，减少重复n*n/2
class Solution {
    public boolean isUnique(String astr) {
        int[] a= new int[26];
        for(int i =0;i<astr.length();i++){
            a[astr.charAt(i)-'a']+=1;
            if(a[astr.charAt(i)-'a']>1) return false;
        }
        return true;
    }

    public static void  main(String[] args) {
        Solution demo = new Solution();
        demo.isUnique("leetcode");
    }
}