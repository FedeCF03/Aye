
public class App {
    public static void arraySizeN(int n) {
        int[] array = new int[n];
        for (int i = 1; i <= n; i++) {
            array[i - 1] = i * n;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        arraySizeN(5);
    }
}
