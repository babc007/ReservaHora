import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // Datos de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/petsmile"; // URL de la base de datos
    private static final String USUARIO = "root"; // Usuario de la base de datos
    private static final String CONTRASENA = "Amalia241122@"; // Contraseña de la base de datos

    public static boolean probarConexion() {
        try {
            // Cargar el controlador de MySQL (asegúrate de tener la biblioteca MySQL Connector/J en tu proyecto)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establecer la conexión a la base de datos
            Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);

            // Si la conexión se establece con éxito, cerrarla y devolver true
            conexion.close();
            return true;
        } catch (ClassNotFoundException e) {
            System.err.println("Error: No se pudo cargar el controlador de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("Error: No se pudo establecer la conexión a la base de datos.");
            e.printStackTrace();
        }

        // Si ocurre cualquier excepción, devolver false
        return false;
    }

    public static void main(String[] args) {
        boolean conexionExitosa = probarConexion();
        if (conexionExitosa) {
            System.out.println("Conexión a la base de datos exitosa.");
        } else {
            System.out.println("No se pudo conectar a la base de datos.");
        }
    }
}
