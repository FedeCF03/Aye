package tp5.ejercicio1;

import java.util.LinkedList;
import java.util.List;

public class VisitaOslo {

    public List<String> paseoEnBici(Graph<String> lugares, String destino, int maxTiempo,
            List<String> lugaresRestringidos) {
        List<String> res = new LinkedList<String>();
        boolean[] marca = new boolean[lugares.getSize()];
        int pos = lugares.search("Ayuntamiento").getPosition();
        bfs(pos, destino, lugares, maxTiempo, marca, lugaresRestringidos, res, new LinkedList<String>()); // las listas
                                                                                                          // empiezan en
                                                                                                          // la pos 1

        return res;
    }

    private void bfs(int i, String destino, Graph<String> grafo, int maxTiempo, boolean[] marca,
            List<String> lugaresRestringidos, List<String> res, List<String> aux) {
        marca[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        aux.add(v.getData());
        if (v.getData() == destino) {
            res.addAll(aux);
        }
        List<Edge<String>> ady = grafo.getEdges(v);
        if (!res.contains(destino)) {
            for (Edge<String> a : ady) {
                int j = a.getTarget().getPosition();
                if (!marca[j] && a.getWeight() < maxTiempo && !lugaresRestringidos.contains(a.getTarget().getData())) {
                    bfs(a.getTarget().getPosition(), destino, grafo, maxTiempo - a.getWeight(), marca,
                            lugaresRestringidos, res, aux);
                }

            }
        }
        marca[i] = false;
        aux.remove(aux.size() - 1);
    }
}
