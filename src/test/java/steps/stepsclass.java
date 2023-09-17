package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class stepsclass {

    private WebDriver driver;
    private Connection dbConnection;

    // Constructor para inyectar el objeto WebDriver
    public stepsclass(WebDriver driver) {
        this.driver = driver;
    }

    // Métodos que representan los pasos de tu escenario en Gherkin

    @Given("que estoy en la página de inicio de sesión")
    public void que_estoy_en_la_página_de_inicio_de_sesión() {
        // Implementa el código para navegar a la página de inicio de sesión
        driver.get("URL_de_la_Página_de_Inicio_de_Sesión");
    }

    @When("ingreso el nombre de usuario almacenado en la BD")
    public void ingreso_el_nombre_de_usuario_almacenado_en_la_BD() {
        // Implementa el código para ingresar el nombre de usuario desde la BD
        String nombreDeUsuario = obtenerNombreDeUsuarioDesdeBD();
        driver.findElement(By.id("id_del_campo_nombre_usuario")).sendKeys(nombreDeUsuario);
    }

    @When("presiono el botón de inicio de sesión")
    public void presiono_el_botón_de_inicio_de_sesión() {
        // Implementa el código para hacer clic en el botón de inicio de sesión
        driver.findElement(By.id("id_del_boton_inicio_sesión")).click();
    }

    @Then("debería estar en la página de inicio")
    public void debería_estar_en_la_página_de_inicio() {
        // Implementa las aserciones para verificar si estás en la página de inicio
        String tituloDePagina = driver.getTitle();
        assertEquals("Título de la página de inicio", tituloDePagina);
    }

    // Método para obtener el nombre de usuario desde la BD
    private String obtenerNombreDeUsuarioDesdeBD() {
        String url = "jdbc:mysql://localhost:3306/petsmile";
        String usuario = "root";
        String contraseña = "Amalia241122@";

        try {
            if (dbConnection == null || dbConnection.isClosed()) {
                dbConnection = DriverManager.getConnection(url, usuario, contraseña);
            }

            Statement statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT nombre_usuario FROM tabla_usuario WHERE ..."); // Sustituye por tu consulta SQL real

            if (resultSet.next()) {
                return resultSet.getString("nombre_usuario");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // Manejo de errores: devuelve null si no se encuentra el nombre de usuario
    }
}
