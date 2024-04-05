import java.util.ArrayList;

public class TestArrayList {

    public static void main(int[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : args) {
            list.add(i);
        }

        System.out.println(list);

    }
}
