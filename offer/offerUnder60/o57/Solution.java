package offer.offerUnder60.o57;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Hu Yilv
 * @date 2021年09月19日 17:29
 */
class Solution {
    public int[][] findContinuousSequence(int target) {
        int r=1,l=1;
        int sum = 0 ;
        List<Integer> List=new LinkedList<>();
        while(l<target){
            if(sum==target){
                List.add(l);List.add(r-1);
            }
            if(sum<target){
                sum+=r;
                r++;
            }else{
                sum-=l;
                l++;
            }
        }
        int[][] res =new int[List.size()/2][];
        for(int i = 0 ; i < List.size()/2 ; i++){
            int a = List.get(2*i),b=List.get(2*i+1);
            int[] tres = new int[b-a+1];
            for(int j = 0 ; j< tres.length ; j++){
                tres[j] = a+j;
            }
            res[i]=tres;
        }
        return res;
    }
}