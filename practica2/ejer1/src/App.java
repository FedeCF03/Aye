
public class App {
    public static void main(String[] args) throws Exception {

        BinaryTree<Integer> ab = new BinaryTree<Integer>(0);
        BinaryTree<Integer> ab2 = ab;
        ab.addLeftChild(new BinaryTree<Integer>(4));
        ab.addRightChild(new BinaryTree<Integer>(5));

        ProfundidadDeArbolBinario pf = new ProfundidadDeArbolBinario();
        pf.root = ab;
        System.out.println(pf.sumaElementosProfundidad(1));
    }

}
