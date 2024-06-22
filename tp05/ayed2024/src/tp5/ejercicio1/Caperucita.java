package tp5.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class Caperucita {
    Graph<String> grafo = null;

    public Caperucita(Graph<String> g) {
        this.grafo = g;
    }

    public List<List<String>> recorridoMasSeguro() {
        List<List<String>> res = new LinkedList<List<String>>();
        if (this.grafo != null) {

            caminoMasSeguro(this.grafo.search("Casa Caperucita").getPosition(), "Casa Abuelita", this.grafo,
                    new boolean[this.grafo.getSize()], res, new LinkedList<String>());
        }
        return res;
    }

    private void caminoMasSeguro(int position, String dst, Graph<String> grafo2, boolean[] marca,
            List<List<String>> res, LinkedList<String> aux) {
        Vertex<String> v = grafo2.getVertex(position);
        marca[position] = true;
        aux.add(v.getData());
        if (v.getData() == dst) {
            res.add(new LinkedList<String>(aux));
        } else {

            for (Edge<String> ady : grafo2.getEdges(v)) {
                if (ady.getWeight() < 5 && !marca[ady.getTarget().getPosition()]) {

                    caminoMasSeguro(ady.getTarget().getPosition(), dst, grafo2, marca, res, aux);
                }

            }

        }
        marca[position] = false;
        aux.remove(aux.size() - 1);

    }

}
