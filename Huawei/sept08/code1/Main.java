package Huawei.sept08.code1;

import java.util.*;

public class Main {
    static class Node {
        int numOfchild;
        int value;
        int sum;
        int[] child= new int[2];
    }
    static Map<Integer,Node> map =new HashMap<>();
    static  int sum =0;
    public static void main(String[] args) {
        // please define the C input here. FOR EXAMPLE: int n; scanf("%d",&n);
        // please finish the FUNCTION body here.
        // please define the C output here. FOR EXAMPLE: printf("%d",a);
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        s.nextLine();
        boolean[] isroot = new boolean[n];
        Arrays.fill(isroot,true);

        for (int i = 0; i < n; i++) {
            int x = s.nextInt();
            Node t = new Node();
            t.value=x;
            t.numOfchild=0;
            sum+=x;
            t.sum=sum;
            map.put(i,t);
        }

        for (int i = 0; i < n - 1; i++) {
            int fa =s.nextInt();
            int child = s.nextInt();
            isroot[child]=false;
            map.get(fa).child[map.get(fa).numOfchild]=child;
            map.get(fa).numOfchild=map.get(fa).numOfchild+1;
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            if(isroot[i]){
                root=i;
                break;
            }
        }
        calculate(root);
        int max = 0,index = 0;
        for(int i : map.keySet()){
            int x= 2*map.get(i).sum-sum;
            if(max<Math.abs(x)){
                max=Math.abs(x);
                index = i;
            }
        }
        System.out.println(index);
    }

    private static int calculate(int root) {
        int ret = map.get(root).value;
        for(int i = 0 ; i < map.get(root).numOfchild;i++){
            int x = calculate(map.get(root).child[i]);
            ret+=x;
        }
        map.get(root).sum =ret;
        return ret;
    }
}