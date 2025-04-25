package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class S12ArrastrarSoltar {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");

        driver.switchTo().frame("iframeResult");

        WebElement div = driver.findElement(By.id("div1"));
        WebElement img = driver.findElement(By.id("img1"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(img, div).perform();
    }
}
