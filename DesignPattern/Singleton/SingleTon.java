package DesignPattern.Singleton;

/**
 * 非安全懒汉
 */
public class SingleTon {
    private static SingleTon instance ;
    private SingleTon(){}
    public static SingleTon getInstance(){
        if(instance==null)
            return new SingleTon();
        return instance;
    }
}


/**
 * 安全懒汉
 */
/* public */ class SingleTonLazy {
    private static SingleTonLazy instance ;
    private SingleTonLazy(){}
    public static synchronized SingleTonLazy getInstance(){
        if(instance==null)
            return new SingleTonLazy();
        return instance;
    }
}


/**
 * 安全饿汉
 */
/* public */ class SingleTonHunger {
    private static SingleTonHunger instance = new SingleTonHunger();
    private SingleTonHunger(){}
    public static SingleTonHunger getInstance(){
        return instance;
    }
}


/**
 * 双锁
 */
/* public */ class SingleTonDoubleLock {
    private static SingleTonDoubleLock instance ;
    private SingleTonDoubleLock(){}
    public static SingleTonDoubleLock getInstance(){
        if(instance==null){
            synchronized (SingleTonDoubleLock.class){
                if(instance==null)
                    return new SingleTonDoubleLock();
            }
        }
        return instance;
    }
}

/**
 * 非安全懒汉
 */
/* public */class SingleTonStaticInnerClass {
    private  static  class  SingleTonHolder{
        private static SingleTonStaticInnerClass instance=new SingleTonStaticInnerClass();
    }
    private SingleTonStaticInnerClass(){}
    public static final SingleTonStaticInnerClass getInstance(){
        return SingleTonHolder.instance;
    }
}
