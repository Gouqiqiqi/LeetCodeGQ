package leet.leet34;

public class solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null|| nums.length==0 ||target<nums[0] || target>nums[nums.length-1]) return  new int[]{-1,-1};
        int left = 0 , right = nums.length-1;
        int mid;
        while(left<=right){
            mid = left+((right-left)>>1);
            if(nums[mid]>=target) right=mid-1;
            else left=mid+1;
        }
        int[] res = new int[2];
        res[0]=left;
        left=0;right=nums.length-1;
        while(left<=right){
            mid = left+((right-left)>>1);
            if(nums[mid]<=target) left=mid+1;
            else right=mid-1;
        }
        res[1]=right;
        if(res[0]>res[1]) return new int[]{-1,-1};//target must exist in nums
        return  res;
    }
}
