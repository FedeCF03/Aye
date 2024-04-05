public class Profesor {
    private String Nombre;
    private String Apellido;
    private String Email;
    private String catedra;
    private String facultad;

    public Profesor(String Nombre, String Apellido, String Email, String catedra, String facultad) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Email = Email;
        this.catedra = catedra;
        this.facultad = facultad;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public void tusDatos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Email: " + getEmail());
        System.out.println("Catedra: " + getCatedra());
        System.out.println("Facultad: " + getFacultad());
    }
}
