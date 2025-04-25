package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S16ExpresionesAvanzadasXPath {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.saucedemo.com/");

        WebElement email = driver.findElement(By.xpath("//input[starts-with(@id, 'user')]"));

        email.sendKeys("nuevouser");
    }
}
