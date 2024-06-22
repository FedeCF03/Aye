import java.util.ArrayList;
import java.util.List;

public class max {
    public List<Integer> aux = new ArrayList<Integer>();

    public List<Integer> res = new ArrayList<Integer>();
    public int max = 0;
    public int aux_max = 0;

    public max() {
    };

    public List<Integer> getRes() {
        return res;
    }

    public void setRes(List<Integer> res) {
        this.res = res;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}