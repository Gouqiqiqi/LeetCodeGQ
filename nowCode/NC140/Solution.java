package nowCode.NC140;

public class Solution {
    public int[] MySort (int[] arr) {
        // write code here
//         Arrays.sort(arr);
//         return arr;
        for(int i = 0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1; j<arr.length;j++){
                if( arr[j] <arr[min] ) min=j;
            }
            if(min!=i){
                int t =arr[i];
                arr[i] = arr[min];
                arr[min]=t;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        new Solution().MySort(new int[]{5,2,3,1,4});
    }
}
