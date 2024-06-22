public class Prefijo {

    public boolean EsPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {
        if (arbol1.isEmpty() || arbol2.isEmpty())
            return arbol1.isEmpty() && arbol2.isEmpty(); // El primer if verifica si al menos uno de los arboles esta
                                                         // vacio, si es asi, pregunta si ambos arboles estan vacios, si

        return EsPrefijo(arbol1, arbol2, true);
    }

    private boolean EsPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2, boolean res) {
        if (arbol1.getData() == arbol2.getData()) {
            if (arbol1.hasLeftChild()) {
                if (arbol2.hasLeftChild()) {
                    res = res && EsPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild(), res);

                } else
                    return false;
            }

            if (arbol1.hasRightChild()) {
                if (arbol2.hasRightChild()) {
                    res = res && EsPrefijo(arbol1.getRightChild(), arbol2.getRightChild(), res);
                } else
                    return false;
            }
            return res;
        } else
            return false;
    }

}
