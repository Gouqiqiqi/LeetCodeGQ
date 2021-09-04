import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        new Test().superEggDrop(2,3);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11,(o1, o2)->o2.compareTo(o1));

    }
//    https://ieeexplore.ieee.org/document/6784529
//    https://ieeexplore.ieee.org/stamp/stamp.jsp?tp=&arnumber=6784529
    public int superEggDrop(int k, int n) {
       if(n==2) return 2;
       if(n==1) return 1;
       else return 1+superEggDrop(k,n/2);
    }
}