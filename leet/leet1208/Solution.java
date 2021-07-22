package leet1208;


class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len =s.length();
        int[] dis = new int[len];
        for (int i =0;i<len;i++){
            dis[i] = Math.abs(s.charAt(i)-t.charAt(i));
        }
        int left=0,right=0;
        int cost=0,maxlen=0;
        while(right<s.length()){
            if(cost<=maxCost){
                cost+=dis[right];right+=1;
            }
            else{
                if (cost!=maxCost)  maxlen=maxlen>(right-left-1)?maxlen:(right-left-1);
                else maxlen=maxlen>(right-left)?maxlen:(right-left);

                cost-=dis[left];left+=1;
            }
        }
       if (cost>maxCost)  maxlen=maxlen>(right-left-1)?maxlen:(right-left-1);
       else maxlen=maxlen>(right-left)?maxlen:(right-left);


        return maxlen;
    }

    public static void main(String[] args) {
        Solution a = new Solution();
        int i = a.equalSubstring("abcda","cdefa",3);
        System.out.println(i);
    }
}