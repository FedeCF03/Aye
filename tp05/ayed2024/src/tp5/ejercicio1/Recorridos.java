package tp5.ejercicio1;

import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import java.util.*;

public class Recorridos<T> {

    public void dfs(int i, Graph<T> grafo, boolean[] marca) {
        marca[i] = true;
        Vertex<T> v = grafo.getVertex(i);
        System.out.println(v.getData());
        List<Edge<T>> adyacentes = grafo.getEdges(v); // adyacentes
        for (Edge<T> e : adyacentes) {

            int j = e.getTarget().getPosition();
            if (!marca[j]) {
                dfs(j, grafo, marca);
            }
        }
    }

    public void bfs(Graph<T> grafo) {
        boolean[] marca = new boolean[grafo.getSize()];
        for (int i = 1; i <= marca.length; i++) {
            if (!marca[i]) {
                this.bfs(i, grafo, marca); // las listas empiezan en la pos 1
            }
        }
    }

    private void bfs(int i, Graph<T> grafo, boolean[] marca) {
        Queue<Vertex<T>> q = new Queue<Vertex<T>>();
        q.enqueue(grafo.getVertex(i));
        marca[i] = true;
        while (!q.isEmpty()) {
            Vertex<T> w = q.dequeue();
            System.out.println(w);
            // para todos los vecinos de w:
            List<Edge<T>> adyacentes = grafo.getEdges(w);
            for (Edge<T> e : adyacentes) {
                int j = e.getTarget().getPosition();
                if (!marca[j]) {
                    marca[j] = true;
                    // Vertex<T> v = e.getTarget();
                    q.enqueue(e.getTarget());
                }
            }
        }
    }

}