package companyExam.wangyi.sept18.code1;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Hu Yilv
 * @date 2021年09月18日 19:07
 */

/**
public class Main {
    static class Pos{
        int x,y;
        public Pos() {
        }
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
//    static class c{
//        Pos p ;
//        int cost;
//
//        public c(Pos p, int cost) {
//            this.p = p;
//            this.cost = cost;
//        }
//    }
    static int times = 0,a,b,minCost = Integer.MAX_VALUE;
    static LinkedList<Pos> tp;
    static LinkedList<Pos> change = new LinkedList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
         a = sc.nextInt();
         b = sc.nextInt();
        tp = new LinkedList<>();
        char[][] m = new char[n][n];
        int[][] vis = new int[n][n];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            m[i]=sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if(m[i][j]=='*') tp.add(new Pos(i,j));
            }
        }
        if(deepSearch(m,vis,0,0,n-1,n-1,0)) System.out.println(0);
        int cost=0;
        if(tp.size()!=0){
            if(deepSearch(m,vis,0,0,tp.get(0).x,tp.get(0).y,0) && deepSearch(m,vis,tp.get(1).x,tp.get(1).y,n-1,n-1,0))
                cost = b;
            else if(deepSearch(m,vis,0,0,tp.get(1).x,tp.get(1).y,0) && deepSearch(m,vis,tp.get(0).x,tp.get(0).y,n-1,n-1,0))
                cost= b;
        }
        if(cost!=0 && cost<=a) System.out.println(b);
        deepSearch(m,vis,0,0,n-1,n-1,cost);

        System.out.println(cost-times*a>0?cost-times*a:cost);
//        deepSearch(m,vis,0,0,n-1,n-1,0);
//        System.out.println(minCost);
    }

    private static boolean deepSearch(char[][] m,int[][] vis, int x, int y, int s, int d,int cost) {
        if(cost<0) return false;
        if(x<0 || x>=m.length || y<0 || y>=m.length || vis[x][y]==1) return false;
        if(x==s&&y==d) return true;
        vis[x][y]=1;
        if(m[x][y]=='#'){
            if( cost >0) {
                m[x][y]='-';
                times++;
                boolean f = deepSearch(m,vis,x,y,s,d,cost-a);
                if(f){
                    vis[x][y]=0;return true;
                }
                times--;
                m[x][y]='#';
            }
            else  return false;
        }
        if(deepSearch(m,vis,x-1,y,s,d,cost))  { vis[x][y]=0;return true;}
        if(deepSearch(m,vis,x+1,y,s,d,cost))  { vis[x][y]=0;return true;}
        if(deepSearch(m,vis,x,y-1,s,d,cost))  { vis[x][y]=0;return true;}
        if(deepSearch(m,vis,x,y+1,s,d,cost))  { vis[x][y]=0;return true;}
        return false;

//        LinkedList<c> que = new LinkedList<>();
//        que.addLast(new c(new Pos(x,y),0));
//        vis[x][y]=1;
//        while(!que.isEmpty()){
//            c top = que.pollFirst();
//            if(top.p.x==s && top.p.y==d) {
//                minCost=Math.min(top.cost,minCost);
//                continue;
//            }
//            int dx[] ={1,-1,0,0};
//            int dy[]={0,0,1,-1};
//            int nextCost= 0 ;
//            for (int i = 0; i < 4; i++) {
//                if(top.p.x+dx[i]<0 || top.p.x+dx[i]>=m.length || top.p.y+dy[i]<0 || top.p.y+dy[i]>=m.length) continue;
//                if(vis[top.p.x+dx[i]][top.p.y+dy[i]]!=1) {
//                    if(m[top.p.x+dx[i]][top.p.y+dy[i]]=='-') nextCost=0;
//                    else if(m[top.p.x+dx[i]][top.p.y+dy[i]]=='#') nextCost=a;
//                    else if(m[top.p.x+dx[i]][top.p.y+dy[i]]=='*') {
//                        if(top.p.x==tp.get(0).x && top.p.y == tp.get(0).y){
//                            int xx = tp.get(1).x,yy=tp.get(1).y;
//                            if(vis[xx][yy]==1)
//                                que.addLast(new c(new Pos(xx,yy),top.cost+b));
//                        }
//                        else {
//                            int xx = tp.get(0).x,yy=tp.get(0).y;
//                            if(vis[xx][yy]==1)
//                                que.addLast(new c(new Pos(xx,yy),top.cost+b));
//                        }
//                    }
//                    que.addLast(new c(new Pos(top.p.x + dx[i], top.p.y + dy[i]), top.cost+nextCost));
//                }
//            }
//
//
//        }
    }
}
*/

import java.util.*;
public class Main {
    static class Pos {
        int x, y;
        public Pos() {
        }
        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int times = 0, a, b, minCost = Integer.MAX_VALUE;
    static LinkedList<Pos> tp;
    static LinkedList<Pos> change = new LinkedList<>();
    static  int min=Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        tp = new LinkedList<>();
        char[][] m = new char[n][n];
        int[][] vis = new int[n][n];
        for(int i=0;i<vis.length;i++){
            Arrays.fill(vis[i],Integer.MAX_VALUE);
        }
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (m[i][j] == '*') tp.add(new Pos(i, j));
            }
        }
        deepSearch(m, vis, 0, 0, n - 1, n - 1, 0);
        System.out.println(min);
    }

    private static void deepSearch(char[][] m,int[][] vis, int x, int y, int s, int d,int cost) {
        if(x<0 || x>=m.length || y<0 || y>=m.length || vis[x][y] <= cost) return;
        if(x==s&&y==d) {
            if(cost<min) min=cost;
            return;
        }
        if(vis[x][y]>cost)
            vis[x][y]=cost;
        if(m[x][y]=='#') {
            cost += a;
        }
        if(m[x][y]=='*')
        {   int i=tp.get(0).x;
            int j=tp.get(0).y;
            if(i==x && j==y)
                deepSearch(m,vis,tp.get(1).x,tp.get(1).y,s,d,cost+b);
            else
                deepSearch(m,vis,tp.get(0).x,tp.get(0).y,s,d,cost+b);
        }
        deepSearch(m,vis,x-1,y,s,d,cost);
        deepSearch(m,vis,x+1,y,s,d,cost);
        deepSearch(m,vis,x,y-1,s,d,cost);
        deepSearch(m,vis,x,y+1,s,d,cost);
    }
}