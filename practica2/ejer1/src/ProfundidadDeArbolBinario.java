public class ProfundidadDeArbolBinario {
    BinaryTree<Integer> root = new BinaryTree<Integer>(1);

    public int sumaeProfundidad(int p) {
        return sumaeProfundidad(root, p);
    }

    public int sumaeProfundidad(BinaryTree<Integer> tree, int p) {
        if (p == 0) {
            return tree.getData();
        }
        if (0 < p) {
            if (tree.hasLeftChild()) {
                return sumaeProfundidad(tree.getLeftChild(), p - 1);
            }
            if (tree.hasRightChild()) {
                return sumaeProfundidad(tree.getRightChild(), p - 1);
            }
        }
        return 0;
    }

}
