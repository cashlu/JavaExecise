package testCollection;

/**
 * Created by cashlu on 15/1/16.
 */
public class Human {
    private int id;
    private String name;
//    private char sex;
//    private int age;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;

        Human human = (Human) o;

        if (id != human.id) return false;
        if (name != null ? !name.equals(human.name) : human.name != null) return false;

        return true;
    }


    @Override
    public int hashCode() {
        int result = id;
        //这里是一个散列算法，取一个质数31来计算，使得最终的result分布的比较均匀，而不是挤在一堆
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
