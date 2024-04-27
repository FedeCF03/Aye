import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(1));
        children2.add(new GeneralTree<Integer>(0));
        children2.add(new GeneralTree<Integer>(0));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(1, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(0));
        children3.add(new GeneralTree<Integer>(1));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(0, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);
        childen.add(a2);
        childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(1, childen);
        ParcialArboles pa = new ParcialArboles(a);
        System.out.println(ParcialArboles.resolver(a));

    }
}
