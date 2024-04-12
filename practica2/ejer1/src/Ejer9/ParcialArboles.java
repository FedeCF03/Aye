public class ParcialArboles {
    public BinaryTree<sumAndDiff> sumAndDif(BinaryTree<Integer> arbol) {
        if (arbol.isEmpty()) {
            return new BinaryTree<sumAndDiff>();
        }
        BinaryTree<sumAndDiff> res = new BinaryTree<sumAndDiff>();
        sumAndDiff2(arbol, res, 0, 0);
        return res;

    }

}

private void sumAndDiff2(BinaryTree<Integer> arbol, BinaryTree<sumAndDiff> res, int sum, int dif) {
    sum += arbol.getData();
    sumAndDiff dataSet = new sumAndDiff(sum, sum - dif);
    res.setData(dataSet);
    if (arbol.hasLeftChild()) {
        res.addLeftChild(new BinaryTree<sumAndDiff>());
        sumAndDiff2(arbol.getLeftChild(), res.getLeftChild(), sum, arbol.getData());
    }
    if (arbol.hasRightChild()) {
        res.addRightChild(new BinaryTree<sumAndDiff>());
        sumAndDiff2(arbol.getRightChild(), res.getRightChild(), sum, arbol.getData());
    }

}