package companyExam.WangYiHuYu.code2;

/**
 * @author Hu Yilv
 * @date 2021年09月17日 19:31
 */
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
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
            fun2(hei,m-1);
            int count=fun(hei,0,n);
            int i;
            for ( i = m-1; i < n ; i++) {
                if(hei[i]>hei[m-1]) break;
            }
            int r =i;
            for ( i = m-1; i >=0 ; i--) {
                if(hei[i]>hei[m-1]) break;
            }
            int mSee = fun(hei,i+1,r);
            if(mSee==0) mSee=1;
            System.out.println(count-mSee);
        }
    }

    private static int fun2(int[] hei, int i) {
        int count = 0 ;
        int max= hei[i];
        int j = i-1;
        while (j>=0){
            while (j>=0 && hei[j]<=max) j--;
        }
        return 0;
    }

    private static int fun(int[] hei, int l, int r) {
        if(l==r)  return 1;
        LinkedList<Integer> s = new LinkedList<>();
        s.addLast(hei[l]);
        int count = 0;
        boolean flag=false;
        for (int i = 1; i < r; i++) {
            if(hei[i]>s.peekLast()){//calculate result
                if(flag==false) {
                    s.clear(); s.add(hei[i]);
                }
                else {
                    s.clear();      count++;
                    s.add(hei[i]);  flag = false;
                }
            }else {
                s.addLast(hei[i]);
                flag=true;//xiapo
            }
        }
        if(s.size()!=1) count++;
        return count;
    }
}
//6
//5 1
//0 1 0 1 0
//7 1
//0 1 0 0 2 1 0
//7 2
//0 1 0 0 2 1 0
//8 1
//0 1 0 1 0 3 2 1
//8 2
//0 1 0 1 0 3 2 1
//8 6
//0 1 0 1 0 3 2 1
//8 2
//0 1 0 3 2 1 0 1 0
//2
//2
//1
//3
//1
//0
//2