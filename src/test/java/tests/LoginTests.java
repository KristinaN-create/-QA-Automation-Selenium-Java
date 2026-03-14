package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test(groups = "smoke")
    public void testSuccessfulLogin() {
        login("standard_user", "secret_sauce");
        boolean isInventoryVisible = driver.findElement(By.className("inventory_list")).isDisplayed();
        Assert.assertTrue(isInventoryVisible, "Логирањето не е успешно!");
    }

    @Test(groups = "regression")
    public void testLockedOutUser() {
        login("locked_out_user", "secret_sauce");
        String error = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertTrue(error.contains("Sorry, this user has been locked out"), "Не се појави точната грешка!");
    }
}

