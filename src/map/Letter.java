package map;

/**
 * Created by cashlu on 15/2/3.
 */
public class Letter {
    private String name;
    private int count;

    public Letter() {
    }

    public Letter(int count, String name) {

        this.count = count;
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
