package offer.offerUnder20.o15;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res=0;
        int temp=n;
//        for(int i = 0;i<32;i++){
//            if((temp &1)==1) res+=1;
//            temp=temp>>1;
//        }
        while(temp!=0){
            if((temp &1)==1) res+=1;
            temp=temp>>>1;
        }
        return res;
    }


}
