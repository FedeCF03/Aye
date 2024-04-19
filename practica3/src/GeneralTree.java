
import java.io.Console;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

	private int nivel_private(T dato, GeneralTree<T> a, int n, int res) {

		List<GeneralTree<T>> children = a.getChildren();
		n++;
		if (dato == a.getData()) {
			System.out.print("encontre");
			return n;

		}
		for (GeneralTree<T> child : children) {
			res = nivel_private(dato, child, n, res);
		}
		return res;

	}

	public int nivel(T dato) {
		if (!this.isEmpty()) {
			return nivel_private(dato, this, 0, 0);
		}
		return 0;
	}

	public int ancho() {
		Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
		cola.add(this);
		int ancho_max = 0;
		GeneralTree<T> act = new GeneralTree<>();
		for (int i = 0; i < this.altura(); i++) {
			int nodos_nivel = 0;
			while (!cola.isEmpty()) {
				act = cola.dequeue();
				List<GeneralTree<T>> childrens = act.getChildren();
				nodos_nivel++;
				for (GeneralTree<T> child : childrens) {
					cola.add(child);
				}
			}
			ancho_max = Math.max(ancho_max, nodos_nivel);
		}

		return ancho_max;
	}

	public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> arbol) {
		Queue cola = new Queue<Integer>();
		GeneralTree<AreaEmpresa> act = GeneralTree<AreaEmpresa>();
		double tardanzaMax;
		cola.enqueue(arbol);		
		for (int i=0;i < this.altura(); i++){
				double tardanzaNivel=0;
				int cantNivel=0;
			while (!cola.isEmpty()){
				act= cola.dequeue;
				GeneralTree<AreaEmpresa> childrens= act.getChildren();
				cantNivel++;
				tardanzaNivel+= act.getData().gettardanzaTransmisionMensajes();
				for (GeneralTree<AreaEmpresa> child:childrens){
					cola.enqueue(child);
				}

			}
			tardanzaNivel= tardanzaNivel/cantNivel;
			tardanzaMax=Math.max(tardanzaMax,tardanzaNivel);

		}
			return tardanzaMax;
	}

	private GeneralTree<T> buscarHijo(T b, GeneralTree<T> ag, GeneralTree<T> res) {
		if (b == ag.getData())
			return ag;
		List<GeneralTree<T>> children = ag.getChildren();
		for (GeneralTree<T> child : children) {
			res = buscarHijo(b, child, res);
		}
		return res;
	}

	public boolean esAncestro(T a, T b) {
		GeneralTree<T> res = buscarHijo(a, this, null);
		if (!(res == null)) {
			res = buscarHijo(b, res, null);
			if (!(res == null))
				return true;
		}
		return false;
	}

	private void numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,
			Integer n, List<Integer> lista) {
		if ((a.getData() % 2 == 1) && (a.getData() > n))
			lista.add(a.getData());
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child : children) {
			child.numerosImparesMayoresQuePreOrden(child, n, lista);
		}

	}

	@SuppressWarnings("unchecked")
	public List<Integer> numerosImparesMayoresQuePreOrden(GeneralTree<Integer> a,
			Integer n) {
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQuePreOrden(a, n, lista);
		return (List<Integer>) lista;
	}

	private void numerosImparesMayoresQueInOrden(GeneralTree<Integer> a,
			Integer n, List<Integer> lista) {

		List<GeneralTree<Integer>> children = a.getChildren();

		if (a.hasChildren()) {
			numerosImparesMayoresQueInOrden(children.get(0), n, lista);
		}
		System.out.println(a.getData());
		if ((a.getData() % 2 == 1) && (a.getData() > n))
			lista.add(a.getData());
		for (int i = 1; i < children.size(); i++) {
			numerosImparesMayoresQueInOrden(children.get(i), n, lista);
		}

	}

	public List<Integer> numerosImparesMayoresQueInOrden(GeneralTree<Integer> a,
			Integer n) {
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQueInOrden(a, n, lista);
		return (List<Integer>) lista;

	}

	private void numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a,
			Integer n, List<Integer> l) {
		List<GeneralTree<Integer>> children = a.getChildren();
		for (GeneralTree<Integer> child : children) {
			numerosImparesMayoresQuePostOrden(child, n, l);
		}
		System.out.println(a.getData());
		if ((a.getData() > n) && (a.getData() % 2 == 0)) {
			l.add(a.getData());
		}
	}

	public List<Integer> numerosImparesMayoresQuePostOrden(GeneralTree<Integer> a,
			Integer n) {
		List<Integer> lista = new LinkedList<Integer>();
		numerosImparesMayoresQuePostOrden(a, n, lista);
		return lista;
	}

	// private void numerosImparesMayoresQuePorNiveles(GeneralTree<T> a, Integer n,
	// List<Integer> l) {
	// Queue<GeneralTree<T>> cola = new Queue<GeneralTree<T>>();
	// cola.enqueue(a);
	// GeneralTree<T> act = new GeneralTree<>();
	// while (!cola.isEmpty()) {
	// act = cola.poll();
	// List<GeneralTree<T>> children = act.getChildren();
	// if ((a.getData() > n) && (a.getData() % 2 == 0)) {
	// l.add(a.getData());
	// }
	// for (GeneralTree<T> child : children) {
	// //cola.enqueue(child);
	// }
	// }
	// }

	// }

	// public List<Integer> numerosImparesMayoresQuePorNiveles(GeneralTree<T> a,
	// Integer n) {
	// List<Integer> l = new LinkedList<Integer>();
	// if (!a.isEmpty() & !(a = null))
	// numerosImparesMayoresQuePorNiveles(a, 5, l);
	// return l;
	private int altura_private(int n, int max, GeneralTree<T> a) {
		if (!a.isLeaf()) {
			n++;
			List<GeneralTree<T>> children = a.getChildren();
			for (GeneralTree<T> child : children) {
				n = altura_private(n, max, child);
				if (n > max) {
					max = n;
				}
			}
			return max;
		}
		return n;
	}

	public int altura() {
		int alt = 0, max = 0;
		return altura_private(alt, max, this);

	}

}
