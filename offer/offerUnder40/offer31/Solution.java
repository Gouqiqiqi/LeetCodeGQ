package offer.offerUnder40.offer31;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;


class Solution1 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : pushed) {
            stack.push(num); // num 入栈
            while(!stack.isEmpty() && stack.peek() == popped[i]) { // 循环判断与出栈
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

public class Solution {
    public static  boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length==1 || pushed.length == 0) return true;
        LinkedList<Integer> que = new LinkedList<>();
        HashSet<Integer> exist = new HashSet<>();
        int pushIndex= 0;


        //deal with next
        int popIndex = 0;
        while (popIndex<popped.length){
            if(que.isEmpty()==true){
                do
                {
                    que.addLast(pushed[pushIndex]);
                    exist.add(pushed[pushIndex]);
                }while(pushed[pushIndex++]!=popped[popIndex]);
            }
            else if( que.peekLast()==popped[popIndex]) {
                exist.remove(popped[popIndex]);
                popIndex++;
                que.removeLast();

            }
            else{

                if(exist.add(popped[popIndex])==false){
                    return false;
                }
                else {
                    exist.remove(popped[popIndex]);
                    do
                    {
                        que.addLast(pushed[pushIndex]);
                        exist.add(pushed[pushIndex]);
                    }while(pushed[pushIndex++]!=popped[popIndex]);
                }
            }
        }
        return  true;
    }

    public static void main(String[] args) {
        int[] a = {4,0,1,2,3};
        int[] b = {4,2,3,0,1};
        System.out.println(validateStackSequences(a,b));
    }
}