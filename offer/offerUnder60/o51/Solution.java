package offer.offerUnder60.o51;

import java.util.Arrays;

public class Solution {

    public int reversePairs2(int[] nums) {
        int temp,res= 0 ,j;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[i];
            for ( j = i+1; j < nums.length; j++) {
                if(temp>nums[j]) res++;
            }
        }
        return res;
    }
    static int[] source,sorted;
    public int reversePairs(int[] nums) {
        int l = 0 , r=nums.length-1;
        source=nums;sorted=new int[nums.length];

        return merge(l,r);
    }

    private int merge(int start , int end) {
        if(end - start<1) return 0;
        int mid = (start+end)/2;
        int res = merge(start,mid)+ merge(mid+1,end);
        int i=start,j=mid+1,count = start ;
        while(i<=mid && j<=end){
            if(source[i]>source[j]){
                res+=(mid-i+1);
                sorted[count++]=source[j++];
            }
            else sorted[count++]=source[i++];
        }
        while (i<=mid) sorted[count++]=source[i++];
        while (j<=end) sorted[count++]=source[j++];
        for (int k = start; k <= end; k++) {
            source[k]=sorted[k];
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().reversePairs(new int[]{7,5,6,4});
    }
}
