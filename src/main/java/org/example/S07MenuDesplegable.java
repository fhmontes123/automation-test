package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class S07MenuDesplegable {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a wikipedia
        driver.get("https://www.wikipedia.org/");

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Localizar el menu por su ID
        WebElement menuDesplegable = driver.findElement(By.id("searchLanguage"));
        // Crear un objeto select para interactuar en el codigo
        Select seleccionarLenguage = new Select(menuDesplegable);
        // Seleccionar un idioma por ejemplo Ingles
        seleccionarLenguage.selectByValue("it");

        // Verificar lenguage seleccionado
        String seleccionado = seleccionarLenguage.getFirstSelectedOption().getText();
        System.out.println("Idioma seleccionado: " + seleccionado);
    }
}
