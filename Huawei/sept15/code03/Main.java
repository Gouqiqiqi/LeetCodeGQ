package Huawei.sept15.code03;
import java.util.*;
// We have imported the necessary tool classes.
// If you need to import additional packages or classes, please import here.
//a,1,5
//b,1,3
//c,3,5


/**
 * 乘客买票
 */
public class Main {
    static class passenger{
        String name;
        int money;
        int dis ;
        passenger(String[] split){
            name = split[0];
            int start = Integer.parseInt(split[2]);
            start -= Integer.parseInt(split[1]);
            dis = start;
            if(start == 4) money =280;
            else if(start==3) money = 240;
            else if(start==2) money = 180;
            else  money = 100;
        }
    }
    static int max=0;
    static List<Integer> res;
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        String s ;
        String[] split;
        LinkedList<passenger> list = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        while(sc.hasNextLine()){
            s = sc.nextLine();
            if(s.length()==0) break;
            split = s.split(",");
            list.add(new passenger(split));
        }
        LookIn(list,0,4,path, 0);
        for(int i = 0 ; i < res.size() ; i++){
            if(i<res.size()-1) System.out.print(list.get(res.get(i)).name+" ");
            else System.out.println(list.get(res.get(i)).name);
        }
    }
    public static void LookIn(List<passenger> list,int start , int dis ,LinkedList<Integer> path ,int sum){
        if(dis <0) return;
        if(sum > max){
            max = sum;
            res = new LinkedList(path);
        }
        if(start == list.size()){

            return;
        }
        for(int i = start ; i < list.size() ; i++){
            path.add(i);
            LookIn(list,i+1,dis-list.get(i).dis, path,sum+list.get(i).money);
            path.removeLast();
        }

    }
}