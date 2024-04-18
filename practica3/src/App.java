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
        GeneralTree<Integer> a4 = new GeneralTree<Integer>(5, children3);
        a4.addChild(new GeneralTree<Integer>(355));
        List<GeneralTree<Integer>> childen = new LinkedList<GeneralTree<Integer>>();
        childen.add(a1);
        childen.add(a2);
        childen.add(a3);
        childen.add(a4);
        GeneralTree<Integer> a = new GeneralTree<Integer>(0, childen);
        System.out.println("Datos del Arbol: ");
        System.out.println(a.nivel(0));

    }
}
