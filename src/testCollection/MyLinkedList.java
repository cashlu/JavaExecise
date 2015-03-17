package testCollection;

/**
 * 自己实现链表
 * 目前该程序有一个bug未解决，如果链表中只有一个元素，那么删除这个元素会报错。以后去完善remove()方法。
 * Created by cashlu on 14/12/30.
 */
public class MyLinkedList {
    /*
    fisrt 第一个链表的第一个节点
    last 链表的最后一个节点
    size 链表的长度
     */
    private Node first;
    private Node last;
    private int size;

    /**
     * 项链表中添加元素
     *
     * @param obj 向链表中添加的对象
     */
    public void add(Object obj) {
        /*
        first代表链表的第一个节点，如果为空，代表该链表为空，那么add的这个对象就是链表的第一个对象。
         */
        Node n = new Node();
        if (first == null) {    //判断链表是否为空
            n.setObj(obj);
            n.setPrevious(null);
            n.setNext(null);

            first = n;
            last = n;
        } else {
            n.setObj(obj);
            n.setPrevious(last);
            n.setNext(null);

            last.setNext(n);
            last = n;
        }
        size++;
    }

    /**
     * 重载了add()方法，向链表指定的位置插入节点。
     * @param index 要插入的索引位置
     * @param obj 要插入的对象
     */
    public void add(int index, Object obj) {
        Node n = new Node();
        n.setObj(obj);
        Node temp = node(index);
        //判断指定的位置是否是空，如果为空，代表是要向链表的最后追加节点，直接调用add(Object obj)方法。
        if (temp != null) {
            if (index != 0) {
                Node up = temp.getPrevious();
                up.setNext(n);
                n.setPrevious(up);
                n.setNext(temp);
                temp.setPrevious(n);
            }else {
                first = n;
                n.setNext(temp);
                n.setPrevious(null);
                temp.setPrevious(n);

            }
            size++;
        } else {
            this.add(obj);
        }
    }

    /**
     * 获取某特性index的Node对象，这个方法是为了代码的良好复用，为其他方法服务。
     *
     * @param index 要获取的索引
     * @return 返回Node对象（有可能返回的Node对象是null）
     */
    public Node node(int index) {
        Node temp = null;
        if (first != null) {
            temp = first;
            //这里i < index，而不是i <= index，是因为当index == 0的时候，上面的if判断里，已经做了temp = first的赋值。
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        return temp;
    }

    /**
     * 删除特定index的节点
     *
     * @param index 要删除的节点的索引
     */
    public void remove(int index) {
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null) {
            if (index != this.size - 1) {
                Node up = temp.previous;
                Node down = temp.next;
                up.next = down;
                down.previous = up;
            } else {
                Node up = temp.previous;
                Node down = null;
                up.next = null;
            }
            size--;
        }
    }

    public int getSize() {
        return size;
    }

    /**
     * 检查index是否越界
     *
     * @param index 索引值
     */
    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                System.out.println("index越界啦");
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取某一个index的节点中所存储的对象
     *
     * @param index 要获取的索引值
     * @return 返回特定Node中存储的Object对象
     */
    public Object get(int index) {
        rangeCheck(index);
        Node temp = node(index);
        if (temp != null) {
            return temp.obj;
        } else {
            return null;
        }
    }

    /**
     * 链表元素、索引及长度的输出，便于测试。
     */
    public void printList() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(i + ":" + this.get(i) + "\t\t");
        }
        System.out.println();
        System.out.println("链表长度：" + this.getSize());
        System.out.println("---------------");
    }


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add("Hello");
        list.add("Simon");
        list.add("Lo");
        list.printList();
        list.add(0, "Good");
        list.printList();
        list.add(0, "Great");
        list.printList();


//        list.remove(2);
//        for (int i = 0; i < list.size; i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(list.getSize());
//        System.out.println("---------------");
//
//        list.remove(1);
//        for (int i = 0; i < list.size; i++) {
//            System.out.println(list.get(i));
//        }
//        System.out.println(list.getSize());
//        System.out.println("---------------");

    }
}
