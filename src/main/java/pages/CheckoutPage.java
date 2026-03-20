package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(WebDriver driver) { this.driver = driver; }

    public void fillInformation(String fName, String lName, String zip) {
        driver.findElement(By.id("first-name")).sendKeys(fName);
        driver.findElement(By.id("last-name")).sendKeys(lName);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
        driver.findElement(By.id("continue")).click();
    }

    public void finishCheckout() {
        driver.findElement(By.id("finish")).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(By.className("complete-header")).getText();
    }
}