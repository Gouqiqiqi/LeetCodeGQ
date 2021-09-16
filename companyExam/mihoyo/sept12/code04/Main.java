package mihoyo.sept12.code04;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    static int res =0;
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, Comparator.reverseOrder());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            int sum = 0;
            res = 0;
            maxHeap.clear();
            for (int j = 0; j < nums.length; j++) {
                nums[j] = sc.nextInt();
                if (nums[j] < 0) maxHeap.add(nums[j]);
                else {
                    res += 1;
                    sum += nums[j];
                }
            }
            if(maxHeap.size()==0) {
                System.out.println(res);
                break;
            }
            while (sum + maxHeap.peek() >= 0) {
                res += 1;
                sum += maxHeap.poll();
                if(maxHeap.size()==0) break;
            }
            System.out.println(res);
        }
    }

    private static void func(int[] nums,int start ,int sum , int thisMax) {
        if(sum<0){
            res = Math.max(res, thisMax - 1);
            return;
        }
        if(start==nums.length){
            res = Math.max(res, thisMax);
            return;
        }

        func(nums,start+1,sum+nums[start],thisMax+1);
        func(nums,start+1,sum,thisMax);
    }
}
