package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S02EventoClic {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();
        // Navegar a google
        driver.get("https://www.google.com/");

        // Localizar Boton Inicar Sesion por XPATH
        WebElement botonAcceder = driver.findElement(By.xpath("//*[@id=\"gb\"]/div/div[2]/a"));
        // Hacer click sobre el boton
        botonAcceder.click();

        // Cerrar navegador
        driver.quit();
    }
}
