public class Test {
    public static void main() {
        Estudiante estudiante1 = new Estudiante("Juan", "Perez", "1", "sadas.com", "siempre viva");
        Estudiante estudiante2 = new Estudiante("fede", "Perez", "2", "sfghdadas.com", "siemprasdase viva");
        Profesor profesor1 = new Profesor("Juanito", "Padaserez", "1", "saddfghuighfsas.com", "siempre vivaaaa");
        Profesor profesor2 = new Profesor("Juanitoasxdas", "Padgsdfaserez", "1", "saddfghuighfsas.com",
                "siempre vivaaaa");
        Profesor profesor3 = new Profesor("Juanitooaoao", "Pasfsdgmkisdfmgadaserez", "1", "saddfghasdfuighfsas.com",
                "siempre vivaaasdfasaa");

        Estudiante[] estudiantes = { estudiante1, estudiante2 };
        Profesor[] profesores = { profesor1, profesor2, profesor3 };

        for (Estudiante estudiante : estudiantes) {
            estudiante.tusDatos();
        }
        for (Profesor profesor : profesores) {
            profesor.tusDatos();
        }
    }

}
