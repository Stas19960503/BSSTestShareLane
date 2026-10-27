package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SignUpTest extends BaseTest {

    @Test
    public void checkSignUpFormWithValidData() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");

        driver.findElement(By.name("first_name")).sendKeys("Иван");
        driver.findElement(By.name("last_name")).sendKeys("Иванов");
        driver.findElement(By.name("email")).sendKeys("test_user_123@example.com");
        driver.findElement(By.name("password1")).sendKeys("Qwerty12345");
        driver.findElement(By.name("password2")).sendKeys("Qwerty12345");

        driver.findElement(By.xpath("//input[@value='Register']")).click();

        String text = driver.findElement(By.cssSelector(".confirmation_message")).getText();

        assertEquals(text, "Account is created!", "Текст не совпадает");
    }
}
