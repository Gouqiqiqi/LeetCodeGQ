package companyExam.meidi.code1;

import java.util.ArrayList;

/**
 * @author Hu Yilv
 * @date 2021年09月17日 16:19
 * 杨辉三角
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> generate (int numRows) {
        // write code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(1);
        res.add(nums);
        for (int i = 1; i < numRows; i++) {
            nums = new ArrayList<>(); nums.add(1);
            int len = res.get(i-1).size();
            for (int j = 0; j < len - 1; j++) {
                nums.add(res.get(i-1).get(j)+res.get(i-1).get(j+1));
            }
            nums.add(1);
            res.add(nums);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().generate(4);
    }
}
