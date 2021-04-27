package com.sample.test.demo.tests;

import com.sample.test.demo.TestBase;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

//Problem : After order submission, values are not get cleared from the Pizza Selection
//Problem:  No validation on Pizza, Toppings selection and Quantity

public class DemoTest extends TestBase {

    //Happy Path Scenario
    @Test
    public void successfulOrderSubmission() {
        Select pizza1Pizza = new Select(driver.findElement(new By.ById("pizza1Pizza")));
        pizza1Pizza.selectByValue("Small 6 Slices - no toppings");

        Select pizza1Toppings1 = new Select(driver.findElement(new By.ByXPath("//div[@id='pizza1']//select[@class='toppings1']")));
        pizza1Toppings1.selectByValue("Mushrooms");

        Select pizza1Toppings2 = new Select(driver.findElement(new By.ByXPath("//div[@id='pizza1']//select[@class='toppings2']")));
        pizza1Toppings2.selectByValue("Caramelized onions");

        WebElement quantity = driver.findElement(new By.ById("pizza1Qty"));
        quantity.clear();
        quantity.sendKeys("1");

        WebElement cost = driver.findElement(new By.ById("pizza1Cost"));
        cost.click();

        WebElement email = driver.findElement(new By.ById("email"));
        email.sendKeys("abcdef@gamil.com");

        WebElement name = driver.findElement(new By.ById("name"));
        name.sendKeys("abc def");

        WebElement phone = driver.findElement(new By.ById("phone"));
        phone.sendKeys("+2378661234");

        WebElement cashPayment = driver.findElement(new By.ById("cashpayment"));
        cashPayment.click();

        WebElement placeOrderButton = driver.findElement(new By.ById("placeOrder"));
        placeOrderButton.click();

        WebElement dialogText = driver.findElement(new By.ByXPath("//div[@id='dialog']/p"));

        String result = dialogText.getText();
        String expected = "Thank you for your order! TOTAL: 6.75 Small 6 Slices - no toppings";

        driver.findElement(new By.ByXPath("//div[5]/div[1]/button/span[1]")).click();

        Assert.assertEquals(expected, result);

    }

    //Name validation fails
    @Test
    public void nameValidationFailedCheck() {
        Select pizza1Pizza = new Select(driver.findElement(new By.ById("pizza1Pizza")));
        pizza1Pizza.selectByValue("Small 6 Slices - no toppings");

        Select pizza1Toppings1 = new Select(driver.findElement(new By.ByXPath("//div[@id='pizza1']//select[@class='toppings1']")));
        pizza1Toppings1.selectByValue("Mushrooms");

        Select pizza1Toppings2 = new Select(driver.findElement(new By.ByXPath("//div[@id='pizza1']//select[@class='toppings2']")));
        pizza1Toppings2.selectByValue("Caramelized onions");

        WebElement quantity = driver.findElement(new By.ById("pizza1Qty"));
        quantity.clear();
        quantity.sendKeys("1");

        WebElement cost = driver.findElement(new By.ById("pizza1Cost"));
        cost.click();

        WebElement phone = driver.findElement(new By.ById("phone"));
        phone.sendKeys("+2378661234");

        WebElement cashPayment = driver.findElement(new By.ById("cashpayment"));
        cashPayment.click();

        WebElement placeOrderButton = driver.findElement(new By.ById("placeOrder"));
        placeOrderButton.click();

        WebElement dialogText = driver.findElement(new By.ByXPath("//div[@id='dialog']/p"));

        String result = dialogText.getText();
        String expected = "Missing name";

        driver.findElement(new By.ByXPath("//div[5]/div[1]/button/span[1]")).click();

        Assert.assertEquals(expected, result);
    }

}
