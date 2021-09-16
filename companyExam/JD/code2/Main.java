package companyExam.JD.code2;

import java.util.*;
//引用关系 a依赖b a启动b启动 b停止a停止
//进行若干次启动和停止 返回最终运行的任务数

/**
 * 3 2  服务数 询问数
 * 1 2  第1（行数）个服务 依赖 1个 该服务是2
 * 1 3  第2个服务 依赖1个 该服务是3
 * 0    第3个服务 依赖0个
 * 1 1  启动 第1个服务
 * 0 2  结束 第2个服务
 */
public class Main {
    static HashMap<Integer,HashMap<Integer,LinkedList<Integer>>> map= new HashMap<>();
    static int ans =0;
    private static void solve(int type, int idx) {
        if(type == 0 ){
            --ans;

        }
        else    ++ans;

        LinkedList<Integer> integers = map.get(idx).get(type);
        for (int i = 0; i < integers.size(); i++) {
            solve(type,integers.get(i));
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int a, b;
        for(int i = 0 ; i < n ;i++){
            LinkedList<Integer> seti = new LinkedList<>();
            LinkedList<Integer> seti2 = new LinkedList<>();
            HashMap<Integer,LinkedList<Integer>> map1= new HashMap<>();
            map1.put(0,seti);map1.put(0,seti2);
            map.put(i,map1);
        }
        for(int i = 1; i<=n ; ++i){
            a=sc.nextInt();
            if(a!=0) {
                for(int j = 0 ; j < a; ++j){
                    b=sc.nextInt();
                    map.get(i).get(1).add(b);
                    map.get(b).get(0).add(i);
                }
            }
        }
        for (int i = 0; i < q; i++) {
            a=sc.nextInt();
            b=sc.nextInt();
            solve(a,b);
            System.out.println(ans);
        }
    }
}
