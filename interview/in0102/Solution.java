package interview.in0102;

class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        //检查长度
        int len1=s1.length(),len2=s2.length();
        if(len1!=len2) return false;
        //检查字符是否都相同
        for(int i = 0; i<s1.length(); i++){
            if(s2.lastIndexOf(s1.charAt(i))==-1) return false;
            if(s1.lastIndexOf(s2.charAt(i))==-1) return false;
        }
        //检查字符重复次数
        int[] timeCount = new int[s1.length()];

        for(int i = 0; i<s1.length(); i++){
            timeCount[s1.charAt(i)-'a']+=1;
            timeCount[s2.charAt(i)-'a']-=1;
        }
        for(int i = 0;i<timeCount.length;i++){
            if(timeCount[i]!=0) return  false;
        }
        return  true;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        boolean b =a.CheckPermutation("abc","bca");
        System.out.println(b);
    }
}