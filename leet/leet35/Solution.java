package leet.leet35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target<nums[0] ) return 0;
        if( target > nums[nums.length-1]) return nums.length;
        int l = 0 ,r = nums.length-1;
        int mid ;
        while(l<=r){
            mid = l+((r-l)>>1);
            if(nums[mid]==target) return mid;
            else if(nums[mid]>target) r=mid-1;
            else l=mid+1;
        }
        return r+1;
    }

    public static void main(String[] args) {
        new Solution().searchInsert(new int[]{1,2,3,7},5);
    }
}
