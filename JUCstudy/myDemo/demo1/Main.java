package JUCstudy.myDemo.demo1;

import java.util.concurrent.atomic.AtomicInteger;

class resource{
    AtomicInteger a = new AtomicInteger(9);}
class myThread implements Runnable {
    static resource myInt = new resource();
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int thrInt = myInt.a.getAndDecrement();
            System.out.println(thrInt);
            if (thrInt <= 1) break;
        }
    }
}

class myCOUNT{
    static AtomicInteger n = new AtomicInteger(9);


    public static synchronized void decN(){
        if(n.get()==0) return;
        else n.decrementAndGet();
    }
    public static int getN(){
        return n.get();
    }
}
class myThread2 implements  Runnable{

    @Override
    public void run() {
        while (true){
            if(myCOUNT.getN()==0)break;
            System.out.println(Thread.currentThread().getName()+myCOUNT.getN());
            myCOUNT.decN();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        new Thread(new myThread2(), "a").start();
        new Thread(new myThread2(), "b").start();
        new Thread(new myThread2(), "v").start();

    }
}
