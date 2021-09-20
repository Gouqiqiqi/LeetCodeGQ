package offer.offerUnder75.o61;

import java.util.Arrays;

/**
 * @author Hu Yilv
 * @date 2021年09月20日 16:23
 */
public class Soluton {
    public boolean isStraight(int[] nums) {
        if(nums.length!=5) return false;
        Arrays.sort(nums);
        int i =0;
        while(nums[i]==0) i++;
        if(i==nums.length) return true;
        int count = i;
        for(;i<nums.length-1;i++){
            int dis=nums[i+1]-nums[i];
            if(dis==1) continue;
            if(dis==0) return false;
            else{
                count-=(nums[i+1]-nums[i]-1);
            }
            if(count<0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Soluton().isStraight(new int[]{0,0,2,2,5});
    }
}