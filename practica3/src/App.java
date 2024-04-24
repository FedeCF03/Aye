import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        GeneralTree<Integer> a1 = new GeneralTree<Integer>(1);
        List<GeneralTree<Integer>> children2 = new LinkedList<GeneralTree<Integer>>();
        children2.add(new GeneralTree<Integer>(21));
        children2.add(new GeneralTree<Integer>(22));
        children2.add(new GeneralTree<Integer>(23));
        GeneralTree<Integer> a2 = new GeneralTree<Integer>(2, children2);
        List<GeneralTree<Integer>> children3 = new LinkedList<GeneralTree<Integer>>();
        children3.add(new GeneralTree<Integer>(31));
        children3.add(new GeneralTree<Integer>(32));
        GeneralTree<Integer> a3 = new GeneralTree<Integer>(3, children3);
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);
        childen.add(a2);
        childen.add(a3);
        GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
        Caminos ca = new Caminos(a);
        List<Integer> l = ca.caminoAHojaMasLejana();
        System.out.println("sali");
        for (Integer d : l) {
            System.out.println(d);
        }
    }
}
