package testCollection;

/**
 * 节点类
 * Created by cashlu on 14/12/30.
 */
public class Node {
    /*
    一个节点有三个属性，节点的物件对象、上一个节点、下一个节点。
     */
    Object obj;
    Node previous;
    Node next;

    /**
     * 空构造器
     */
    public Node() {
    }

    /**
     * 构造器方法
     *
     * @param next     下一个对象
     * @param obj      当前节点存储的对象
     * @param previous 上一个节点
     */
    public Node(Node next, Object obj, Node previous) {
        this.next = next;
        this.obj = obj;
        this.previous = previous;
    }

    public Node getNext() {
        return next;
    }

    public Object getObj() {
        return obj;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
