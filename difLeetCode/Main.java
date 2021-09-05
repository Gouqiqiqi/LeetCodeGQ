package difLeetCode;


import java.util.Scanner;
// 分段回文串
public class Main {
    //static List<List<Character>> res = new ArrayList<>();
    static  int count=0;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String s = sc.nextLine();
        if(s.length() ==0) System.out.println(0);
        func(0,s);
        System.out.println(count);
    }
    public static void func(int ind,String s){
        if(ind==s.length()) {
            count++;
            return;
        }
        func(ind+1,s);
        for(int i = ind+1;i < s.length();i++){
            int pl=ind,pr=i;
            while(pl<pr){
                if(s.substring(ind,pl+1).equals(s.substring(pr,i+1))){
                    func(i+1,s);
                    break;
                }
                pl++;
                pr--;
            }
        }
    }
}
