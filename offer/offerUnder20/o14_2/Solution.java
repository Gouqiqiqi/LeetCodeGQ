package offer.offerUnder20.o14_2;

public class Solution {
    public int cuttingRope(int n) {
        if(n==2) return 1;
        long vis[]= new long[n+1];
        vis[2]=2L;
        vis[1]=1L;
        vis[3]=3L;
        long max = 0L;
        for(int i = 4; i < n+1;i++){
            max = 0;
            for(int j = 1;j<i;i++) {
                max = Math.max((vis[j]%1000000007L)*(i-j)%1000000007L,max%1000000007L);
            }
            vis[i]=max;
        }
        return  (int)(vis[n]%1000000007L);
    }
}
