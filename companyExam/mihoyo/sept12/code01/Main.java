package mihoyo.sept12.code01;

import java.util.*;

public class Main {

    public int[] GetLeastNumbers(int[] input, int k) {
        if (k < 0 || input.length == 0) return new int[0];
        Arrays.sort(input);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=input[i];
        }
//        if (k >= input.length) return input;
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, Comparator.reverseOrder());
//        maxHeap.add(input[0]);
//        for (int i = 1; i < input.length; i++) {
//            if (maxHeap.size() < k) maxHeap.add(input[i]);
//            else {
//                if (input[i] < maxHeap.peek()) {
//                    maxHeap.poll();
//                    maxHeap.add(input[i]);
//                }
//            }
//        }
//        int[] res= new int[maxHeap.size()];
//        for (int i = 0; i <res.length; i++) {
//            res[i]=maxHeap.poll();
//        }
        return  res;
    }
    public int[] GetSortedTasks(int[][] taskLists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < taskLists.length; i++) {
            for (int j = 0; j < taskLists[i].length; j++) {
                minHeap.add(taskLists[i][j]);
            }
        }
        int round = minHeap.size();
        int[] res = new int[round];
        for (int i = 0; i < round; i++) {
            res[i] = minHeap.poll();
        }
        return res;
    }
    public int[] GetSortedTasks2(int[][] taskLists) {//多路归并1
        int n = taskLists.length,m = taskLists[0].length;
        int[] res = new int[n*m];
        int resIndex = 0;
        LinkedList<Node> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(taskLists[i]));
        }
        for (int i = 0; i < n * m; i++) {
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < nodes.size(); j++) {
               if(nodes.get(j).peekTopInt()!=-1){
                   if(min>nodes.get(j).peekTopInt()){
                       min=nodes.get(j).peekTopInt();
                       index=j;
                   }
               }
               nodes.get(index).pollTopInt();
            }
            res[resIndex++]=min;
        }
        return res;
    }
}
class Node{
    int index=0;
    int[] nums;

    public Node(int[] nums) {
        this.nums = nums;
    }

    public int pollTopInt() {
        if (this.index==this.nums.length) return -1;
        return nums[index++];
    }
    public int peekTopInt() {
        if (this.index==this.nums.length) return -1;
        return nums[index];
    }
}