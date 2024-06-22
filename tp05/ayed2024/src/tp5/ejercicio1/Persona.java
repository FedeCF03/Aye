package tp5.ejercicio1;

public class Persona {
    private boolean jubilado = true;
    private String nombre;
    private String domicilio;
    private boolean cobro;

    public Persona(boolean tipo, String nombre, String domicilio, boolean cobro) {
        this.jubilado = tipo;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.cobro = cobro;
    }

    /**
     * @return String return the tipo
     */
    public boolean getjubilado() {
        return jubilado;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setjubilado(boolean tipo) {
        this.jubilado = tipo;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the domicilio
     */
    public String getDomicilio() {
        return domicilio;
    }

    /**
     * @param domicilio the domicilio to set
     */
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    /**
     * @return boolean return the cobro
     */
    public boolean isCobro() {
        return cobro;
    }

    /**
     * @param cobro the cobro to set
     */
    public void setCobro(boolean cobro) {
        this.cobro = cobro;
    }

}
