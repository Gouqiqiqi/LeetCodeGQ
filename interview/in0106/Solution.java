package interview.in0106;

import java.util.TreeSet;

public class Solution {
    public String compressString(String S) {
        StringBuffer sb= new StringBuffer();
        String res;
        int index =0;
        int subLen=0;//temp
        while(index<S.length()){
            char sub = S.charAt(index);
            while(index+subLen<S.length() && S.charAt(index+subLen)==sub) subLen++;
            sb.append(sub);
            sb.append(subLen);
            index+=subLen;subLen=0;
        }
        res= sb.toString();
        if(res.length()>S.length()) return S;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().compressString("aabcccccaaa"));
    }
}
