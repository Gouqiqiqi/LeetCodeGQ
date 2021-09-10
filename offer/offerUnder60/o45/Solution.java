package offer.offerUnder60.o45;

import java.util.*;

public class Solution {
    public String minNumber(int[] nums) {
        List<String> strings = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            strings.add(String.valueOf(nums[i]));
        }
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String x : strings){
            sb.append(x);
        }
        return sb.toString();
    }
}
