package JUCstudy.myDemo;
//多线程同步问题
//进一步，多线程顺序执行

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class myThread implements Runnable  {

    private int count = 9;

    @Override
    public void run() {
        while (true) {
            synchronized (myThread.class) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count <= 0) break;
                System.out.println(Thread.currentThread().getName() + ":" + count-- + " is decd");

            }
        }
    }
}

class myThread2 implements  Runnable{
    private Integer count = 9;

    @Override
    public void run() {
        while (true) {
            synchronized (count) {//只对被锁对象内部有效

                if (count <= 0) break;
                System.out.println(Thread.currentThread().getName() + ":" + count-- + " is decd");

            }
        }
    }
}

class myThread3 implements Runnable{
    private Integer count = 9;
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        while (true){
            lock.lock();
            try {
                Thread.sleep(100);
                if (count <= 0) break;
                System.out.println(Thread.currentThread().getName() + ":" + count-- + " is decd");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}
class Main2 {
    public static void main(String[] args) {
        myThread2 count = new myThread2();
        new Thread(count,"a").start();
        new Thread(count,"b").start();
        new Thread(count,"c").start();

    }
}

class resource{
    Integer num = 9;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    public   void decOne(){
        while (true) {
            try {
                lock.lock();


            System.out.println(Thread.currentThread().getName()+":"+num--);
            condition2.signal();
            condition1.await();
            lock.unlock();} catch (InterruptedException e) {
            e.printStackTrace();
        }
        }
    }
    public   void decTwo(){
        while (true) {
            try {lock.lock();
                condition2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+num--);
            condition3.signal();lock.unlock();
        }
    }
    public   void decThree(){
        while (true) {
            try {lock.lock();
                condition3.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+":"+num--);
            condition1.signal();lock.unlock();
        }
    }
}
public  class Main  {
    public static void main(String[] args) {
        resource resource = new resource();
        new Thread(()->{resource.decOne();},"a").start();
        new Thread(()->{resource.decTwo();},"b").start();
        new Thread(()->{resource.decThree();},"c").start();
    }
}