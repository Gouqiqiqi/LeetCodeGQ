package companyExam.WangYiHuYu.code1;

import java.util.Scanner;

/**
 * @author Hu Yilv
 * @date 2021年09月17日 20:18
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        int[] num= new int[T];
        for (int i = 0; i < T; i++) {
            String cur = sc.nextLine();
            StringBuilder sb = new StringBuilder(),res = new StringBuilder();
            for (int j = 0; j < cur.length(); j++) {
                sb.append(Integer.toBinaryString(cur.charAt(j)-'0'));
            }
            sb.append(0);
            sb.reverse();
            int l=0;
            while (l<sb.length()&& sb.charAt(l)=='0') l++;
            res.append(sb.charAt(l++));
            while (l<sb.length()){
                while (l<sb.length() && sb.charAt(l)==sb.charAt(l-1)) l++;
                if(l<sb.length())    res.append(sb.charAt(l++));
            }
            System.out.println(res.toString());
        }
    }

}
