public class x {
    private int maximo;

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public void calcularMaximo(int[] args) {
        maximo = args[0];
        for (int arr : args) {
            if (arr > maximo) {
                maximo = arr;
            }
        }
    }
}
