package interview.in0103;

//[0,50w] 不建议遍历 ，spilt的复杂度不知道
// 如果有“空空空john空smith空空”，10的输入，要求输出：john%20smith  我的方法和其他人方法一样会报错！！
public class Solution {
    public String replaceSpaces(String S, int length) {
        char[] a= S.toCharArray();
        int bCount =0;
        StringBuilder sb=new StringBuilder();
        for(int i = 0; i < S.length()&& length>0 ;i++){
            if(a[i]==' ') sb.append("%20");
            else{
                sb.append(a[i]);
            }
            length-=1;
        }
        return new String(sb);
    }

    public static void main(String[] args) {

    }
}
