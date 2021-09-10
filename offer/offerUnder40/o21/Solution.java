package offer.offerUnder40.o21;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public int[] exchange(int[] nums) {
//        int n =nums.length;
//        int t,l=0,r=n/2;
//        while(true){
//            for(;l<n/2;l++){
//                if(nums[l]%2==0) break;
//            }
//            for(;r<n;r++){
//                if(nums[r]%2==1) break;
//            }
//            if(l==n/2 && r==n) break;
//            t=nums[l];nums[l]=nums[r];nums[r]=t;
//        }
//        return nums;
        LinkedList<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]%2==0) res.addLast(nums[i]);
            else res.addFirst(nums[i]);
        }
        Integer[] a = res.toArray(new Integer[res.size()]);
        nums= Arrays.stream(a).mapToInt(Integer::valueOf).toArray();
        return nums;
    }
}
