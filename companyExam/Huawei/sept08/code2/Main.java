package companyExam.Huawei.sept08.code2;

import java.util.*;
public class Main {
    static int min =Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n =sc.nextInt();
        int k =sc.nextInt();
        sc.nextLine();
        int num[]=new int[n];
        for(int i=0;i<n;i++){
            num[i] =sc.nextInt();
        }
        func(0,0,num,k,0);
        System.out.println(min);
    }
    public static void func(int ind,int c,int []num,int k,int count){
        if(c>=min || count>k) return;
        if(ind == num.length){
            if(c<min) min = c;
            return;
        }
        func(ind+1,c,num,k,count+1);
        int l=num[ind];
        int r=-1;
        if(ind+1<num.length)
            r=num[ind+1];
        if(l > r){
            int t =l;
            l = r ;
            r = l ;
        }
        for(int i=ind+1;i<num.length;){
            if(num[i]>r)
                r=num[i];
            else if(num[i]<l){
                l=num[i];
            }
            i++;
            while(i < num.length && num[i]<=r && num[i]>=l ) i++;
            func(i,Math.max(r-l,c),num,k,count+1);
        }
    }
}