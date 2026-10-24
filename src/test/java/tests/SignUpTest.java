package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SignUpTest {

    @Test
    public void checkZipCodeInputWithValidData() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("11111");

        WebElement continueButton = driver.findElement(By.xpath("//input[@value='Continue']"));
        continueButton.click();

        WebElement signUpForm = driver.findElement(By.cssSelector(".yellow_bg"));

        assertTrue(signUpForm.isDisplayed());

        driver.quit();
    }

    @Test
    public void checkSignUpFormWithValidData() throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("11111");
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        Thread.sleep(10000);

        driver.findElement(By.name("first_name")).sendKeys("Иван");
        driver.findElement(By.name("last_name")).sendKeys("Иванов");
        driver.findElement(By.name("email")).sendKeys("test_user_123@example.com");
        driver.findElement(By.name("password")).sendKeys("Qwerty12345");
        driver.findElement(By.name("password_confirmation")).sendKeys("Qwerty12345");
        driver.findElement(By.name("zip_code")).sendKeys("11111");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        Thread.sleep(10000);

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Account is created!"), "Ошибка: регистрация не удалась!");

        driver.quit();
    }
}