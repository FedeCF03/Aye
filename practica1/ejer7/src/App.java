import java.util.ArrayList;

public class App {
    public static boolean esCapicua(ArrayList<Integer> lista) {
        int i = 0;
        int f = lista.size() - 1;
        while (i < f) {
            if (lista.get(i) == lista.get(f)) {
                i++;
                f--;
            } else {
                return false;
            }
        }
        return true;

    }

    public static void añadirsinoesta(String nombre, ArrayList<String> list) {
        for (String n : list) {
            if (n.equals(nombre)) {
                System.out.println("El nombre ya existe");
                return;
            }
        }
        list.add(nombre);
    }

    public static void creador() {
        ArrayList<String> list = new ArrayList<>();
        list.add("fede");
        list.add("tomi");
        list.add("mar");
        añadirsinoesta("fede", list);
        System.out.println(list);
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(6);
        System.out.println(esCapicua(list));
    }
}
