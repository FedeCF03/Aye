import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {

	private T data;
	private BinaryTree<T> leftChild;
	private BinaryTree<T> rightChild;

	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * 
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * 
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty() {
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}

	public boolean hasLeftChild() {
		return this.leftChild != null;
	}

	public boolean hasRightChild() {
		return this.rightChild != null;
	}

	@Override
	public String toString() {
		return this.getData().toString();
	}

	public int contarHojas() {
		int count = 0;
		if (this.isEmpty()) {
			return 0;
		} else if (this.isLeaf()) {
			return 1;
		} else {
			if (hasLeftChild())
				count += getLeftChild().contarHojas();

			if (hasRightChild())
				count += getRightChild().contarHojas();
		}
		return count;
	}

	public void recorrer() {
		// TODO
		if (this.isEmpty()) {
			return;
		}
		System.out.println(this.getData());
		if (this.hasLeftChild()) {
			this.getLeftChild().recorrer();
		}
		if (this.hasRightChild()) {
			this.getRightChild().recorrer();
		}

	}

	public BinaryTree<T> espejo() {
		BinaryTree tree_2 = new BinaryTree<T>(this.getData());
		if (this.hasLeftChild()) {
			tree_2.addRightChild(this.getLeftChild().espejo());
		}
		if (this.hasRightChild()) {
			tree_2.addLeftChild(this.getRightChild().espejo());
		}
		return tree_2;
	}

	// 0<=n<=m
	@SuppressWarnings("unchecked")
	public void entreNiveles(int n, int m) {
		int c = 1;
		Queue queue = new LinkedList();
		BinaryTree<T> right = this;
		BinaryTree<T> left = this;

		while (!queue.isEmpty() || (c <= m)) {
			if (!queue.isEmpty()) {
				System.err.println(queue.poll());

			}
			if (left.hasLeftChild()) {
				left = left.getLeftChild();
				if ((n <= c) && (c <= m)) {
					queue.add(left.getData());
				}
			}
			if (right.hasRightChild()) {
				right = right.getRightChild();
				if ((n <= c) && (c <= m)) {
					queue.add(right.getData());
				}

			}
			c++;
		}

	}
	/*
	 * if ((n <= c) && (c <= m)) {
	 * System.out.println(this.getData());
	 * }
	 * c++;
	 * if (this.hasLeftChild()) {
	 * this.getLeftChild().entreNiveles(n, m, c);
	 * }
	 * if (this.hasRightChild()) {
	 * this.getRightChild().entreNiveles(n, m, c);
	 * }
	 * c--;
	 */

	public void numerosPares(BinaryTree<Integer> tree, Queue<Integer> cola) {
		if (tree.getData() % 2 == 0) {
			cola.add(tree.getData());
		}
		if (tree.hasLeftChild()) {

			numerosPares(tree.getLeftChild(), cola);
		}
		if (tree.hasRightChild()) {

			numerosPares(tree.getRightChild(), cola);
		}
	}

	public void añadirConCola(Queue<Integer> cola, BinaryTree<Integer> tree) {
		if (cola.isEmpty()) {
			return;
		}
		if (2 <= cola.size()) {
			int co = cola.poll();
			tree.data = co;
		}
		if (tree.hasLeftChild()) {
			añadirConCola(cola, tree.getLeftChild());
		}
		if (tree.hasRightChild()) {
			añadirConCola(cola, tree.getRightChild());
		}

	}

	public void ContadorArbol() {
		BinaryTree<Integer> tree2 = new BinaryTree<>();
		Queue<Integer> cola = new LinkedList();
		numerosPares((BinaryTree<Integer>) this, cola);
		añadirConCola(cola, tree2);

	}

	public BinaryTree<Integer> suma(BinaryTree<Integer> arbol) {
		suma(arbol, 0);
		return arbol;

	}

	public int suma(BinaryTree<Integer> arbol1, int suma) {

		if (arbol1.hasLeftChild()) {
			suma += suma(arbol1.getLeftChild(), suma);
		}
		if (arbol1.hasRightChild()) {
			suma += suma(arbol1.getRightChild(), suma);
		}
		if (arbol1.isLeaf()) {

			arbol1.setData(0);
			;
			return suma;
		}
/ checkear si es empty y null**/
		suma += arbol1.getData();
		arbol1.setData(suma);//cambiar 
		return suma;

	}
}
