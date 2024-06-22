import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public int resolver(GeneralTree<Integer> arbol) {
        int num = 0;
        if (!arbol.isEmpty()) {
            num = resolver(arbol, num);
        }

        return num;
    }

    private int resolver(GeneralTree<Integer> ab, int num) {
        Queue<GeneralTree<Integer>> q = new Queue<GeneralTree<Integer>>();
        q.enqueue(ab);
        q.enqueue(null);
        int num_aux = 1;

        while (!q.isEmpty()) {
            GeneralTree<Integer> aux = q.dequeue();

            if (aux != null) {
                num_aux *= aux.getData();
                for (GeneralTree<Integer> a : aux.getChildren()) {
                    q.enqueue(a);
                }
            } else if (!q.isEmpty()) {
                num = num_aux;
                num_aux = 1;
            }
        }
        return num;
    }

    public int resolver2(GeneralTree<Integer> arbol) {
        sumas sums = new sumas(0, 0, 0);
        if (!arbol.isEmpty()) {
            sums = resolver2(arbol, sums);

            if (sums.sumas % 2 == 0) {
                return sums.positiva;
            } else
                return sums.negativa;

        }

        return 0;
    }

    private void resolver2(GeneralTree<Integer> arbol, sumas sums) {
        for (GeneralTree<Integer> a : arbol.getChildren) {
            resolver2(a, sums);
        }
        sums.sumas += a.getData;
        if (a.getData > 0)
            sums.positiva += a.getData;
        else
            sums.negativa += a.getData;

    }

}
