package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S11Frames {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/TAGS/tryit.asp?filename=tryhtml_iframe");

        // Ingresa Frame Resultante
        driver.switchTo().frame("iframeResult");
        // Ingresa Frame de la pagina
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe"))); // /html/body/iframe
        // Localizar boton Login
        WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"pagetop\"]/div[3]/a[1]")); // //*[@id="pagetop"]/div[3]/a[1]
        // Click
        iframeElement.click();
    }
}
