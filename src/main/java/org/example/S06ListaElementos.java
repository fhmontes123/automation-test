package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class S06ListaElementos {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a wikipedia
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Localizar encabezados de articulos destacados
        List<WebElement> articulos = driver.findElements(By.cssSelector("#mp-upper .mp-h2"));
        // Imprimir los titulos
        for (WebElement articulo : articulos) {
            System.out.println("Titulo: " + articulo.getText());
        }
    }
}
