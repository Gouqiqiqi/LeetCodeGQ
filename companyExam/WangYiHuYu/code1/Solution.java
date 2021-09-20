package companyExam.WangYiHuYu.code1;
import  java.util.*;
/**
 * @author Hu Yilv
 * @date 2021年09月17日 21:43
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int round = 0; round < T; round++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] hei = new int[n];
            for (int i = 0; i < n; i++) {
                hei[i] = sc.nextInt();
            }
            int count=fun(hei,0,n);
            int i;
            for ( i = m-1; i < n ; i++) {
                if(hei[i]>hei[m-1]) break;
            }
            int r =i;
            for ( i = m-1; i >0 ; i--) {
                if(hei[i]>hei[m-1]) break;
            }
            int mSee = fun(hei,i,r);
            System.out.println(count-mSee);
        }
    }
    private static int fun(int[] hei, int l, int r) {
        LinkedList<Integer> s = new LinkedList<>();
        s.addLast(hei[l]);
        int count = 0;
        for (int i = 1; i < r; i++) {
            if(hei[i]!=s.peekLast() && hei[i]>=s.peekFirst()){//calculate result
                while (!s.isEmpty() && hei[i]>s.peekLast()){
                    s.pollLast();//clear?pollLast?

                }count++;
                s.add(hei[i]);
            }else {
                s.addLast(hei[i]);
            }
        }
        if(s.size()!=1) count++;
        return count;
    }
}
