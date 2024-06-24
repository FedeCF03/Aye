package tp5.ejercicio1;

import java.util.LinkedList;
import java.util.List;

import tp5.ejercicio1.adjList.AdjListGraph;

public class app {
    public static void main(String[] args) throws Exception {
        Graph<String> bosque = new AdjListGraph<String>();
        Vertex<String> v1 = bosque.createVertex("mendoza");
        Vertex<String> v2 = bosque.createVertex("tunuyan");
        Vertex<String> v3 = bosque.createVertex("san martin");
        Vertex<String> v4 = bosque.createVertex("malargue");
        Vertex<String> v5 = bosque.createVertex("general alvear");
        Vertex<String> v6 = bosque.createVertex("san rafael");
        Vertex<String> v7 = bosque.createVertex("la paz");
        Vertex<String> v8 = bosque.createVertex("santa rosa");

        bosque.connect(v1, v2, 10);
        bosque.connect(v1, v3, 6);
        bosque.connect(v2, v3, 10);
        bosque.connect(v2, v4, 12);
        bosque.connect(v6, v2, 11);
        bosque.connect(v5, v4, 6);
        bosque.connect(v6, v5, 7);
        bosque.connect(v3, v6, 13);
        bosque.connect(v3, v7, 8);
        bosque.connect(v7, v8, 2);
        List<String> evitar = new LinkedList<String>();
        evitar.add("general alvear");
        evitar.add("la paz");

        System.out.println(Parcial4.resolver4(bosque, 5, 80, evitar));
    }
}
