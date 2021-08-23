package JUCstudy.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 5、静态同步方法单对象，先执行哪个?
 * 6、静态同步方法双对象，先执行哪个？
 * 都是A。
 * 静态同步方法锁的是class对象。phone.clas   此时B被A的锁拒绝访问。
 */
public class Test56 {
    public static void main(String[] args) {
        phone3 phone5 = new phone3();
        phone3 phone6 = new phone3();
        new Thread(()->{
            phone5.send();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
//            phone5.call();
            phone6.call();
        },"B").start();

    }

}
class phone3{
    public static synchronized void send(){
        try {
//            TimeUnit.SECONDS.sleep(1);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public static synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}