package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class S10ManejoVentanas {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        String originalTab = driver.getWindowHandle(); // Capturar identificador pagina Inicial Facebook

        driver.switchTo().newWindow(WindowType.TAB);  // Abre nueva pestaña en el navegador
        driver.get("https://www.facebook.com/help");
        String nuevaTab = driver.getWindowHandle();  // Capturar identificador pagina Ayuda Facebook

        // Esperar 2 segundos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        // Abrir pestaña de la pagina Inicial Facebook
        driver.switchTo().window(originalTab);

        // Esperar 2 segundos
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        // Mostrar los identificadores de las pestañas
        System.out.println("Pestaña Inicial Facebook: " + originalTab);
        System.out.println("Pestaña Ayuda Facebook: " + nuevaTab);
    }
}
