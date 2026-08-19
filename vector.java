import java.util.Vector;

public class vector {
    public static void main(String[] args) {

        Vector<Object> v = new Vector<>();

        v.add(10);
        v.add(20);

        v.add('A');
        v.add('B');

        v.add(10.5f);
        v.add(20.5f);

        System.out.println(v);
	}
}