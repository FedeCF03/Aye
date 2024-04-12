public class ProfundidadDeArbolBinario {
    BinaryTree<Integer> root;

    public int sumaElementosProfundidad(int p) {
        return sumaElementosProfundidad(p, this.root, 0, 0);
    }

    private int sumaElementosProfundidad(int p, BinaryTree<Integer> tree, int pv, int result) {
        if (pv == p) {
            return tree.getData();
        } else {
            pv++;
            if (tree.hasLeftChild()) {
                result += sumaElementosProfundidad(p, tree.getLeftChild(), pv, result);
            }
            if (tree.hasRightChild()) {
                result += sumaElementosProfundidad(p, tree.getRightChild(), pv, result);
            }
            return result;
        }

    }

}
