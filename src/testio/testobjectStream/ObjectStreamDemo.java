package testio.testobjectStream;

import java.io.*;

/**
 * 对象的持久化。
 * 将对象存储进文件，再从文件中读取。
 * Created by cashlu on 15/4/28.
 */
public class ObjectStreamDemo {
    public static void main(String[] args) {
        File objFile = new File("/Users/cashlu/Desktop/objFile.txt");
        Person p = new Person("Simon Lo", 'M', "1984-01-07");
        writeObj(objFile, p);

        //因为readObj()返回的是Object对象，所以要强制类型转换。
        Person p1 = (Person) readObj(objFile);
        System.out.println(p1.getName());
        System.out.println(p1.getSex());
        System.out.println(p1.getBirthday());
        System.out.println(p1.equals(p));   //返回false，因为虽然成员变量相等，但毕竟还是两个对象。
        System.out.println(p);
    }

    /**
     * 将对象写入文件中（对象的持久化），这样即使程序终止，对象依旧存在。
     *
     * @param objFile 要存储对象的文件。
     * @param obj     要存储的对象。
     */
    public static void writeObj(File objFile, Object obj) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(objFile));
            //ObjectOutputStream.writeObject()要求传入的Object对象必须实现Serializable接口，详见文档。
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 从文件中读取对象。
     *
     * @param objFile 存储对象的文件。
     * @return 返回一个Object对象。因为不确定文件存储的对象具体是什么，所以用所有对象的超类Object。
     */
    public static Object readObj(File objFile) {
        ObjectInputStream ois = null;
        Object obj = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(objFile));
            obj = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return obj;
    }
}
