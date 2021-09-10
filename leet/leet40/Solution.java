package leet.leet40;

import java.util.*;

public class Solution {
    Set<List<Integer>> res = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates==null) return  null;
        LinkedList<Integer> path = new LinkedList<>();
        Arrays.sort(candidates);
        for(int i = 0 ; i<candidates.length ;i++){
            if(candidates[i]>target|| (i>0&&candidates[i]==candidates[i-1])) continue;
            // 从i开始向后搜索
            path.add(candidates[i]);
            LookIn(candidates,i+1,target-candidates[i],path);
            path.removeLast();

        }
        for(List<Integer> x:res){
            {System.out.println(x);}
        }
        return  res.stream().toList();
    }
    public void LookIn(int[] ca , int start ,int target,LinkedList<Integer> path){
        if(target == 0 ) {if(!res.contains(path)){ res.add(List.copyOf(path));return;}}//need a deepCopy
        if(start==ca.length || target<ca[start]) return;

        if(ca[start]<=target){

            path.add(ca[start]);
            LookIn(ca,start+1,target-ca[start],path);
            path.removeLast();
        }
        LookIn(ca,start+1,target,path);
    }

    public static void main(String[] args) {
        new Solution().combinationSum2(new int[]{10,1,2,7,6,1,5},8);
    }
}
