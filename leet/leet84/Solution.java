package leet.leet84;

import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public static  int largestRectangleArea(int[] heights) {
        int maxRes=0;
        int len = heights.length;
        int[][] dp = new int[len][2];
        dp[0][0]=0;
        dp[len-1][1] =len-1;
        int j,temp;
        for(int i = 1 ; i < len ; i++){
            if(heights[i]>heights[i-1]) dp[i][0]=i;
            else if(heights[i]==heights[i-1]){ dp[i][0]=dp[i-1][0];}
            else{
                temp=i-1;
                while(true){
                    if(dp[temp][0]-1<0){dp[i][0]=dp[0][0];break;}
                    j=dp[temp][0]-1;
                    if(heights[j]<heights[i]) {dp[i][0]=j+1;break;}
                    temp=j;
                }
            }
            //deal with len-1-i
            if(heights[len-1-i]==heights[len-i])  dp[len-1-i][1]=dp[len-i][1];
            else if(heights[len-1-i]>heights[len-i]) dp[len-i-1][1]=len-i-1;
            else{
                temp = len-i;
                while(true){
                    if(dp[temp][1]+1>len-1){dp[len-1-i][1]=dp[len-1][1];break;}
                    j=dp[temp][1]+1;
                    if(heights[j]<heights[len-1-i]) {dp[len-1-i][1]=j-1;break;}
                    temp=j;
                }
            }

        }
        for(int i = 0 ; i < len ; i++){
            maxRes= maxRes>(heights[i]*(dp[i][1]-dp[i][0]+1))?maxRes:(heights[i]*(dp[i][1]-dp[i][0]+1));
        }
        return  maxRes;
    }

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        largestRectangleArea(height);
    }
}
