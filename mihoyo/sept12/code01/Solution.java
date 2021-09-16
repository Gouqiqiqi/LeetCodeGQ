package mihoyo.sept12.code01;

import javax.xml.stream.StreamFilter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @param k int整型
     * @return int整型
     */
    public int findKthLargest (int[] nums, int k) {
        // write code here
//        Arrays.sort(nums);
//        return nums[nums.length-k];
        if(k>=nums.length || k < 0 || nums.length==0) return -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if(minHeap.size()<k) minHeap.add(nums[i]);
            else {
                if(nums[i]>minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }
    public String cutString (String original, int count) {
        // write code here
        //假设只有汉字和字符
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < original.length() && count>0; i++) {
            char ch = original.charAt(i);
            if (String.valueOf(ch).getBytes(StandardCharsets.UTF_16LE).length == 2) {
                if (count >= 2) {
                    sb.append(ch);
                    count -= 2;
                }else break;
            } else {
                sb.append(ch);
                count -= String.valueOf(ch).getBytes(StandardCharsets.UTF_16LE).length;
            }
            if(count<=0)break;
        }
        return sb.toString();
    }

    public String cutString2 (String original, int count) {
        // write code here
        //假设只有汉字和字符
        if(count>=original.length()*2) return original;
        int now = 0 ;
        StringBuilder sb = new StringBuilder();
        for(;now < original.length();now++){
            if(isEngChar(original.charAt(now))){
                if(count>0) {
                    sb.append(original.charAt(now));
                    count -= 1;
                }
            }
            else {
                if(count>=2) {
                    sb.append(original.charAt(now));
                    count -= 2;
                }else break;
            }
            if(count<=0) break;
        }
        return sb.toString();
    }
    public static boolean isEngChar(char c){
        if(c-'a'>=0 && 'z'-c>=0) return true;
        if(c-'A'>=0 && 'Z'-c>=0) return true;
        else return false;
    }
    public static boolean isChinese(char c){
        return  String.valueOf(c).matches("[\u4e00-\u9fa5]");
    }
    public static void main(String[] args) {
        char[] chars = "我ABC汉DEF".toCharArray();
        char ch = chars[0];
        new Solution().cutString2("我ABC汉DEF",6);

        System.out.println(String.valueOf(chars[0]).getBytes(StandardCharsets.UTF_16).length);

        System.out.println(String.valueOf(chars[1]).getBytes(StandardCharsets.UTF_16).length);
    }
}