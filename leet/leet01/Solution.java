package leet01;


//暴力循环，减少重复n*n/2
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result=new int[2];
        for(int i =0;i<nums.length;i++){
            for(int j =nums.length-1;j>i;j--){
                if(i==j) continue;  //
                if(nums[i]+nums[j]==target){result[0]=i;result[1]=j;return result;}
            }
        }
        return result;
    }
    public static void  main(String[] args) {
        Solution demo = new Solution();
        int[] a =new int[]{1,2,3,4,5};
        demo.twoSum(a,4);
    }
}