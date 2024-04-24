import java.util.List;

public class ParcialArboles {
    private boolean esDeSeleccion(GeneralTree<Integer> arbol, int anterior, boolean result) {
        int c = 0;
        if (arbol.getData() == anterior) {
            c++;
        }

        List<GeneralTree<Integer>> childs = arbol.getChildren();
        for (GeneralTree<Integer> child : childs) {
            result = esDeSeleccion(child, arbol.getData(), result);
            if (result) {
                c++;
            }
        }
        if (c != 0) {
            return true;
        }
        return false;

    }

    public static boolean esDeSeleccion(GeneralTree<Integer> arbol) {
        return esDeSeleccion(arbol);
    }

}
