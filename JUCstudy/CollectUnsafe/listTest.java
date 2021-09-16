package JUCstudy.CollectUnsafe;

import java.util.*;

public class listTest {
    public static void main(String[] args) {
        int ThreadNum = 30;
//        List<String> list = new ArrayList<>();
//        for (int i = 0; i < ThreadNum; i++) {
//            new Thread(() -> {
//                list.add(UUID.randomUUID().toString().substring(0, 5));
//                System.out.println(list);
//            }, String.valueOf(i)).start();
//        }
        List<String> list = new ArrayList<>();
        list.add("1");list.add("2");list.add("3");
        Iterator<String> it = list.iterator();
        while(it.hasNext()){
            String string = (String) it.next();
            System.out.println(string);
            //ConcurrentModificationException
            list.remove(1);
        }

    }
}
