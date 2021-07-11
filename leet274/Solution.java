package leet274;

import java.util.Arrays;
// FirstAC   剪枝策略：citations 的总和>h*h
// 好像没啥意义，h不能大于len(citations)..

public class Solution {
    public int hIndex(int[] citations) {
        int sum = Arrays.stream(citations).sum();
        int hmax = getMax(sum);
        int h =hmax;
        for(;h>0;h--){
            if(findTimes(citations,h)>=h) break;
        }
        return h;
    }

    private int findTimes(int[] a,int x) {
        int count=0;
        for(int i =0;i<a.length;i++){
            if(a[i]>=x) count+=1;
        }
        return  count;
    }

    public  int getMax(int summary){
        int i ;
        for(i = 1 ; i*i<=summary;i++);
        return  i-1;
    }
    public static void main(String[] args) {
        Solution a = new Solution();
        a.hIndex(new int[]{1});
    }
}
