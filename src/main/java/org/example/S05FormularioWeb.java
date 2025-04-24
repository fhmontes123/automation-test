package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S05FormularioWeb {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a wikipedia
        driver.get("https://auth.wikimedia.org/eswiki/wiki/Especial:Crear_una_cuenta");

        // Maximizar la ventana
        driver.manage().window().maximize();

        // Localizar input usuario
        WebElement inputUsuario = driver.findElement(By.id("wpName2"));
        inputUsuario.sendKeys("juanperes6544");

        // Localizar input password
        WebElement inputPassword = driver.findElement(By.id("wpPassword2"));
        inputPassword.sendKeys("Password*123");

        // Localizar input password
        WebElement repPassword = driver.findElement(By.id("wpRetype"));
        repPassword.sendKeys("Password*123");

    }
}
