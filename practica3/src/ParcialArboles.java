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
    private static void resolver(GeneralTree<Integer> arbol, Dato dat, Integer n) {
        if (arbol.getData() == 1) {
            dat.getL().add(arbol.getData());

        }
        int res = (arbol.getData() * n);
        System.out.println(res);
        dat.incAuxC(res);
        System.out.println(dat.getAuxC() + " aux ");

        if (dat.getAuxC() > dat.getMaxC()) {
            System.err.println("entre");
            dat.setMaxC(dat.getAuxC());
            dat.getMaxL().clear();

            dat.getMaxL().addAll(dat.getL());
        }
        n++;
        List<GeneralTree<Integer>> child = arbol.getChildren();
        for (GeneralTree<Integer> c : child) {
            resolver(c, dat, n);
        }
        dat.decAuxC(arbol.getData() * (n - 1));
        if (!dat.getL().isEmpty())
            dat.getL().remove(dat.getL().size() - 1);

    }

    public static List<Integer> resolver(GeneralTree<Integer> arbol) {
        Dato dat = new Dato();
        if (!arbol.isEmpty() && arbol != null) {
            if (arbol.getData() == 1)
                System.err.println("entre");
            resolver(arbol, dat, 0);
        }
        return dat.getMaxL();
    }

    public static boolean resolver2(GeneralTree<Integer> arbol, boolean res) {

        return res;
    }

    public static <Integer> boolean resolver2(GeneralTree<Integer> arbol) {
        boolean res = true;
        int cantNivel = 0;
        int antNivel = 0;
        List<Integer> result = new LinkedList<Integer>();
        GeneralTree<Integer> tree_aux;
        GeneralTree<Integer> centinela = new GeneralTree<Integer>();
        centinela.setData(-1);
        int cen = 0;
        Queue<GeneralTree<Integer>> queue = new Queue<GeneralTree<Integer>>();
        queue.enqueue(centinela);

        queue.enqueue(arbol);
        while (!queue.isEmpty() && res) {

            tree_aux = queue.dequeue();
            if (tree_aux.getData() == -1) {
                cen++;
                if (cen == 2) {
                    cen = 0;
                    if (cantNivel - 1 == antNivel) {
                        antNivel = cantNivel;
                    } else {
                        res = false;
                    }
                    cantNivel = 0;
                }
            } else {
                cantNivel++;
                List<GeneralTree<Integer>> children = tree_aux.getChildren();
                for (GeneralTree<Integer> child : children) {
                    queue.enqueue(child);
                }
                queue.enqueue(centinela);
            }
        }
        return res;
    }
}
