package offer.offerUnder20.o13;

import java.util.LinkedList;
class pos{
    int x,y;
    pos(){};
    pos(int a ,int b ){
        this.x=a;this.y=b;
    }
}
public class Solution {

    public int movingCount(int m, int n, int k) {
        if(m==1&n==1) return 1;
        int num = 0;
        int[][] visited =new int[m][n];
//        bfs(m,n,k,0,0,num);
        LinkedList<pos> deque = new LinkedList<>();

        pos thisP = new pos(0, 0);
        deque.addLast(thisP);
        while(!deque.isEmpty() ){
            thisP= deque.pollFirst();
            if(check(m,n,k,thisP)) {
                if (visited[thisP.x][thisP.y] == 0) {
                    visited[thisP.x][thisP.y] = 1;
                    num++;
                    deque.addLast(new pos(thisP.x+1, thisP.y ));
                    deque.addLast(new pos(thisP.x-1, thisP.y ));
                    deque.addLast(new pos(thisP.x, thisP.y+1 ));
                    deque.addLast(new pos(thisP.x, thisP.y-1 ));
                }
            }
        }
        System.out.println(num);
        return num;
    }
    public boolean check(int m,int n,int k ,pos p){
        if(p.x>=0 && p.x <=m-1){
            if(p.y>=0 && p.y<=n-1){
                if(p.x/10+p.x%10+p.y/10+p.y%10<=k) {
                    return true;
                }
            }
        }
        return  false;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        a.movingCount(2,3,1);
    }
}