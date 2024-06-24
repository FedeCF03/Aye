package tp5.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.LinkedList;
import java.util.List;

public class Parcial4 {

    public static int resolver(Graph<ciudad> ciudades, String origen, String destino, int maxcontroles) {
        int i = buscarPos(ciudades, origen);
        if (i != -1) {
            return resolver(i, destino, 0, 0, ciudades, new boolean[ciudades.getSize()], maxcontroles);
        }
        return 0;
    }

    private static int resolver(int i, String destino, int max, int act, Graph<ciudad> ciudades, boolean[] marca,
            int maxcontroles) {
        marca[i] = true;
        Vertex<ciudad> v = ciudades.getVertex(i);
        act += v.getData().tiempo;
        if (v.getData().ciudad == destino && max < act) {
            return act;
        } else {
            for (Edge<ciudad> ady : ciudades.getEdges(v)) {
                if (ady.getWeight() <= maxcontroles) {
                    max = Math.max(max,
                            resolver(ady.getTarget().getPosition(), destino, max, act, ciudades, marca, maxcontroles));
                }

            }
        }
        marca[i] = false;
        return max;
    }

    public static List<String> resolver2(Graph<String> calles) {
        List<String> res = new LinkedList<String>();
        int i = buscarPosPresi(calles, "casa");

        if (i != -1) {
            resolver2(i, "muni", calles, new boolean[calles.getSize()], res, new LinkedList<String>());
        }

        return res;
    }

    private static void resolver2(int i, String destino, Graph<String> calles, boolean[] bs, List<String> res,
            List<String> aux) {
        Vertex<String> v = calles.getVertex(i);
        bs[i] = true;
        aux.add(v.getData());
        if (v.getData() == destino) {
            res.addAll(aux);
        } else {
            for (Edge<String> ady : calles.getEdges(v)) {
                if (ady.getWeight() == 0 && ady.getTarget().getData() != "m") {
                    resolver2(ady.getTarget().getPosition(), destino, calles, bs, res, aux);
                }
            }
        }
        bs[i] = false;
        aux.remove(aux.size() - 1);

    }

    public static int buscarPos(Graph<ciudad> ciudades, String origen) {

        for (Vertex<ciudad> v : ciudades.getVertices()) {
            if (origen == v.getData().ciudad)
                return v.getPosition();
        }

        return -1;
    }

    public static int buscarPosPresi(Graph<String> ciudades, String origen) {

        for (Vertex<String> v : ciudades.getVertices()) {
            if (origen == v.getData())
                return v.getPosition();
        }

        return -1;
    }

    public static List<String> resolver4(Graph<String> grafo, int cantMinima, int cantNafta, List<String> evitar) {
        List<String> res = new LinkedList<String>();
        int i = buscarPosPresi(grafo, "mendoza");
        if (i != -1) {
            resolver4(i, grafo, cantMinima, cantNafta, evitar, res, new LinkedList<String>(),
                    new boolean[grafo.getSize()]);
        }
        return res;
    }

    private static void resolver4(int i, Graph<String> grafo, int cantMinima, int cantNafta, List<String> evitar,
            List<String> res,
            LinkedList<String> aux, boolean[] marca) {
        marca[i] = true;
        cantMinima -= 1;
        Vertex<String> v = grafo.getVertex(i);
        aux.add(v.getData());
        if (cantMinima == 0) {
            res.addAll(aux);
        } else {
            for (Edge<String> ady : grafo.getEdges(v)) {
                if (ady.getWeight() <= cantNafta && res.size() < 1 && !evitar.contains(ady.getTarget().getData())
                        && marca[ady.getTarget().getPosition()] == false) {
                    resolver4(ady.getTarget().getPosition(), grafo, cantMinima, cantNafta - ady.getWeight(), evitar,
                            res, aux, marca);
                }
            }

        }
        marca[i] = false;
        aux.remove(aux.size() - 1);
    }

}
