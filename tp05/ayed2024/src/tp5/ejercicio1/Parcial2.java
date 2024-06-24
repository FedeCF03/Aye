package tp5.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Parcial2 {

    public static int resolver(Graph<zoo> grafo, int tiempo) {
        int i = buscarEntrada(grafo, "Entrada");
        if (i != -1) {
            return resolver(i, tiempo - grafo.getVertex(i).getData().getTiempo(), grafo, 1,
                    new boolean[grafo.getSize()]);
        }
        return 0;
    }

    private static int resolver(int i, int tiempo, Graph<zoo> grafo, int j, boolean[] marca) {
        Vertex<zoo> v = grafo.getVertex(i);
        if (grafo.getEdges(v).size() == 0)
            return j;
        marca[i] = true;
        int max = j;
        System.out.println(v.getData().getNombre());
        for (Edge<zoo> ady : grafo.getEdges(v)) {
            if (ady.getWeight() + ady.getTarget().getData().getTiempo() <= tiempo) {
                max = Math.max(max, resolver(ady.getTarget().getPosition(),
                        tiempo - (ady.getWeight() + ady.getTarget().getData().getTiempo()), grafo, j + 1, marca));

            }
        }
        marca[i] = false;
        return max;
    }

    public static List<String> resolver3(Graph<ciudad> mapa, int cantvacas) {
        List<String> res = new LinkedList<String>();
        int i = buscarCiudad(mapa, "mardel");
        if (i != -1) {
            resolver3(i, mapa, mapa.getVertex(i).getData().tiempo, new boolean[mapa.getSize()], cantvacas, res,
                    new LinkedList<String>());
        }

        return res;
    }

    private static void resolver3(int i, Graph<ciudad> mapa, int j, boolean[] bs, int cantvacas, List<String> res,
            LinkedList<String> aux) {

        Vertex<ciudad> v = mapa.getVertex(i);
        aux.add(v.getData().ciudad);
        bs[i] = true;
        if (j == cantvacas && aux.size() > res.size()) {
            res.clear();
            res.addAll(aux);
        } else {
            for (Edge<ciudad> ady : mapa.getEdges(v)) {
                if (j + ady.getTarget().getData().tiempo <= cantvacas) {
                    resolver3(ady.getTarget().getPosition(), mapa,
                            j + ady.getTarget().getData().tiempo, bs, cantvacas, res, aux);
                }

            }
        }
        bs[i] = false;

        aux.remove(aux.size() - 1);
    }

    private static int buscarEntrada(Graph<zoo> grafo, String buscado) {
        List<Vertex<zoo>> vertices = grafo.getVertices();
        for (Vertex<zoo> vertex : vertices) {
            if (vertex.getData().getNombre().equals(buscado)) {
                return vertex.getPosition();
            }
        }
        return -1;
    }

    private static int buscarCiudad(Graph<ciudad> grafo, String buscado) {
        List<Vertex<ciudad>> vertices = grafo.getVertices();
        for (Vertex<ciudad> vertex : vertices) {
            if (vertex.getData().ciudad.equals(buscado)) {
                return vertex.getPosition();
            }
        }
        return -1;
    }

}
