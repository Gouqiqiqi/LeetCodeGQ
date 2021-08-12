package offer.offerUnder20.o20;

import java.util.Locale;

public class Solution {
    public boolean isNumber(String s) {
        String[] split = s.split(" ");
        if(split.length>3) return false;
        if(split.length==1) s= split[0];
        if(split.length==2){
            if(split[0].length()==0){
                s=split[1];
            }else{
                s=split[0];
            }
        }
        if(split.length==3) {
            if(split[0].length()!=0 || split[2].length()!=0) return false;
            s= split[1];
        }

        split=s.toLowerCase().split("e");
        if(split.length!=1 && split.length!=2) return false;
        if(split.length==1) {//no 'e'
            if(s.charAt(0)=='+' || s.charAt(0)=='-') s =s.substring(1);
            return checkIfpNum(s) || checkIfint(s);
        }
        else if(split.length==2) {
            if(split[0]==""||split[1]=="") return false;
            if(split[0].charAt(0)=='+' || split[0].charAt(0)=='-') split[0] =split[0].substring(1);
            if(split[1].charAt(0)=='+' || split[1].charAt(0)=='-') split[1] =split[1].substring(1);
            return (checkIfpNum(split[0]) || checkIfint(split[0]))&& checkIfint(split[1]);
        }
        return false;
    }

    private boolean checkIfint(String s) {//check if all num
        if(s.length()==0) return false;
        int i;
        for(i = 0; i<s.length();i++){
            if(s.charAt(i)-'0'<0 || s.charAt(i)-'9'>0){
                return  false;
            }
        }
        return true;
    }


    private boolean checkIfpNum(String s) {
        if (s.length() == 0) return false;
        int i = 0, count = 0;
        while (s.charAt(i) - '0' >= 0 && s.charAt(i) - '9' <= 0) {
            i++;
            if (i == s.length()) break;
        }//找第一个符号
        if (i == s.length()) return false;
        count = i;
        if (s.charAt(i) != '.') return false;
        if(i==s.length()-1){
            if(count>0) return true;
            else return false;
        }else {
            i++;
            while (s.charAt(i) - '0' >= 0 && s.charAt(i) - '9' <= 0) {
                i++;
                if (i == s.length()) break;
            }
            if (i == s.length()) return true;

        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().isNumber("9 4");
    }
}
