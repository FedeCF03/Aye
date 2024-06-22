package tp5.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class QUEDATEENCASA {
    public QUEDATEENCASA() {

    }

    public List<Persona> distanciaJubi(Graph<Persona> grafo, Persona emple, int distanciaJubi) {
        if (grafo == null || emple == null)
            return null;
        List<Persona> res = new LinkedList<Persona>();
        boolean[] marca = new boolean[grafo.getSize()];
        Vertex<Persona> v = grafo.search(emple);
        int i = v.getPosition();
        Queue<Vertex<Persona>> colita = new Queue<Vertex<Persona>>();
        colita.enqueue(v);
        colita.enqueue(null);
        marca[i] = true;

        while (!colita.isEmpty() && distanciaJubi >= 1) {
            v = colita.dequeue();
            if (v != null) {

                for (Edge<Persona> ady : grafo.getEdges(v)) {
                    int j = ady.getTarget().getPosition();
                    if (!marca[j]) {
                        if (ady.getTarget().getData().getjubilado() && !ady.getTarget().getData().isCobro()) {
                            res.add(ady.getTarget().getData());
                        }
                        colita.enqueue(ady.getTarget());
                        marca[j] = true;
                    }

                }
            }
            if (v == null) {
                distanciaJubi += -1;
                colita.enqueue(null);
            }
        }

        return res;
    }

}
