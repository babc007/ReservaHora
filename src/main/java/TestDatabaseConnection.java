import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@RunWith(JUnit4.class)
public class TestDatabaseConnection {
    
    // Configuración de la conexión a la base de datos
    private final String jdbcUrl = "jdbc:mysql://localhost:3306/petsmile";
    private final String usuario = "root";
    private final String contraseña = "Amalia241122@";

    @Test
    public void testConexionExitosa() {
        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, usuario, contraseña);
            assertNotNull(conn); // Asegurarse de que la conexión no sea nula
            conn.close();
        } catch (SQLException e) {
            fail("La conexión a la base de datos no debería fallar: " + e.getMessage());
        }
    }

    @Test
    public void testConexionFallida() {
        try {
            // Cambiar el usuario o contraseña a valores incorrectos para simular una conexión fallida
            Connection conn = DriverManager.getConnection(jdbcUrl, "usuario_incorrecto", "contraseña_incorrecta");
            assertNull(conn); // Asegurarse de que la conexión sea nula en caso de error
        } catch (SQLException e) {
            // La excepción es esperada en este caso
        }
    }
}
