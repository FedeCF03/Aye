public class AreaEmpresa {
    private String empresa;
    private int tardanzaTransmisionMensajes;

    public AreaEmpresa(String empresa, int tardanzaTransmisionMensajes) {
        this.empresa = empresa;
        this.tardanzaTransmisionMensajes = tardanzaTransmisionMensajes;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public int gettardanzaTransmisionMensajes() {
        return tardanzaTransmisionMensajes;
    }

    public void settardanzaTransmisionMensajes(int tardanzaTransmisionMensajes) {
        this.tardanzaTransmisionMensajes = tardanzaTransmisionMensajes;
    }

}
