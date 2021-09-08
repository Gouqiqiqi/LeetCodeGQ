package offer.offerUnder60.o41;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
        PriorityQueue<Integer> minHeap,maxHeap;
        /**
         * initialize your data structure here.
         */
        public Solution() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(500,((o1, o2) -> o2-o1));

        }
        public void addNum(int num) {
//            int i = 0 , j = nums.size();
//            int mid,temp;
//            while(i<j){
//                mid= i+(j-i)>>1;
//                temp=nums.get(mid);
//                if(temp==num){
//                    nums.add(mid,num);break;
//                }
//                if(temp>num) j=mid;
//                else i=mid+1;
//            }
//            if(i==j){
//                nums.add(i,num);
//            }
            if((maxHeap.size()+minHeap.size()&1)==0){//into maxHeap
                if(minHeap.size()!=0 && num>minHeap.peek()){
                    minHeap.add(num);
                    num=minHeap.poll();
                }
                maxHeap.add(num);
            }
            else {
                if(num<maxHeap.peek()){
                    maxHeap.add(num);
                    num=maxHeap.poll();
                }
                minHeap.add(num);
            }
        }

        public double findMedian() {
            if(maxHeap.size()==0) return 0;
            if(minHeap.size()==0) return maxHeap.peek();
            if(maxHeap.size()-minHeap.size()==0){
                return (maxHeap.peek()+minHeap.peek())/2.0;
            }
            else {
                return maxHeap.peek();
            }

        }


    public static void main(String[] args) {
        Solution a = new Solution();
        a.addNum(1);
        System.out.println(a.findMedian());
        a.addNum(2);
        System.out.println(a.findMedian());
        a.addNum(3);
        System.out.println(a.findMedian());
        a.addNum(4);
        System.out.println(a.findMedian());
        a.addNum(5);
        System.out.println(a.findMedian());a.addNum(6);
        System.out.println(a.findMedian());a.addNum(7);
        System.out.println(a.findMedian());




    }
}
