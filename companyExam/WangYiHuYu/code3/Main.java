package companyExam.WangYiHuYu.code3;

import java.util.*;

/**
 * @author Hu Yilv
 * @date 2021年09月17日 21:15
 */
public class Main {
    static  int max =Integer.MAX_VALUE;
    static int N=-1;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            max= Integer.MAX_VALUE;
            N=sc.nextInt();
            int[] time = new int[N+1];
            Arrays.fill(time,Integer.MAX_VALUE);
            int m1=sc.nextInt(),m2=sc.nextInt();
            Map<Integer,List<Integer>> map1=new HashMap<>();
            Map<Integer,List<Integer>> map2=new HashMap<>();
            for (int j = 0; j < m1; j++) {
                int l1=sc.nextInt();
                int l2=sc.nextInt();
                map1.computeIfAbsent(l1,(k)->new ArrayList<>()).add(l2);
                map1.computeIfAbsent(l2,(k)->new ArrayList<>()).add(l1);
            }
            for (int j = 0; j < m2; j++) {
                int l1=sc.nextInt();
                int l2=sc.nextInt();
                map2.computeIfAbsent(l1,(k)->new ArrayList<>()).add(l2);
                map2.computeIfAbsent(l2,(k)->new ArrayList<>()).add(l1);
            }
        }
    }
    public  static void fun(int ind, boolean[] v, int p, int t, Map map1, Map map2, int[] time){
        if(ind == N && t < max){
            max= t;
            return;
        }
        if(t<time[ind]) time[ind]=t;
        if(t>=max || v[ind] || time[ind]<t) return;
        v[ind]=true;
        List<Integer> l2 = (List<Integer>) map2.get(ind);
        List<Integer> l1 = (List<Integer>) map1.get(ind);
        if(l2!=null){
            for (int i = 0; i < l2.size(); i++) {
                fun(l2.get(i),v,1, t+p,map1,map2,time);
            }
        }
        if(l1!=null){
            for (int i = 0; i < l1.size(); i++) {
                fun(l1.get(i),v,0 ,t+p,map1,map2,time);
            }
        }
        v[ind]=false;
    }
}
