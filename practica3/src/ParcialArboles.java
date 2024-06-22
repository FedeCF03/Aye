import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParcialArboles {

    GeneralTree<Integer> ab;

    public ParcialArboles(GeneralTree<Integer> ab) {
        this.ab = ab;
    }

    /*
     * private boolean esDeSeleccion(GeneralTree<Integer> arbol, boolean result) {
     * if (!arbol.isLeaf()) {
     * 
     * List<GeneralTree<Integer>> l = arbol.getChildren();
     * int min = 9999;
     * for (GeneralTree<Integer> child : l) {
     * if (result) {
     * 
     * result = esDeSeleccion(child, result);
     * min = Math.min(min, child.getData());
     * }
     * }
     * if (min == arbol.getData() && result) {
     * System.out.println("min" + min);
     * System.out.println(arbol.getData());
     * 
     * return true;
     * }
     * System.out.println(arbol.getData());
     * 
     * return false;
     * 
     * }
     * return true;
     * }
     * 
     * public boolean esDeSeleccion(GeneralTree<Integer> arbol) {
     * return esDeSeleccion(arbol, true);
     * }
     */

    public static boolean resolver2(GeneralTree<Integer> arbol, boolean res) {

        return res;
    }

    public boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        if (!arbol.isEmpty() && arbol != null)
            return esDeSeleccion(arbol, true);
        return false;
    }

    private boolean esDeSeleccion(GeneralTree<Integer> arbol, boolean result) {
        int min = 9999;

        if (!arbol.isLeaf() && result) {

            for (GeneralTree<Integer> b : arbol.getChildren()) {
                result = esDeSeleccion(b, result);
                min = Math.min(b.getData(), min);
            }
            if (min == arbol.getData() && result) {
                result = true;
            } else
                result = false;
            System.err.println(result);
        }
        return result;
    }

    public List<Integer> resolver(GeneralTree<Integer> arbol) {
        max m = new max();
        resolver(arbol, m, 0);

        return m.res;
    }

    private void resolver(GeneralTree<Integer> a, max m, int n) {
        m.aux_max += ab.getData() * n;
        if (a.getData() == 1) {
            m.aux.add(a.getData());
        }
        for (GeneralTree<Integer> b : a.getChildren()) {
            resolver(b, m, n + 1);
        }
        if (m.aux_max > m.max) {
            m.max = m.aux_max;
            m.res.clear();
            m.res.addAll(m.aux);
        }
        m.aux_max -= ab.getData() * n;
        if (m.aux.size() > 1)
            m.aux.remove(m.aux.size() - 1);
    }

}
