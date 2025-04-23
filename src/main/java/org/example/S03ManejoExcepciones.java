package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class S03ManejoExcepciones {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a google
        driver.get("https://www.google.com/");

        // MANEJO DE EXCEPCIONES
        try {
            // CODIGO DONDE TAL VEZ EXISTA EXCEPCION
            // Localizar Boton Inicar Sesion por XPATH
            WebElement botonAcceder = driver.findElement(By.xpath("ID_INEXISTENTE"));
            // Hacer click sobre el boton
            botonAcceder.click();
        } catch (NoSuchElementException ex) {
            // CAPTURAR EL ERROR 1
            System.out.println("El elemento no fue encontrado: " + ex);
        } catch (TimeoutException ex) {
            // CAPTURAR EL ERROR 2
            System.out.println("El elemento no fue encontrado por el tiempo: " + ex);
        } finally {
            // EJECUTAR UN PROCESO EXISTA O NO ERROR
            // Cerrar navegador
            driver.quit();
        }
    }
}
