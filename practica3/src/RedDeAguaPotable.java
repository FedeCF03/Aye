import java.util.List;

public class RedDeAguaPotable {
    private GeneralTree<Character> ab;

    RedDeAguaPotable(GeneralTree<Character> ab) {
        this.ab = ab;
    }

    private double minimoCaudalHelper(double caudal, GeneralTree<Character> ab, double min) {
        List<GeneralTree<Character>> childs = ab.getChildren();
        if (childs.size() > 0) {
            double caudalDiv = caudal / childs.size();
            min = Math.min(min, caudalDiv);
            System.err.println('a');

            for (GeneralTree<Character> generalTree : childs) {
                min = minimoCaudalHelper(caudalDiv, generalTree, min);
            }
        }

        return min;
    }

    public double minimoCaudal(double caudal) {
        double minimo = caudal;
        if (!(ab.isEmpty())) {
            minimo = minimoCaudalHelper(caudal, this.ab, minimo);
        }
        return minimo;

    }

}
