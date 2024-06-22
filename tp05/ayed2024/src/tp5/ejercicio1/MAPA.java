package tp5.ejercicio1;

import tp5.ejercicio1.Queue;
import tp5.ejercicio1.Edge;
import tp5.ejercicio1.Graph;
import tp5.ejercicio1.Vertex;
import java.util.*;

public class MAPA {

    private Graph<String> mapaCiudades;

    public MAPA(Graph<String> mapa) {
        this.setMapaCiudades(mapa);
    }

    public Graph<String> getMapaCiudades() {
        return mapaCiudades;
    }

    public void setMapaCiudades(Graph<String> mapaCiudades) {
        this.mapaCiudades = mapaCiudades;
    }

    /*
     * devolverCamino (String ciudad1, String ciudad2): List<String>
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a
     * ciudad2 en caso de que se
     * pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el
     * combustible).
     */

    public LinkedList<LinkedList<String>> devolverCamino(String ciudad1, String ciudad2) {
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        LinkedList<String> lis = null;
        LinkedList<LinkedList<String>> recorridos = new LinkedList<>();
        lis = new LinkedList<>();
        this.devolverCamino(this.mapaCiudades.search(ciudad1).getPosition(), ciudad2, this.mapaCiudades, marca, lis,
                recorridos);
        return recorridos;
    }

    public void devolverCamino(int i, String ciudad2, Graph<String> grafo, boolean[] marca, LinkedList<String> lis,
            LinkedList<LinkedList<String>> recorridos) {
        marca[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        if (v.getData() == ciudad2) {
            lis.add(v.getData().toString());
            recorridos.add(new LinkedList<String>(lis));
            lis.remove(v.getData().toString());
            marca[i] = false;

        } else {
            List<Edge<String>> adyacentes = grafo.getEdges(v); // adyacentes
            for (Edge<String> e : adyacentes) {
                lis.add(v.getData());
                if (marca[e.getTarget().getPosition()] == false)
                    devolverCamino(e.getTarget().getPosition(), ciudad2, grafo, marca, lis, recorridos);
                lis.remove(v.getData().toString());
            }
        }

    }

    public LinkedList<LinkedList<String>> devolverCaminoExceptuando(String ciudad1, String ciudad2,
            List<String> ciudades) {
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        LinkedList<String> lis = null;
        LinkedList<LinkedList<String>> recorridos = new LinkedList<>();
        lis = new LinkedList<>();
        this.devolverCaminoExceptuando(this.mapaCiudades.search(ciudad1).getPosition(), ciudad2, this.mapaCiudades,
                marca, lis,
                recorridos, ciudades);
        return recorridos;
    }

    private void devolverCaminoExceptuando(int i, String ciudad2, Graph<String> grafo, boolean[] marca,
            LinkedList<String> lis,
            LinkedList<LinkedList<String>> recorridos, List<String> ciudades) {
        marca[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        if (v.getData() == ciudad2) {
            lis.add(v.getData().toString());
            recorridos.add(new LinkedList<String>(lis));
            lis.remove(v.getData().toString());
            marca[i] = false;

        } else {
            List<Edge<String>> adyacentes = grafo.getEdges(v); // adyacentes
            for (Edge<String> e : adyacentes) {
                lis.add(v.getData());
                if (marca[e.getTarget().getPosition()] == false && !ciudades.contains(e.getTarget().getData()))
                    devolverCamino(e.getTarget().getPosition(), ciudad2, grafo, marca, lis, recorridos);
                lis.remove(v.getData().toString());
            }
        }

    }

    /*
     * caminoMasCorto(String ciudad1, String ciudad2): List<String>
     * Retorna la lista de ciudades que forman el camino más corto para llegar de
     * ciudad1 a ciudad2, si no
     * existe camino retorna la lista vacía. (Las rutas poseen la distancia).
     */
    public LinkedList<String> caminoMasCorto(String ciudad1, String ciudad2) {
        boolean[] marca = new boolean[this.mapaCiudades.getSize()];
        LinkedList<String> lis = null;
        LinkedList<String> recorridos = new LinkedList<>();
        int aux = 0;
        int min = Integer.MAX_VALUE;
        lis = new LinkedList<>();
        this.caminoMasCorto(this.mapaCiudades.search(ciudad1).getPosition(), ciudad2, this.mapaCiudades,
                marca, lis,
                recorridos, min, aux);
        return recorridos;
    }

    private void caminoMasCorto(int i, String ciudad2, Graph<String> grafo, boolean[] marca,
            LinkedList<String> lis,
            LinkedList<String> recorridos, int min, int aux) {
        marca[i] = true;
        Vertex<String> v = grafo.getVertex(i);
        if (v.getData() == ciudad2 && aux < min) {
            lis.add(v.getData().toString());
            recorridos.removeAll(recorridos);
            recorridos.addAll(lis);
            lis.remove(v.getData().toString());
            marca[i] = false;
            min = aux;

        } else {
            List<Edge<String>> adyacentes = grafo.getEdges(v); // adyacentes
            for (Edge<String> e : adyacentes) {
                aux += e.getWeight();
                lis.add(v.getData());
                if (marca[e.getTarget().getPosition()] == false)
                    caminoMasCorto(e.getTarget().getPosition(), ciudad2, grafo, marca, lis, recorridos, min, aux);
                lis.remove(v.getData().toString());
                aux -= e.getWeight();
            }
        }

    }

    public List<String> caminoSinCargarCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        List<String> res = new LinkedList<String>();
        List<String> aux = new LinkedList<String>();
        aux.add(ciudad1);
        boolean[] marca = new boolean[mapaCiudades.getSize()];
        caminoSinCargarCombustible(this.mapaCiudades.search(ciudad1).getPosition(), ciudad2, tanqueAuto, marca,
                res,
                this.mapaCiudades, aux);

        return res;
    }

    public void caminoSinCargarCombustible(int i, String ciudad2,
            int tanqueAuto, boolean[] marca,
            List<String> res, Graph<String> mapaCiudades, List<String> aux) {
        int p = 0, j = 0;
        Vertex<String> v = mapaCiudades.getVertex(i);
        List<Edge<String>> ady = mapaCiudades.getEdges(v);
        for (Edge<String> e : ady) {
            j = e.getTarget().getPosition();
            marca[i] = true;
            if (!marca[j] && e.getWeight() <= tanqueAuto) {
                aux.add(e.getTarget().getData());
                if (e.getTarget().getData() == ciudad2) {
                    res.addAll(aux);
                } else {
                    caminoSinCargarCombustible(j, ciudad2, tanqueAuto - e.getWeight(), marca, res, mapaCiudades, aux);
                    aux.remove(aux.size() - 1);
                }

            }
        }
    }

    public List<String> caminoConMenorCargaDeCombustible(String ciudad1, String ciudad2, int tanqueAuto) {
        Minimos min = new Minimos();

        min.min_aux.add(ciudad1);
        if (ciudad1 != null && ciudad2 != null) {

            Vertex<String> v = this.mapaCiudades.search(ciudad1);
            caminoConMenorCargaDeCombustible(v, ciudad2, tanqueAuto, new boolean[this.mapaCiudades.getSize()],
                    min, this.mapaCiudades, new boolean[this.mapaCiudades.getSize()]);
        }

        return min.min;

    }

    public void caminoConMenorCargaDeCombustible(Vertex<String> v, String ciudad2, int tanqueAuto, boolean[] bs,
            Minimos min, Graph<String> mapaCiudades, boolean[] marca) {
        marca[v.getPosition()] = true;
        min.min_aux.add(v.getData());
        if (v.getData().equals(ciudad2) && min.menor_costo_aux < min.menor_costo) {
            min.min.clear();
            min.min.addAll(min.min_aux);
            min.min_aux.remove(min.min_aux.size() - 1);
        } else {
            for (Edge<String> e : mapaCiudades.getEdges(v)) {

                if (!marca[e.getTarget().getPosition()] && e.getWeight() < tanqueAuto) {

                }

            }
        }
        marca[v.getPosition()] = false;

    }
}
