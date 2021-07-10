package leet03;
//first AC 递归，基本思路；从最后一个重复位置开始重新计算
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=0,i=0;
        int maxlen=0;
        String son =new String();
        for(i = 0;i<s.length();i++){
            if(son.indexOf(s.charAt(i))==-1) {
                len += 1;
                son = son.concat(String.valueOf(s.charAt(i)));
            }
            else break;
        }
        maxlen = len;
        if (i<s.length()) {
            int index = s.substring(0, i).lastIndexOf(s.charAt(i));//已检查的部分珠串中最后一次出现位置
            len = lengthOfLongestSubstring(s.substring(index + 1));
        }
        maxlen=maxlen>len?maxlen:len;
        return maxlen;
    }

    public static void main(String[] args) {
        Solution a=new Solution();
        System.out.println(a.lengthOfLongestSubstring("dneghbctcbxdxezrzgbpfhzanffeccbgqfmzjqt"));
    }
}

/*  优秀题解： 基本思路相同
使用了滑动窗口 脱离了数组操作
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 记录字符上一次出现的位置
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
    }
}*/
/* 超时
class Solution {
    public int lengthOfLongestSubstring(String s) {//从最后一个重复位置开始重新计算
        int len=0;
        int maxlen=0;
        String son =new String();
        for(int i = 0;i<s.length();i++){
            if(son.indexOf(s.charAt(i))!=-1){
                len=s.substring(0,i).lastIndexOf(s.charAt(i));//已检查的部分珠串中最后一次出现位置
                len =lengthOfLongestSubstring(s.substring(len+1));
                maxlen=maxlen>len?maxlen:len;
                len=0;
            }
            len+=1;
            son=son.concat(String.valueOf(s.charAt(i)));
            maxlen = maxlen > len ? maxlen : len;
        }
        return maxlen;
    }
}*/
