package tp5.ejercicio1;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.LinkedList;
import java.util.List;

public class Parcial {

    public static List<String> resolver(Graph<String> sitios, String origen, String destino,
            List<String> evitarPasarPor) {
        List<String> res = new LinkedList<String>();
        int aux = 0;
        if (sitios != null) {
            resolver(sitios.search("Estadio Maradona").getPosition(), destino, sitios, new boolean[sitios.getSize()],
                    evitarPasarPor, res, aux, "");
        }

        return res;
    }

    private static void resolver(int position, String destino, Graph<String> sitios, boolean[] marca,
            List<String> evitarPasarPor, List<String> res, int aux, String st) {
        Vertex<String> v = sitios.getVertex(position);
        marca[position] = true;
        String st_aux = st + v.getData() + " , ";
        if (v.getData() == destino) {
            st_aux += " : " + aux;
            res.add(st_aux);
            marca[position] = false;
        } else {
            for (Edge<String> ady : sitios.getEdges(v)) {
                if (!marca[ady.getTarget().getPosition()] && !evitarPasarPor.contains(ady.getTarget().getData())) {
                    resolver(ady.getTarget().getPosition(), destino, sitios, marca, evitarPasarPor, res,
                            aux + ady.getWeight(),
                            st_aux);
                }

            }
        }
    }

}
