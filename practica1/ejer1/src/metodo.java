public class metodo {
    public static void forMostrador(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }

    public static void whileMostrador(int a, int b) {
        int i = a;
        while (i <= b) {
            System.out.println(i);
            i++;
        }

    }

    public static void MostradorSinIteracion(int a, int b) {
        if (a <= b) {
            System.out.println(a);
            MostradorSinIteracion(a + 1, b);
        }
    }
}