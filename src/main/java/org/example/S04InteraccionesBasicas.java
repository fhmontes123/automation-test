package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S04InteraccionesBasicas {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a google
        driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Localizar input mediante name
        WebElement inputBuscar = driver.findElement(By.name("search"));
        // Ingresar texto a buscar
        inputBuscar.sendKeys("Bolivia");
        // Hacer ENTER
        inputBuscar.submit();
    }
}
