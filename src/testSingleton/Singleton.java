package testSingleton;

/**
 * 测试设计模式的单例模式。
 * 所谓“单例模式”，是指在它的核心结构中只包含一个被称为单例类的特殊类。
 * 通过单例模式可以保证系统中一个类只有一个实例而且该实例易于外界访问，
 * 从而方便对实例个数的控制并节约系统资源。在系统中这个类的对象只能存在一个。
 * <p/>
 * -----单例模式保证了对象的唯一性-----
 * <p/>
 * 要求：
 * 1、类不能被外部实例化。
 * 2、存在一个该类的实例，由该类自己实例化。
 * 3、外部可以访问这个实例。
 * <p/>
 * 解决思路：
 * 1、构造函数私有化。
 * 2、类内部做对象的创建。
 * 3、创建一个访问该对象的方法。
 * <p/>
 * 两种模式的区别：
 * 饿汉模式：SingleHungry类一进内存，就在堆内存中创建了对象。
 * 懒汉模式：SingleLazy类进入内存时，并没有创建对象，直到getInstance()方法被调用，才创建。
 * <p/>
 * Created by cashlu on 15/2/5.
 */


//饿汉模式，先初始化对象。(建议使用，线程安全)
class SingleHungry {
    //构造函数私有化
    private SingleHungry() {
    }

    //创建对象
    private static SingleHungry s = new SingleHungry();

    //创建一个外部访问该实例的方法，因为该类在外部不能被实例化，那么必须要用类名调用该类的方法。
    //所以该方法必须是静态方法，加static修饰。
    //该静态方法内要访问该类的成员变量s，所以s也必须是静态的。
    public static SingleHungry getInstance() {
        return s;
    }
}

//以下是“懒汉模式”，先判断对象是否存在，不存在先初始化对象，再返回。
//懒汉模式有可能造成多线程问题。解决的话需要双重验证（推荐），或者同步函数。
class SingleLazy {
    private SingleLazy() {
    }

    //声明对象为null
    private static SingleLazy s = null;

    public static SingleLazy getInstance() {
        if (s == null) {
            s = new SingleLazy();
        }
        return s;
    }
}


public class Singleton {
    public static void main(String[] args) {
        //这里不是在外部创建了Single类的实例，而是创建了一个该对象的引用。（理解为指针）
        SingleHungry s = SingleHungry.getInstance();
        SingleLazy s1 = SingleLazy.getInstance();
    }
}
