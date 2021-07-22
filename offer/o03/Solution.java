package offer.o03;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int x : nums){
            if(set.contains(x)) return x;
            else  set.add(x);
        }
        return  -1;
    }

    public static void main(String[] args) {

    }
}
