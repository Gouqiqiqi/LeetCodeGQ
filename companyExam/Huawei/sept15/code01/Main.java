package companyExam.Huawei.sept15.code01;

import java.util.Scanner;

/**
 * 输入两个数组 分别是工位x轴坐标 消毒器安装x轴坐标
 * 求消毒器半径
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(" ");
        int[] pos= new int[split.length];
        for (int i = 0; i < pos.length; i++) {
            pos[i]=Integer.parseInt(split[i]);
        }
        s=sc.nextLine();
        split = s.split(" ");
        int[] cleaner = new int[split.length];
        for (int i = 0; i < cleaner.length; i++) {
            cleaner[i]=Integer.parseInt(split[i]);
        }
        int radis= 0;

    }
}