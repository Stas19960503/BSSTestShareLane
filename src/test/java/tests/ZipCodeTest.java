package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class ZipCodeTest extends BaseTest {

    @Test
    public void checkZipCodeInputWithValidData() {

        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("11111");

        WebElement continueButton = driver.findElement(By.xpath
                ("//input[@value='Continue']"));
        continueButton.click();

        WebElement signUpForm = driver.findElement(By.cssSelector(".yellow_bg"));

        assertTrue(signUpForm.isDisplayed());

    }
}
