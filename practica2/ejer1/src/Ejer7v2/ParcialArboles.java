package Ejer7v2;

public class ParcialArboles {
    BinaryTree<Integer> ab;

    public ParcialArboles(BinaryTree<Integer> ab) {
        this.ab = ab;
    }

    private BinaryTree<Integer> busca(BinaryTree<Integer> ab, int num) {
        BinaryTree<Integer> re = null;
        if (ab.getData() == num)
            return ab;
        if (re == null) {
            if (ab.hasLeftChild()) {
                re = busca(ab.getLeftChild(), num);
            }
            if (ab.hasRightChild()) {
                re = busca(ab.getRightChild(), num);
            }
        }
        return re;
    }

    private int cantHijosUnicos(BinaryTree<Integer> a, int c) {
        if (a.isEmpty())
            return 0;
        if (a.hasLeftChild() && !a.hasRightChild())
            c += cantHijosUnicos(a.getLeftChild(), c) + 1;

        if (a.hasRightChild() && !a.hasLeftChild())
            c += cantHijosUnicos(a.getRightChild(), c) + 1;
        return c;
    }

    private boolean isLeafTree(BinaryTree<Integer> ab) {
        int i = -1;
        int d = -1;
        if (ab.hasLeftChild()) {
            i = cantHijosUnicos(ab.getLeftChild(), i);
        }
        if (ab.hasRightChild()) {
            d = cantHijosUnicos(ab.getRightChild(), d);
        }
        if (i > d)
            return true;
        else
            return false;
    }

    public boolean isLeafTree(int num) {
        if (!ab.isEmpty()) {
            BinaryTree<Integer> result = busca(ab, num);
            System.out.println("ss");

            if (!result.isEmpty()) {
                System.out.println(result.getData());

                return isLeafTree(result);
            }

        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println("Test Ejercicio 7");

        BinaryTree<Integer> ab = new BinaryTree<Integer>(2);
        ab.addLeftChild(new BinaryTree<Integer>(7));
        ab.addRightChild(new BinaryTree<Integer>(-5));
        ab.getLeftChild().addLeftChild(new BinaryTree<Integer>(23));
        ab.getLeftChild().addRightChild(new BinaryTree<Integer>(6));
        ab.getLeftChild().getLeftChild().addLeftChild(new BinaryTree<Integer>(-3));
        ab.getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(55));
        ab.getLeftChild().getRightChild().addRightChild(new BinaryTree<Integer>(11));
        ab.getRightChild().addLeftChild(new BinaryTree<Integer>(19));
        ab.getRightChild().getLeftChild().addRightChild(new BinaryTree<Integer>(4));
        ab.getRightChild().getLeftChild().getRightChild().addLeftChild(new BinaryTree<Integer>(18));

        ParcialArboles parcialArb = new ParcialArboles(ab);
        System.out.println("Resultado=" + parcialArb.isLeafTree(7));

    }
}