import java.util.LinkedList;
import java.util.List;

public class Caminos {
    GeneralTree<Integer> b;

    public Caminos(GeneralTree<Integer> b) {
        this.b = b;
    }

    private List<Integer> caminoAHojaMasLejana(List<Integer> l, GeneralTree<Integer> ab, List<Integer> aux, int n) {
        List<GeneralTree<Integer>> childs = ab.getChildren();
        if (n > aux.size() || (n == aux.size() && ab.hasChildren())) {
            {
                System.out.println();
                System.out.println(n + " nivel" + ab.getData() + " aux size" + aux.size());

                aux.add(ab.getData());

            }

        }
        n = n + 1;
        for (GeneralTree<Integer> child : childs) {
            aux = caminoAHojaMasLejana(l, child, aux, n);
            if (aux.size() > l.size()) {
                l = aux;
            }
        }
        return l;
    }

    public List<Integer> caminoAHojaMasLejana() {
        if (!(this.b.isEmpty()) && !(this.b == null)) {
            List<Integer> result = new LinkedList<Integer>();
            return caminoAHojaMasLejana(new LinkedList<Integer>(), this.b, new LinkedList<Integer>(), 0);
        }
        return null;
    }
}
