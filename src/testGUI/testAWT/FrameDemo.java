package testGUI.testAWT;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 创建GUI流程思路：
 * 1、创建Frame对象(设定可见、尺寸、初始位置、标题等)
 * 2、设置Frame的布局管理器
 * 3、创建其他元素对象，例如Button（设定文字等）
 * 5、放置其他元素到Frame
 *
 * 事件监听机制的元素：
 * 1、事件源
 * 2、事件
 * 3、监听器
 * 4、事件处理方式
 *
 * 事件源：awt或者swing包中的图形界面组件。
 * 时间：每一个事件源都有自己的对应事件和共性事件。
 * 监听器：将所有可以触发某一事件的动作都已经封装到了监听器中。用于监视这些动作的触发。
 *
 * Created by cashlu on 15/6/10.
 */
public class FrameDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("My AWT Frame");
        frame.setVisible(true);
        frame.setLayout(new FlowLayout());
        frame.setSize(500, 300);
        frame.setLocation(500, 300);
        Button b = new Button("按钮");
        frame.add(b);
        System.out.println("Test the AWT Frame");

        //开始创建监听器，以便可以关闭窗口
        frame.addWindowListener(new MyWindow());
        /*
        使用匿名内部类来创建一个按钮的监听器。
        Listen the object b, what is a Button object. when b was pushed, print a String to the terminal.
         */
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Push");
            }
        });


    }
}
