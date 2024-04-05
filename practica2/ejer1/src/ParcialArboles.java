public class ParcialArboles {
    private BinaryTree<Integer> arbol = new BinaryTree<>();

    public ParcialArboles() {
        BinaryTree<Integer> aux = new BinaryTree<>();
        BinaryTree<Integer> aux2 = new BinaryTree<>();

        this.arbol.setData(2);
        this.arbol.addLeftChild(new BinaryTree<>(7));
        this.arbol.addRightChild(new BinaryTree<>(-5));
        aux = this.arbol.getLeftChild();
        aux.addLeftChild(new BinaryTree<>(23));
        aux.addRightChild(new BinaryTree<>(6));
        aux2 = aux.getRightChild();

        aux = aux.getLeftChild();
        aux.addLeftChild(new BinaryTree<>(4));
        aux2.addLeftChild(new BinaryTree<>(5));
        aux2.addRightChild(new BinaryTree<>(8));
        aux = this.arbol.getRightChild();
        aux.addLeftChild(new BinaryTree<>(9));
        aux = aux.getLeftChild();
        aux.addRightChild(new BinaryTree<>(10));
        aux = aux.getRightChild();
        aux.addLeftChild(new BinaryTree<>(11));
    }

    public BinaryTree<Integer> buscarRaiz(int num, BinaryTree<Integer> arbol) {
        if (arbol == null) {
            return null;
        }
        if (arbol.getData() == num) {
            return arbol;
        } else {
            BinaryTree<Integer> left = buscarRaiz(num, arbol.getLeftChild());
            if (left != null) {
                return left;
            }
            return buscarRaiz(num, arbol.getRightChild());
        }
    }

    public boolean isLeftTree(int num) {
        BinaryTree<Integer> raiz = buscarRaiz(num, this.arbol);
        int izq = 0 + contarIzquierda(raiz, 0);
        int der = 0 + contarDerecha(raiz, 0);
        ;

        if (izq > der) {
            return true;
        } else {
            return false;
        }

    }

    public int contarDerecha(BinaryTree<Integer> raiz, int der) {
        if (raiz.hasRightChild()) {
            der += contar(raiz.getRightChild(), der);
        } else {
            der = -1;
        }
        return der;
    }

    public int contarIzquierda(BinaryTree<Integer> raiz, int izq) {
        if (raiz.hasLeftChild()) {
            izq += contar(raiz.getLeftChild(), izq);
        } else {
            izq = -1;
        }
        return izq;
    }

    public int contar(BinaryTree<Integer> raiz, int c) {
        if (raiz.hasLeftChild() && raiz.hasRightChild()) {
            return 0;
        }

        if (raiz.hasLeftChild()) {
            c += 1 + contar(raiz.getLeftChild(), c);
        }
        if (raiz.hasRightChild()) {
            c += 1 + contar(raiz.getRightChild(), c);
        }
        return c;
    }

    public boolean checkPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2, boolean result) {
        if (arbol.getData() == arbol2.getData()) {
            if (arbol.hasLeftChild()) {
                if (arbol2.hasLeftChild()) {
                    result = checkPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild(), result);
                } else {
                    return false;
                }
            }
            if (arbol.hasRightChild()) {
                if (arbol2.hasRightChild()) {
                    result = checkPrefijo(arbol1.getLeftChild(), arbol2.getLeftChild(), result);
                } else
                    return false;
            }
        } else {
            return false;
        }
        if (result) {
            return true;
        } else {
            return false;
        }
    }

    public boolean esPrefijo(BinaryTree<Integer> arbol1, BinaryTree<Integer> arbol2) {

        boolean result = true;
        checkPrefijo(arbol1, arbol2, result);
        return result;
    }

    public BinaryTree<Integer> getArbol() {
        return arbol;
    }

}
