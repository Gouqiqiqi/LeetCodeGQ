package offer.offerUnder20.o17;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class Solution {
    StringBuilder res ;
    char[] num;
    public String printNumbers(int n) {
        res = new StringBuilder();
        num = new char[n];
        dfs(n, 0);
        return res.toString();
    }
    public void  dfs(int n,int index){
        if(index == n ){

            res.append(Integer.parseInt(num.toString()));
            return;
        }
        for(int i = 0 ; i<10; i++){
            num[index]= (char) ('0'+i);
            dfs(n,i+1);
        }

    }
}
