package testNetwork;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by cashlu on 15/7/7.
 */
public class IpDemo {
    public static void main(String[] args) throws UnknownHostException {
        //创建IP对象，没有构造器函数，所有不用new
        InetAddress localIp = InetAddress.getLocalHost();
        //print the hostname and ip address
        System.out.println(localIp.toString());
        //print the ip address only
        System.out.println("IP Address:" + localIp.getHostAddress());
        //print the hostname only
        System.out.println("Hostname:" + localIp.getHostName());

        //获取指定Hostname的IP
//        InetAddress router = InetAddress.getByName("rMBP.local");
        InetAddress router = InetAddress.getByName("www.baidu.com");
        System.out.println();
        System.out.println(router.getHostName());
        System.out.println(router.getHostAddress());
    }
}
