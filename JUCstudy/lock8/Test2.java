package JUCstudy.lock8;
import java.util.concurrent.TimeUnit;

/**
 * 3、增加非同步方法，由B运行，先执行哪个？
 * A和main延迟相同时间，则随机；A延迟更久，则先B
 * 4、分对象锁，执行哪个?
 * A和main延迟相同时间，则随机；A延迟更久，则先B
 */
public class Test2 {
    public static void main(String[] args) {
        phone2 phone3 = new phone2();
        phone2 phone4 = new phone2();
        new Thread(()->{
            phone3.send();
            },"A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
//            phone3.hello();
            phone4.call();
            },"B").start();

    }

}
class phone2{
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

    public void hello(){
        System.out.println("hello");
    }
}