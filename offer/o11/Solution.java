package offer.o11;

public class Solution {
    public int minArray(int[] numbers) {
        if(numbers.length==1) return numbers[0];
        int l=0,r=numbers.length-1,temp = numbers[0];
        int mid=0;
        while(l<=r){ //等于用于处理【3，1】
            mid= (l+r)/2;
            if(numbers[mid]<temp)
                break;
            l=mid+1;
        }
        for(;mid>=0;mid--){
            if(mid==0) return numbers[mid];
            if(numbers[mid]<numbers[mid-1]) return numbers[mid];
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minArray(new int[]{2,2,2,2,1,2}));
    }
}
