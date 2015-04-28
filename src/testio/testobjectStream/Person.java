package testio.testobjectStream;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by cashlu on 15/4/28.
 */
//ObjectOutputStream.writeObject()要求传入的Object对象必须实现Serializable接口，详见文档。
public class Person implements Serializable {
    /*
    serialVersionUID是Serializable接口定义的一个变量，用于类对象的序列化。
    Java通过serialVersionUID来判断两个对象的类是否是同一个。
    如果这里不指定这个变量，那么如果Person类重新编译，已经存入文件的对象将不能读取，
    因为读取时依托Person类，创建对象时用的Person类和读取时用到的Person类不是同一个了。
    所以这里手工的制定UID，那么不论这个类怎么变化，只要核心业务层面的数据结构不变，Java始终会认为是同一个类创建的对象。
     */
    static final long serialVersionUID = 42L;
    private String name;
    private char sex;
    private Date birthday;
    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public Person(String name, char sex, String birthday) {
        this.name = name;
        this.sex = sex;
        try {
            this.birthday = df.parse(birthday);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public char getSex() {
        return sex;
    }

    public String getBirthday() {
        return df.format(birthday);
    }

    //如果一个类重写了toString()方法，那么可以将该类的对象作为参数直接传入打印的方法中。
    public String toString(){
        return name + ":" + sex + ":" + birthday;
    }
}
