
public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree<Integer> tree = new BinaryTree<>(0);
        BinaryTree<Integer> aux = tree;
        ParcialArboles arboles = new ParcialArboles();

        System.out.println(arboles.esPrefijo(arboles.getArbol(), arboles.getArbol()));
    }

}
