package leet.leet275;
//firstAC same with leet274
public class Solution {

//    public int hIndex(int[] citations) {
//        //firstAC same with leet274
//        int h = 0, i = citations.length - 1;
//        while (i >= 0 && citations[i] > h) {
//            h++;
//            i--;
//        }
//        return h;
//    }
    public int hIndex(int[] citations) {
        //half search parctice
        int l=0,len=citations.length-1,r=len;
        int mid,res=0;
        while (l<=r) {
            mid= (l+r)/2;
            if(len-mid+1<=citations[mid])//half search break conditions
            {
                res= len-mid+1;
                r=mid-1;
            }
            else if(len-mid+1>citations[mid]){
                l=mid+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution a = new Solution();
        a.hIndex(new int[]{1,2,4,5,6});
    }
}
