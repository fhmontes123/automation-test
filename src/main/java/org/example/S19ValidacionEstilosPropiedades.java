package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class S19ValidacionEstilosPropiedades {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement btnLogin = driver.findElement(By.id("login-button"));
        btnLogin.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement msgError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.error-message-container")));

        System.out.println("Mensaje de error visible: " + msgError.isDisplayed());

        String color = msgError.getCssValue("background-color");
        System.out.println("Color de fondo del mensaje de error: " + color);

        Dimension size = msgError.getSize();
        System.out.println("Ancho del mensaje: " + size.getWidth());
    }
}
