import java.util.LinkedList;
import java.util.List;

public class Dato {
    private Integer maxC = 0;
    private List<Integer> maxL = new LinkedList<Integer>();
    private Integer auxC = 0;
    private List<Integer> L = new LinkedList<Integer>();

    public Dato() {
    }

    public Integer getMaxC() {
        return maxC;
    }

    public void setMaxC(Integer maxC) {
        this.maxC = maxC;
    }

    public void incAuxC(int increment) {
        this.auxC += increment;
    }

    public void decAuxC(int increment) {
        this.auxC -= increment;
    }

    public List<Integer> getMaxL() {
        return maxL;
    }

    public void setMaxL(List<Integer> maxL) {
        this.maxL = maxL;
    }

    public Integer getAuxC() {
        return auxC;
    }

    public void setAuxC(Integer auxC) {
        this.auxC = auxC;
    }

    public List<Integer> getL() {
        return L;
    }

    public void setL(List<Integer> l) {
        L = l;
    }

}
