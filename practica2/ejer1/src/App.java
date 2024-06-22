import java.util.ArrayList;
import java.util.LinkedList;

import Ejer7v2.ParcialArboles;

public class App {
    public static void main(String[] args) throws Exception {
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
        ab.entreNiveles(0, 4);

        isLeftTree parcialArb = new isLeftTree(ab);
        System.out.println("Resultado=" + parcialArb.isLeft(7));
        System.out.println("Resultado=" + parcialArb.isLeft(2));
        System.out.println("Resultado=" + parcialArb.isLeft(-5));
        System.out.println("Resultado=" + parcialArb.isLeft(19));
        System.out.println("Resultado=" + parcialArb.isLeft(-3));

    }
}
