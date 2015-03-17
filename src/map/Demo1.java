package map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * there is a cat that is a mice and where is the food?
 * 统计上面这句话每个单词出现的次数。
 * 存储到Map中：
 * key: String
 * value: 自定义类型（或者Integer）
 *
 * 思路：
 * 1、遍历容器，在Mao中创建key
 * 2、再次遍历容易，修改count值
 * Created by cashlu on 15/2/3.
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "there is a cat that is a mice and where is the food";
        //首先分割字符串
        String[] strArray = str.split(" ");
        Map<String, Letter> letters = new HashMap<String, Letter>();

        //遍历数组，将其中元素存储进map中
        for (String temp: strArray){
            //首先判断key是否存在，不存在则创建
            if (!letters.containsKey(temp)){
                letters.put(temp, new Letter());
            }

            //创建Letter对象，引用指向HashMap中对于key的value
            //col和letter.get(temp)是同一个对象的不同引用，他们都指向了一个共同的对象。
            //所以下面修改col的count值，相当于修改了map中相应key的对象。
            Letter col = letters.get(temp);
            col.setCount(col.getCount() + 1);

        }

        for (String temp: strArray){
            Letter col = letters.get(temp);
            col.setCount(col.getCount() + 1);
        }

        //输出Map的内容
        Set<String> keys = letters.keySet();
        for (String key: keys){
            Letter col = letters.get(key);
            System.out.println(key + " ---- " + col.getCount());
        }
    }

}
