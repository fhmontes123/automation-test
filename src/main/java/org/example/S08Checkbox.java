package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class S08Checkbox {
    public static void main(String[] args) {
        // Establecer la ruta del archivo de ChromeDriver
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        // Instanciar ChomeDriver
        WebDriver driver = new ChromeDriver();

        // Navegar a wikipedia
        driver.get("https://www.w3schools.com/html/html_forms.asp");

        // Maximizar la ventana
        // driver.manage().window().maximize();

        // Localizar elementos checkbox
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        // Seleccionar las casillas "bike" y "boat"
        for (WebElement checkbox : checkboxes) {
            // Obtener valor del atributo
            String value = checkbox.getDomProperty("value");
            // Verificar valor
            if ("Bike".equals(value) || "Boat".equals(value)) {
                // Verificar que la casilla no este seleccionada
                if (!checkbox.isDisplayed()) {
                    // Hacer clic
                    checkbox.click();
                }
            }
        }
    }
}
