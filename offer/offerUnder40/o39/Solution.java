package offer.offerUnder40.o39;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Solution {

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Integer count;
        for (int i = 0; i < nums.length; i++) {
            if((count=map.get(nums[i]))!=null)
            {
                if(count+1>nums.length/2) return nums[i];
                map.put(nums[i],count+1);
            }
            else map.put(nums[i],1);
        }
        Set<Integer> keys = map.keySet();
        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()){
            count=it.next();
            if(map.get(count)>nums.length/2) return count;
        }
        return -1;
    }
}
