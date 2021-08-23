package JUCstudy.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 8个关于锁的问题
 * 1、标准情况下，先执行A还是B
 * 2、在A中增加延时，先执行A还是B
 * A
 * synchronized锁的是调用者，因此锁的都是同一个phone对象，线程A创建，随即主线程休眠，此时没有争用，A独占资源1S。
 * 在当前计算机速度下，B没有可能被创建。
 */
public class Test {
    public static void main(String[] args) {
        phone phone = new phone();
        new Thread(()->{phone.send();},"A").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{phone.call();},"B").start();

    }

}
class phone{
    public synchronized void send(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
    
}