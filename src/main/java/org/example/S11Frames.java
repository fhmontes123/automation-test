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

        driver.switchTo().frame("iframeResult");
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/iframe")));

        WebElement iframeElement = driver.findElement(By.xpath("//*[@id=\"pagetop\"]/div[3]/a[1]"));

        iframeElement.click();
    }
}
