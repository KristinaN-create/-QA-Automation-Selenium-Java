package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(groups = "regression")
    public void testAddToCart() {
        login("standard_user", "secret_sauce");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String badgeValue = driver.findElement(By.className("shopping_cart_badge")).getText();
        Assert.assertEquals(badgeValue, "1", "Бројот во кошничката не е точен!");
    }

    @Test(groups = "regression")
    public void testRemoveFromCart() {
        login("standard_user", "secret_sauce");
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.id("remove-sauce-labs-backpack")).click();

        // Проверка дека иконата за број на продукти веќе не постои
        int badges = driver.findElements(By.className("shopping_cart_badge")).size();
        Assert.assertEquals(badges, 0, "Продуктот не е избришан од кошничката!");
    }
}