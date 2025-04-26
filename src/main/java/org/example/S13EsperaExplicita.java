package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class S13EsperaExplicita {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com");
        //  Configurar una espera explicita de 10 segundos
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Limite maximo

        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));

        emailField.sendKeys("nuevousuario");
    }
}
