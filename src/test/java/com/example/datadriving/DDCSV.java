package com.example.datadriving;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DDCSV {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public static void main(String[] args) {
        // CONFIGURAR PREFERENCIAS DE CHROME
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        // CONFIGURAR WEBDRIVER
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://www.saucedemo.com");
        // LEER LOS DATOS DESDE UN ARCHIVO CSV
        String csvFilePath = "files/Usuarios.csv"; // RUTA AL ARCHIVO CSV
        // CREAR UN CSVREADER PARA LEER EL ARCHIVO
        try (CSVReader csvReader = new CSVReader(new FileReader(csvFilePath))) {
            // LEER ENCABEZADOS DE LAS COLUMNAS
            String[] headers = csvReader.readNext();
            String[] line;
            // LEER CADA LINEA DEL ARCHIVO CSV
            while ((line = csvReader.readNext()) != null) {
                String username = line[0]; // LEER EL VALOR DE LA PRIMERA COLUMNA
                String password = line[1]; // LEER EL VALOR DE LA SEGUNDA COLUMNA
                // EJECUTAR LA PRUEBA PARA CADA USUARIO
                performLogin(username, password);
            }
        } catch (IOException | CsvValidationException ex) {
            // CAPTURAR ERROR
            ex.printStackTrace();
        } finally {
            // CERRAR EL NAVEGADOR Y FINALIZAR LA SESION
            driver.quit();
        }
    }

    private static void performLogin(String username, String password) {
        driver.get("https://www.saucedemo.com");
        // INICIAR SESION
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        WebElement loginButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));

        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.click();
        passwordField.sendKeys(password);
        loginButton.click();

        // VALIDAR INICIO DE SESION
        try {
            WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(.,'Products')]")));
            System.out.println("Acceso " + username + " " + productTitle.isDisplayed());
        } catch (Exception ex) {
            // CAPTURAR EL MENSAJE DE USUARIO BLOQUEADO
            // ENCONTRAR EL MENSAJE DE ERROR
            WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
            if (errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out.")) {
                System.out.println("El usuario esta bloqueado " + username);
                takeScreenShot(driver, username);
            } else {
                // IMPRIMIR OTRO TIPO DE ERROR
                System.out.println("error " + username + ex.getMessage());
            }
        }
    }

    // METODO PARA SACAR CAPTURA DE PANTALLA
    private static void takeScreenShot(WebDriver driver, String username) {
        try {
            // TOMAR LA CAPTURA
            File screenShotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // GENERAR NOMBRE UNICIO PARA LA CAPTURA
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String screenShotName = "bloqueado" + username + "_" + timestamp + ".png";
            // DEFINIR LA RUTA DONDE SE GUARDARA EL ARCHIVO O CAPTURA DE PANTALLA
            Path destination = Paths.get("screenshots", screenShotName);
            // CREAR EL DIRECTORIO SI NO EXISTE
            Files.createDirectories(destination.getParent());
            // COPIAMOS EN EL DESTINO
            Files.copy(screenShotFile.toPath(), destination);
            System.out.println("ScreenShot save " + destination.toAbsolutePath());
        } catch (IOException ex) {
            // MANEJAMOS CUALQUIER ERROR QUE OCURRE
            System.err.println("Error al sacar la captura de pantalla " + ex.getMessage());
        }
    }
}