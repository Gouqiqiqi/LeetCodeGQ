package offer.offerUnder40.o40;

import java.util.Arrays;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0||arr.length==0) return new int[0];
        return quickSearch(arr,0,arr.length-1,k);
    }

    private int[] quickSearch(int[] arr, int start, int end, int k) {
        int partLen = func(arr,start,end);
        if(partLen==k) return Arrays.copyOf(arr,partLen);
        return partLen>k?quickSearch(arr,start,partLen-1,k):quickSearch(arr,partLen+1,end,k);

    }

    public int func(int[] arr, int start , int end){
        int pat= arr[start];
        int t ;
        int left = start,right = end;
        while(left<right){
            while(left<right && arr[right]>=pat) right--;
            arr[left]=arr[right];
            while(left<right && arr[left]<=pat) left++;
            arr[right]=arr[left];
        }
        arr[left]=pat;
        return left;
    }

    public static void main(String[] args) {
        new Solution().getLeastNumbers(new int[]{0,1,2,1},2);
    }
}