import javax.swing.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(new Test().maxSlidingWindow(new int[]{1,-1},1));
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        long t = System.currentTimeMillis();
        int min = list.stream().min((a, b) -> a > b ? 1 : -1).get();
        long t1 = System.currentTimeMillis();
        int Max = Collections.min(list);
        long t2 = System.currentTimeMillis();
        System.out.println(min);//1
        System.out.println(t1-t);//4
        System.out.println(Max);//1
        System.out.println((t2-t1));//0
    }


    public ArrayList<Integer> main(ArrayList<Integer> a,ArrayList<Integer> b){
        //升序归并
        ArrayList<Integer> c = new ArrayList();
        int i =0,j=0;
        while(i<a.size() && j <b.size()){
            if(a.get(i)>b.get(j)) {c.add(b.get(j));j++;}
            else {c.add(a.get(i)); i++;}
        }
        while(i<a.size()) {c.add(a.get(i));i++;}
        while(j<b.size()) {c.add(b.get(j));j++;}
        return c ;
    }
    public int halfSearch(ArrayList<Integer> a,int x){
        //有序表中查找元素x
        int left=0,right = a.size()-1;
        int mid;
        while(left<right){
            mid=left+right/2;
            if(mid ==x ) return mid;
            if(mid>x) left=mid+1;
            else right=mid-1;
        }
        return -1;
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1) return new int[]{nums[0]};
        int max=nums[0],count=0;
        int[] res=new int[nums.length-k+1];
        for(int i=k-1;i<nums.length;i++){
            max=sumIK(nums,i,k);
            res[count++]=max;
        }
        return res;
    }
    public int sumIK(int[] nums,int i,int k){
        int max=nums[0];
        while(k>0){
            max= max>nums[i-k+1]?max:nums[i-k+1];
            k--;
        }
        return max;
    }
}
