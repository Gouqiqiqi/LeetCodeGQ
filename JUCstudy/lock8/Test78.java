package JUCstudy.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 7、普通和静态同步方法，单对象，先执行哪个？
 * 8、普通和静态同步方法，双对象，先执行哪个？
 * 静态和同步锁的不是一个对象。B
 */
public class Test78 {
    public static void main(String[] args) {
        phone4 phone7 = new phone4();
        phone4 phone8 = new phone4();
        new Thread(()->{
            phone7.send();
        },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            phone8.call();
//            phone4.call();
        },"B").start();

    }

}
class phone4{
    public static synchronized void send(){
        try {
//            TimeUnit.SECONDS.sleep(1);
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }
    public  synchronized void call(){
        System.out.println("打电话");
    }

}