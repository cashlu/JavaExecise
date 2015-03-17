package testCollection.testCollection;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 测试HashSet的用法，创建三个Employee对象，将其放入set中。
 * Created by cashlu on 15/1/29.
 */
public class CollectInSet {
    public static void main(String[] args) {
//        String strDate = "2014-12";
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

        Set employeeSet = new HashSet();
        employeeSet.add(simon);
        employeeSet.add(seven);
        employeeSet.add(liang);

        Iterator iterator = employeeSet.iterator();
        while (iterator.hasNext()) {
            Employee e = (Employee) iterator.next();
//            System.out.println(e.getId() + "\t" + e.getName() + "\t" + e.getDepartement() + "\t"
//                    + e.getSalary() + "\t" + format.format(e.getHireDate()));
            System.out.println(e.getId() + "\t" + e.getName() + "\t" + e.getDepartement() + "\t"
                    + e.getSalary() + "\t" + e.getHireDate());
        }


        Map employeeMap = new HashMap();

    }
}
