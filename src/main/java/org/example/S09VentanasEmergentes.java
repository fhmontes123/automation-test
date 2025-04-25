package org.example;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S09VentanasEmergentes {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/alerts");

        WebElement btnAlert = driver.findElement(By.xpath("//*[@id=\"alertButton\"]"));
        btnAlert.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException();
        }

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }
}
