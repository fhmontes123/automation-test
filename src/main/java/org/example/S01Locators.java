package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S01Locators {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();
        // Navegar a google
        driver.get("https://www.google.com/");

        // Buscar el NAME del boton
        // Localizar el elemento, el cuadro de busqueda
//        WebElement searchInput = driver.findElement(By.name("q")); // Localizar por NAME
//        WebElement searchInput = driver.findElement(By.xpath("//*[@id=\"APjFqb\"]")); // Localizar por XPATH
//        WebElement searchInput = driver.findElement(By.cssSelector("#APjFqb")); // Localizar por CSS SELECTOR
//        WebElement searchInput = driver.findElement(By.id("APjFqb")); // Localizar por ID
        WebElement searchInput = driver.findElement(By.className("gLFyf")); // Localizar por CLASE

        // RECOMENDACION
        // 1. Localizar por ID
        // 2. Localizar por NAME
        // 3. Localizar por XPATH

        // Escribir un texto para buscar
        searchInput.sendKeys("Historia de Bolivia");
        // Presionar Enter
        searchInput.submit();
    }
}
