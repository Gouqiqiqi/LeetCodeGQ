package leet.leet164;

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
//        lRUCache.put(1, 1); // 缓存是 {1=1}
//        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//        lRUCache.get(1);    // 返回 1
//        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//        lRUCache.get(2);    // 返回 -1 (未找到)
//        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//        lRUCache.get(1);    // 返回 -1 (未找到)
//        lRUCache.get(3);    // 返回 3
//        lRUCache.get(4);    // 返回 4
        lRUCache.put(2,1);
        lRUCache.get(2);
    }
}

class  DoubleNode{
    int val;
    int key;
    DoubleNode next;
    DoubleNode pre;

    public DoubleNode(int key, int val) {
        this.val = val;
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    public int getVal() {
        return val;
    }
}
class LRUCache {
    HashMap<Integer,DoubleNode> map ;
    DoubleNode head,tail;
    int capa;
    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        capa=capacity;
        head= new DoubleNode(0,0);
        tail=new DoubleNode(0,0);
        head.next=tail;
        head.pre=tail;
        tail.next=head;
        tail.pre = head;
    }

    public int get(int key) {
        DoubleNode p = map.get(key);
        if(p!=null) {
            p.next.pre=p.pre;
            p.pre.next=p.next;
            //put tail pre
            p.next=tail;p.pre=tail.pre;
            tail.pre.next=p;
            tail.pre=p;

            return p.val;
        }
        else return -1;
    }

    public void put(int key, int value) {

        DoubleNode p = map.get(key);
        if(p!=null) {
            p.next.pre=p.pre;
            p.pre.next=p.next;
            //put tail pre
            p.next=tail;
            p.pre=tail.pre;
            tail.pre.next=p;
            tail.pre=p;

            p.val=value;
        }
        else {
            p = new DoubleNode(key, value);

            if(map.size()==capa){
                map.remove(head.next.key);
                head.next.next.pre=head;
                head.next=head.next.next;
            }
            map.put(key, p);
            p.next=tail;
            p.pre=tail.pre;
            tail.pre.next=p;
            tail.pre=p;
        }
    }
}