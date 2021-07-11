package leet981;
/*
总结：
iterator初始化位于第一个对象以前，每次next都会发生移动。it本身是当前指定的类的一个对象。
map可以嵌套，Map<String, TreeMap<Integer, String>> map = new HashMap<>()
TreeMap和TreeSet内置了floor()和ceiling()方法，寻找大于等于和小于等于TreeMapA.floorEntry(key)
map的Entry没有学习！
*/
import java.util.*;
/**
 * 题目不可覆盖式更新，可能有旧时间戳的查询请求
 * set操作的time严格递增
 */
class TimeMap {
    TreeMap<String, ArrayList<Integer>> kt;
    TreeMap<Integer, String> tv;

    /** Initialize your data structure here. */
    public TimeMap() {
         tv = new TreeMap<>();
         kt = new TreeMap<>();
    }


    public void set(String key, String value, int timestamp) {
        ArrayList<Integer> timeList= new ArrayList();;
        if(kt.get(key)!=null){
            timeList = kt.get(key);
            timeList.add(timestamp);
            // Collections.sort(timeList,Collections.reverseOrder());
        }
        else{
            timeList.add(timestamp);
        }
        this.kt.put(key,timeList);
        this.tv.put(timestamp, value);
    }

    public String get(String key, int timestamp) {

        ArrayList<Integer> timeList = kt.get(key);
        if(timeList==null) return "";
        int len = timeList.toArray().length;
        if(timestamp<timeList.get(0)) return "";
        if (timestamp>=timeList.get(len-1)) return tv.get(timeList.get(len-1));
        for(int i =1; i<len;i++){
            if(timestamp<=timeList.get(i)) return tv.get(timeList.get(i-1));
        }

        return  "";
    }

    public static void main(String[] args) {
        TimeMap kv= new TimeMap();
        kv.set("foo", "bar", 1); // 存储键 "foo" 和值 "bar" 以及时间戳 timestamp = 1  
        String a;
        a=kv.get("foo", 1);  // 输出 "bar"  
        System.out.println(a);
        a=kv.get("foo", 3);
        System.out.println(a); // 输出 "bar" 因为在时间戳 3 和时间戳 2 处没有对应 "foo" 的值，所以唯一的值位于时间戳 1 处（即 "bar"）  
        kv.set("foo", "bar2", 4); // 
        a=kv.get("foo", 4); // 输出 "bar2"  
        System.out.println(a);
        a=kv.get("foo", 5); // 输出 "bar2"
        System.out.println(a);

    }
}

/*优秀题解
    TreeMap<String, ArrayList<Integer>> kt;
    TreeMap<Integer, String> tv;

    public TimeMap() {
    }

        Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }
        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = map.getOrDefault(key, new TreeMap<>()).floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
*/


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */

/*
不能使用覆盖式更新
输入
["TimeMap","set","set","get","get","get","get","get"]
[[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
输出：
[null,null,null,null,null,null,"low","low"]
预期结果：
[null,null,null,"","high","high","low","low"]
class TimeMap {
    HashMap<String, Integer> kt;
    HashMap<String, String> kv;

public TimeMap() {
        kv = new HashMap<>();
        kt = new HashMap<>();
        }

public void set(String key, String value, int timestamp) {
        if (kt.containsKey(key)){
        int timepre =kt.get(key);
        if (timepre>timestamp) return;
        }
        this.kv.put(key, value);
        this.kt.put(key,timestamp);
        }

public String get(String key, int timestamp) {
        if (!kv.containsKey(key))
        return null;
        if(kt.get(key)>timestamp)
        return null;
        return kv.get(key);
        }
 }
*/

/** 超时
class TimeMap {
    TreeMap<String, ArrayList<Integer>> kt;
    TreeMap<Integer, String> tv;

public TimeMap() {
    tv = new TreeMap<>();
    kt = new TreeMap<>();
}

    public void set(String key, String value, int timestamp) {
        ArrayList<Integer> timeList= new ArrayList();;
        if(kt.get(key)!=null){
            timeList = kt.get(key);
            timeList.add(timestamp);
            Collections.sort(timeList,Collections.reverseOrder());//sort 超时
        }
        else{
            timeList.add(timestamp);
        }
        this.kt.put(key,timeList);
        this.tv.put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!kt.containsKey(key))
            return "";

        ArrayList<Integer> timeList = kt.get(key);
        Iterator i = timeList.iterator();

        while(i.hasNext()){
            int comp= (int)i.next();
            if(timestamp>=comp) return tv.get(comp);
        }

        return  "";
    }
}
 */

/*  头插 目前最优

class TimeMap {
    TreeMap<String, ArrayList<Integer>> kt;
    TreeMap<Integer, String> tv;


    public TimeMap() {
        tv = new TreeMap<>();
        kt = new TreeMap<>();
    }

        public void set(String key, String value, int timestamp) {
            ArrayList<Integer> timeList= new ArrayList();;
            if(kt.get(key)!=null){
                timeList = kt.get(key);
                timeList.add(0,timestamp);//头插
    //            Collections.sort(timeList,Collections.reverseOrder());
            }
            else{
                timeList.add(timestamp);
            }
            this.kt.put(key,timeList);
            this.tv.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            ArrayList<Integer> timeList = kt.get(key);
            if (timeList!=null) {
                Iterator i = timeList.iterator();
                while (i.hasNext()) {
                    int comp = (int) i.next();
                    if (timestamp >= comp) return tv.get(comp);
                }
            }
            return "";
        }
}*/
