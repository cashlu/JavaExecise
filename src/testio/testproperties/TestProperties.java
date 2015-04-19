package testio.testproperties;

import java.util.Properties;
import java.util.Set;

/**
 * Properties对象的键值对，全部为String型。不需泛型。
 * Created by cashlu on 15/4/17.
 */
public class TestProperties {
    public static void main(String[] args) {
        setAndGet();
    }

    /**
     * 设置和获取Properties对象的键值对。
     */
    public static void setAndGet(){
        Properties properties = new Properties();
        properties.setProperty("Lu Man", "31");
        properties.setProperty("Huang Bo", "31");
        properties.setProperty("Zheng Chunyan", "25");
        System.out.println(properties);
        System.out.println("-----通过键获取值-----");
        //如果键不存在，返回null。
        System.out.println(properties.getProperty("Lu Man"));
        //多了一个Default Value的参数，如果通过键没有找到相应的值，那么返回参数中指定的默认值。
        System.out.println(properties.getProperty("LuMan", "Hello"));

        System.out.println("-----遍历对象中的所有键-----");
        //使用Properties类的stringPropertiesNames()方法，返回Set<String>对象，存储了所有的键。
        Set<String> names = properties.stringPropertyNames();
        for (String name : names){
            System.out.println(name + " : " + properties.getProperty(name));
        }
    }

}
