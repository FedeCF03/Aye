package tp3.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class GeneralTree<T> {

	private T data;
	private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

	public GeneralTree() {

	}

	public GeneralTree(T data) {
		this.data = data;
	}

	public GeneralTree(T data, List<GeneralTree<T>> children) {
		this(data);
		this.children = children;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<GeneralTree<T>> getChildren() {
		return this.children;
	}

	public void setChildren(List<GeneralTree<T>> children) {
		if (children != null)
			this.children = children;
	}

	public void addChild(GeneralTree<T> child) {
		this.getChildren().add(child);
	}

	public boolean isLeaf() {
		return !this.hasChildren();
	}

	public boolean hasChildren() {
		return !this.children.isEmpty();
	}

	public boolean isEmpty() {
		return this.data == null && !this.hasChildren();
	}

	public void removeChild(GeneralTree<T> child) {
		if (this.hasChildren())
			children.remove(child);
	}

	public int altura() {

		return 0;
	}

	public int nivel(T dato) {
		return 0;
	}

	public int ancho() {

		return 0;
	}

	private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,
			Integer n, List<Integer> lista) {
		if ((a.getData() % 2 == 1) && (a.getData() > n))
			lista.add(a.getData());
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child : children) {
			child.numerosImparesMayoresQuePreOrden(a, n, lista);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,
			Integer n) {
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQuePreOrden(a, n, lista);
		return (List<Integer>) lista;
	}

}