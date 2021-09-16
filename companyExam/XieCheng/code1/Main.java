package companyExam.XieCheng.code1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Hu Yilv
 * @date 2021年09月16日 19:12
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int[] count = new int[10];
        for (int i = 0; i < count.length; i++) {
            count[i]=sc.nextInt();
        }
        for(int i =1 ; i <= 100 ; i++){
            for(int j = 1 ; j <= 100 ; j++){
                if(check(Arrays.copyOf(count,count.length),i,j)){
                    System.out.print(i+" "+j);
                    return;
                };
            }
        }
    }
/**
 *
 * @author Hu Yilv
 * @date 2021/9/16 21:00
 * @param count 计数数组 传入记得拷贝 数组是引用类型，会被修改
 * @param in1   乘数1
 * @param in2   乘数2
 * @return boolean 返回乘数1*乘数2过程中出现各种数字的次数是否等于计数数组
 */
    private static boolean check(int[] count, int in1, int in2) {
        String num2 = String.valueOf(in2) ;
        int temp;
        temp = in1;
        do{
            int yu = temp%10;
            if(count[yu]==0) break;
            else count[yu]--;
            temp=temp/10;
        }while (temp != 0);
        temp = in1;
        do{
            int yu = temp%10;
            if(count[yu]==0) break;
            else count[yu]--;
            temp=temp/10;
        }while (temp != 0);
        for (int j = 0; j < num2.length(); j++) {
            temp = in1*Integer.parseInt(String.valueOf(num2.charAt(j)));
            do{
                int yu = temp%10;
                if(count[yu]==0) break;
                else count[yu]--;
                temp=temp/10;
            }while (temp != 0);
        }
        temp = in1*in2;
        do{
            int yu = temp%10;
            if(count[yu]==0) break;
            else count[yu]--;
            temp=temp/10;
        }while (temp != 0);
        for (int i = 0; i < count.length; i++) {
            if(count[i]!=0) return false;
        }
        return true;
    }
}
