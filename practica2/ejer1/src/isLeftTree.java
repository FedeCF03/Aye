
public class isLeftTree {
    BinaryTree<Integer> b;

    public isLeftTree(BinaryTree<Integer> b) {
        this.b = b;
    }

    private BinaryTree<Integer> search(int num, BinaryTree<Integer> ab) {
        if (ab.getData() == num)
            return ab;
        BinaryTree<Integer> res = new BinaryTree<Integer>();
        if (ab.hasLeftChild()) {
            res = search(num, ab.getLeftChild());
        }
        if ((ab.hasRightChild()) && (res.isEmpty())) {
            res = search(num, ab.getRightChild());
        }
        return res;
    }

    @SuppressWarnings("unchecked")
    private boolean isLeftwhile(BinaryTree<Integer> b) {
        Queue q = new Queue<BinaryTree<Integer>>();
        int ant = 1;
        int act = 0;
        BinaryTree<Integer> aux;
        q.enqueue(b);
        q.enqueue(null);
        while (!q.isEmpty()) {
            aux = (BinaryTree<Integer>) q.dequeue();
            if (aux != null) {

                if (aux.hasLeftChild()) {
                    if (!aux.getLeftChild().isLeaf())
                        q.enqueue(aux.getLeftChild());
                    act++;
                }
                if (aux.hasRightChild()) {
                    if (!aux.getRightChild().isLeaf())
                        q.enqueue(aux.getRightChild());
                    act++;
                }
            } else {
                if (ant + 1 == act) {
                    ant = act;
                    act = 0;
                    if (q.size() > 1)
                        q.enqueue(null);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isLeft(int num) {
        BinaryTree<Integer> ab = search(num, b);
        if (!ab.isEmpty() && ab != null) {
            return isLeftwhile(ab);
        }

        return false;
    }

}
