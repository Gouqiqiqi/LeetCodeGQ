package offer.offerUnder20.o19;

public class Solution {
    public static  boolean isMatch(String s, String p) {
        int sI=0;
        int pI=0;
        char c ;
        for(;sI<s.length() && pI<p.length();){

            if(p.charAt(pI)!='*'){
                if(p.charAt(pI)=='.') {
                    sI++;
//                    pI++;
                }
                else if(s.charAt(sI)== p.charAt(pI)) {
                    sI++;
//                    pI++;
                }
            }
            if(p.charAt(pI)=='*'){
                c=p.charAt(pI-1);
                if(c=='.'){
                    if(pI==p.length()-1)
                        return true;
                    else {
                        pI+=1;
                        while(s.charAt(sI)!=p.charAt(pI)){
                            sI+=1;
                            if(sI==s.length()) return  false;
                        }
                        continue;
                    }
                }
                if(pI!=p.length()-1){
                    if(c==p.charAt(pI+1)){
                        while (s.charAt(sI)==c && sI<s.length()-1){
                            sI+=1;
                        }
                        pI+=1;
                        continue;
                    }
                    else {//a*c
                        while (s.charAt(sI)==c){
                            sI++;
                            if(sI==s.length()) break;
                        }
                        pI+=1;
                        continue;
                    }

                }
                while(s.charAt(sI)==c ){
                    sI++;
                    if(sI==s.length()) break;
                }

            }
            pI++;
        }
        if(sI==s.length() && pI==p.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa",
                "ab*a*c*a"));
    }
}

