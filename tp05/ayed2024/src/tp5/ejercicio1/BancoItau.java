package tp5.ejercicio1;

/* Ejercicio 5
El Banco Itaú se suma a las campañas "QUEDATE EN CASA" lanzando un programa para acercar el sueldo a los
jubilados hasta sus domicilios. Para ello el banco cuenta con información que permite definir un grafo de
Persona2s donde la Persona2 puede ser un jubilado o un empleado del banco que llevará el dinero.
Se necesita armar la cartera de jubilados para cada empleado repartidor del banco, incluyendo en cada lista, los
jubilados que vivan un radio cercano a su casa y no hayan percibido la jubilación del mes.
Para ello, implemente un algoritmo que dado un Grafo<Persona2> retorne una lista de jubilados que se
encuentren a una distancia menor a un valor dado del empleado Itaú (grado de separación del empleado Itaú).
El método recibirá un Grafo<Persona2>, un empleado y un grado de separación/distancia y debe retornar una
lista de hasta 40 jubilados que no hayan percibido la jubilación del mes y se encuentre a una distancia menor a
recibido como parámetro. 
En este grafo simple, donde los empleados del banco están en
color rojo, si se desea retornar los jubilados hasta distancia 2, se
debería retornar los jubilados en color negro.
La Persona2 conoce si es empleado o jubilado, el nombre y el
domicilio. */

import java.util.*;

import tp5.ejercicio1.adjList.AdjListGraph;

public class BancoItau {
    public BancoItau() {
    }

    public List<Jubilado> carteraJubilados(Graph<Persona2> grafo, String nomEmpleado, int grado, int maxList) {
        List<Jubilado> jubilados = new LinkedList<Jubilado>();
        if (!grafo.isEmpty()) {
            Vertex<Persona2> emp = this.buscarEmpleado(grafo, nomEmpleado);
            if (emp != null) {
                Queue<Vertex<Persona2>> c = new Queue<Vertex<Persona2>>();
                boolean[] marcas = new boolean[grafo.getSize()];
                marcas[emp.getPosition()] = true;
                c.enqueue(emp);
                c.enqueue(null);
                while (!c.isEmpty() && grado > 0 && jubilados.size() < maxList) {
                    Vertex<Persona2> v = c.dequeue();
                    if (v != null) {
                        List<Edge<Persona2>> adys = grafo.getEdges(v);
                        Iterator<Edge<Persona2>> it = adys.iterator();
                        while (it.hasNext() && jubilados.size() < maxList) {
                            Vertex<Persona2> vertDestino = it.next().getTarget();
                            int posDestino = vertDestino.getPosition();
                            if (!marcas[posDestino]) {
                                marcas[posDestino] = true;
                                c.enqueue(vertDestino);
                                if (vertDestino.getData().cumple()) {
                                    jubilados.add(new Jubilado(vertDestino.getData().getNombre(),
                                            vertDestino.getData().getDomicilio()));
                                }
                            }
                        }
                    } else if (!c.isEmpty()) {
                        grado--;
                        c.enqueue(null);
                    }
                }
            }
        }
        return jubilados;
    }

    private Vertex<Persona2> buscarEmpleado(Graph<Persona2> grafo, String nomEmpleado) {
        List<Vertex<Persona2>> vertices = grafo.getVertices();
        Iterator<Vertex<Persona2>> it = vertices.iterator();
        Vertex<Persona2> per = null;
        boolean sigo = true;
        while ((it.hasNext()) && (sigo)) {
            Vertex<Persona2> aux = it.next();
            if (aux.getData().getNombre().equals(nomEmpleado)) {
                per = aux;
                sigo = false;
            }
        }
        return per;
    }

    public static void main(String[] args) {
        Graph<Persona2> grafo = new AdjListGraph<>();
        Vertex v1 = grafo.createVertex(new Persona2("Empleado", "Matias", "AAA", true));
        Vertex v2 = grafo.createVertex(new Persona2("Jubilado", "Julian", "BBB", false));
        Vertex v3 = grafo.createVertex(new Persona2("Jubilado", "Francisco", "CCC", false));
        Vertex v4 = grafo.createVertex(new Persona2("Empleado", "Valentin", "DDD", true));
        Vertex v5 = grafo.createVertex(new Persona2("Jubilado", "Omar", "EEE", true));
        Vertex v6 = grafo.createVertex(new Persona2("Empleado", "Rosana", "FFF", true));
        Vertex v7 = grafo.createVertex(new Persona2("Jubilado", "Maria", "GGG", false));
        Vertex v8 = grafo.createVertex(new Persona2("Jubilado", "Sandra", "HHH", true));
        Vertex v9 = grafo.createVertex(new Persona2("Jubilado", "Matheo", "III", false));

        grafo.connect(v1, v2);
        grafo.connect(v2, v1);
        grafo.connect(v2, v3);
        grafo.connect(v3, v2);

        grafo.connect(v1, v9);
        grafo.connect(v9, v1);
        grafo.connect(v9, v8);
        grafo.connect(v8, v9);

        grafo.connect(v1, v4);
        grafo.connect(v4, v1);
        grafo.connect(v1, v6);
        grafo.connect(v6, v1);
        grafo.connect(v4, v5);
        grafo.connect(v5, v4);
        grafo.connect(v5, v7);
        grafo.connect(v7, v5);

        BancoItau banco = new BancoItau();

        // System.out.println(banco.carteraJubilados(grafo, "Matias", 1, 40));
        System.out.println(banco.carteraJubilados(grafo, "Matias", 2, 40));
        // System.out.println(banco.carteraJubilados(grafo, "Matias", 3, 40));

        // System.out.println(banco.carteraJubilados(grafo, "Rosana", 2, 40));

        // System.out.println(banco.carteraJubilados(grafo, "Matias", 2, 1));
    }
}