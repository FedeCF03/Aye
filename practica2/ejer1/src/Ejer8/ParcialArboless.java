
public class ParcialArboless {
    /*
     * Escribir en una clase ParcialArboles el método público con la siguiente
     * firma:
     * public BinaryTree<?> sumAndDif(BinaryTree<Integer> arbol)
     * El método recibe un árbol binario de enteros y devuelve un nuevo árbol que
     * contenga en cada
     * nodo dos tipos de información:
     * ● La suma de los números a lo largo del camino desde la raíz hasta el nodo
     * actual.
     * ● La diferencia entre el número almacenado en el nodo original y el número
     * almacenado en el
     * nodo padre.
     */
    public BinaryTree<SumAndDiff> sum(BinaryTree<Integer> ab) {
        BinaryTree<SumAndDiff> res = new BinaryTree<SumAndDiff>();
        sum(ab, res, 0, 0);
        return res;
    }

    private void sum(BinaryTree<Integer> ab, BinaryTree<SumAndDiff> res, int sum, int resta) {
        SumAndDiff data = new SumAndDiff(sum + ab.getData(), ab.getData() - resta);
        res.setData(data);
        if (ab.hasLeftChild()) {
            res.addLeftChild(new BinaryTree<SumAndDiff>());
            sum(ab.getLeftChild(), res.getLeftChild(), sum + ab.getData(), ab.getData());
        }
        if (ab.hasRightChild()) {
            res.addRightChild(new BinaryTree<SumAndDiff>());
            sum(ab.getRightChild(), res.getRightChild(), sum + ab.getData(), ab.getData());
        }
    }

}
