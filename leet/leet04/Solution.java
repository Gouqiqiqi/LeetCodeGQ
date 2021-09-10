package leet.leet04;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0 , j = 0 ;
        double res=0;
        int k= (nums1.length+nums2.length-1)/2;
        int count =0;
        while(i<nums1.length && j < nums2.length){
            if(i+j==k+1){
                break;
            }
            if(nums1[i]<nums2[j]){
                i++;res = nums1[i];
            }
            else {
                j++;res = nums2[j];
            }
        }
        while(i<nums1.length){
            if(i+j==k+1) break;
            i++;res = nums1[i];
        }
        while (j<nums2.length){
            if(i+j==k+1) break;
            j++;res = nums2[j];
        }
        if((nums1.length+nums2.length)%2==0)
        {
            double  next = nums1[i]>nums2[j]?nums2[j]:nums1[i];
            return (next+res)/2;


        }
        else return res;
    }

//    private double findMediHelper(int[] nums1) {
////
////    }
////
////    private double findMedi2(int[] nums2) {
////        if(nums2.length%2== 1) {
////            return nums2[(nums2.length - 1) / 2];
////        }
////        else {
////            return (nums2[nums2.length / 2]+nums2[nums2.length / 2-1])/2;
////        }
////    }

}
