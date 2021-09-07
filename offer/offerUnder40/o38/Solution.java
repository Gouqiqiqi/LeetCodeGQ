package offer.offerUnder40.o38;

import java.util.*;

public class Solution {

    int[] vis ;
    Set<String> resSet = new HashSet<>();
    public String[] permutation(String s) {
        StringBuilder sb = new StringBuilder();

        vis=new int[s.length()];
        char[] chars=s.toCharArray();
        createOne(chars,s.length(),sb);
        Iterator<String> it = resSet.iterator();
        StringBuilder sb2 = new StringBuilder();
        while (it.hasNext()){
            sb2.append(it.next()+",");
        }
        return sb2.toString().split(",");

    }
    public void createOne(char[] chars,int len, StringBuilder res){
        if(res.length()==len){
            resSet.add(res.toString());

            return;
        }
        for (int i = 0; i <chars.length ; i++) {
            if(vis[i]!=1){
                res.append(chars[i]);
                vis[i]=1;
                createOne(chars,len,res);
                vis[i]=0;
                res.deleteCharAt(res.length()-1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        new Solution().permutation("abc");
    }
}
