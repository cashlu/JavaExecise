package testCollection.testCollection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 将Employee对象的不同属性放入Map中，然后将Map放入List中。
 * Created by cashlu on 15/1/30.
 */
public class CollectInList {
    public static void main(String[] args) {
        DateFormat format = new SimpleDateFormat("yyyy-MM");
        Employee simon = null;
        Employee seven = null;
        Employee liang = null;
        try {
            simon = new Employee("项目部", 001, format.parse("2011-11"), "Simon Lo", 3000);
            seven = new Employee("项目部", 002, format.parse("2012-06"), "Seven Huang", 4000);
            liang = new Employee("技术部", 003, format.parse("2014-12"), "Liang Wei", 5000);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Map simonMap = new HashMap();
        Map sevenMap = new HashMap();
        Map liangMap = new HashMap();

        simonMap.put("id", simon.getId());
        simonMap.put("name", simon.getName());
        simonMap.put("department", simon.getDepartement());
        simonMap.put("hireDate", simon.getHireDate());
        simonMap.put("salary", simon.getSalary());

        sevenMap.put("id", seven.getId());
        sevenMap.put("name", seven.getName());
        sevenMap.put("department", seven.getDepartement());
        sevenMap.put("hireDate", seven.getHireDate());
        sevenMap.put("salary", seven.getSalary());

        liangMap.put("id", liang.getId());
        liangMap.put("name", liang.getName());
        liangMap.put("department", liang.getDepartement());
        liangMap.put("hireDate", liang.getHireDate());
        liangMap.put("salary", liang.getSalary());

        //List<Map>代表泛型，表示list中只能存储Map对象
        List<Map> list = new ArrayList<Map>();
        list.add(simonMap);
        list.add(sevenMap);
        list.add(liangMap);

        for (int i = 0; i < list.size(); i++) {
            Map tempMap = list.get(i);
            System.out.println(tempMap.get("id") + "\t" + tempMap.get("name") + "\t" +
                                tempMap.get("department") + "\t" + tempMap.get("salary")
                                + "\t" + tempMap.get("hireDate"));

        }

    }
}
