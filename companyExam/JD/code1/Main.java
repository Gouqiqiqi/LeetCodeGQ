package companyExam.JD.code1;

import java.util.Scanner;

public class Main {
    static  int xxx,yyy;
    static int pos=0,xx=0,yy=0; ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,m,x,y,z;
        n=sc.nextInt();        m=sc.nextInt();
        x=sc.nextInt();        y=sc.nextInt();
        z=sc.nextInt();
        char[][] kb = new char[n][m];
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            kb[i]=sc.nextLine().toCharArray();
        }
        String tar = sc.nextLine();
        
        // 方向 01234 0代表开始状态，没有转向耗时 上下左右
        //所在坐标
        int time=0;
        for (int round = 0; round < tar.length(); round++) {
            findC(kb, tar.charAt(round));
            time += move(xx, yy, xxx, yyy, x, y, z);

        }
        System.out.println(time);
    }
    // pos方向 01234 0代表开始状态，没有转向耗时 1234上下左右
    private static int move(int sx, int sy, int dx, int dy, int move, int turn, int press) {
        int addTime=0;
        if(dx==sx){
            if(dy==sy){ addTime+=press;xx=dx;yy=dy;return addTime;}
            if(dy>sy){//右
                if(pos!=0 && pos!=4){ addTime+=turn; pos=4;}
                if(pos==0) pos=4;
                addTime+= Math.abs(dy-sy)*move+press;
                xx=dx;yy=dy;return addTime;
            }
            if(dy<sy){//左
                if(pos!=0 && pos!=3){ addTime+=turn; pos=3;}
                if(pos==0) pos=3;
                addTime+= Math.abs(dy-sy)*move+press;
                xx=dx;yy=dy;return addTime;
            }
        }
        if(dy==sy){
            if(dx==sx){addTime+=press;xx=dx;yy=dy;return addTime;}
            if(dx>sx){//下
                if(pos!=0 && pos==2){ addTime+=turn; pos=2;}
                if(pos==0) pos=2;
                addTime+= Math.abs(dx-sx)*move+press;
                xx=dx;yy=dy;return addTime;
            }
            if(dx<sx){//上
                if(pos!=0 && pos==1){ addTime+=turn; pos=1;}
                if(pos==0) pos=1;
                addTime+= Math.abs(dx-sx)*move+press;
                xx=dx;yy=dy;return addTime;
            }
        }
        if(dx!=sx && dy!=sy){
            addTime+= move(sx,sy,sx,dy,move,turn,press);
            addTime-=press;
            addTime+= move(sx,dy,dx,dy,move,turn,press);
            return addTime;
        }
        return 0;
    }

    private static void findC(char[][] kb, char charAt) {
        for (int i = 0; i < kb.length; i++) {
            for (int j = 0; j < kb[0].length; j++) {
                if(kb[i][j]==charAt){ xxx=i;yyy=j;}
            }
        }
    }
}
/**
 * public class Mainll {
 *
 *     public static void main(String[] args) {
 *         Scanner sc = new Scanner(System.in);
 *         int n = sc.nextInt();
 *         int m = sc.nextInt();
 *         int x = sc.nextInt();
 *         int y = sc.nextInt();
 *         int z = sc.nextInt();
 *         sc.nextLine();
 *         String[] list = new String[n];
 *         for(int i = 0;i<n;i++){
 *             list[i] = sc.nextLine();
 *         }
 *         String xi = sc.nextLine();
 *         Map<Character, int[]> hash = new HashMap<>();
 *         for(int i=0;i<list.length;i++){
 *             for (int j =0;j<list[i].length();j++){
 *                 Character c = list[i].charAt(j);
 *                 int[] dic = new int[]{i,j};
 *                 hash.put(c, dic);
 *             }
 *         }
 *         int ans = 0;
 *         int cow=0,con=0;
 *         for(int i=0;i<xi.length();i++){
 *             int cowNew = hash.get(xi.charAt(i))[0],conNew = hash.get(xi.charAt(i))[1];
 *             if(cowNew!=cow&&conNew!=con){
 *                 ans += y;
 *             }
 *             ans += (Math.abs(cow-cowNew)+Math.abs(con-conNew))*x+z;
 *             cow = cowNew;
 *             con = conNew;
 *         }
 *         System.out.println(ans);
 *
 *     }
 * }
 */