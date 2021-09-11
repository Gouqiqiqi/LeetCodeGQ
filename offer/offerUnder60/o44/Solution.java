package offer.offerUnder60.o44;

public class Solution {
    public int findNthDigit(int n) {
        if(n<10) return n;
        int digit=1;
        double indexMAX=9,count =indexMAX*digit;
        while((n-count)>0){
            n-=count;

            digit+=1;
            indexMAX*=10;
            count=indexMAX*digit;
        }
        int num = (int)(n-1)/digit;
        int yu =(int) n%digit;
        if(yu == 0 )  yu = digit;
        num= num + (int)Math.pow(10,digit-1);
        int res = num%(int)Math.pow(10,digit-yu+1);
        res = res/(int)Math.pow(10,digit-yu);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        new Solution().findNthDigit(1000000000);

    }
}
