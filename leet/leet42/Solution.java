package leet.leet42;

public class Solution {
    public int trap(int[] height) {
        if(height.length==0) return 0;
        int[] waterLine = new int[height.length];
        int max = 0;//height >=0
        for(int i = 0 ; i < height.length ; i++){
            max = height[i]>max?height[i]:max;
            waterLine[i]=max;
        }
        max= 0 ;
        for(int i = height.length-1; i>=0;i--){
            max = height[i]>max?height[i]:max;
            waterLine[i]= waterLine[i]>max?max:waterLine[i];
        }
        int res = 0;
        for(int i = 0 ;i<height.length;i++){
            res+=waterLine[i]-height[i];
        }
        return res;
    }
}
