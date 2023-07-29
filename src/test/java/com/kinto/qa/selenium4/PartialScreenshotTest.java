package com.kinto.qa.selenium4;

import com.kinto.qa.config.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class PartialScreenshotTest extends BaseTest {

    @Test
    void locatorTest() throws IOException {
        waiter(15);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
        nameInput.sendKeys("Selenium practise for partial screenshot");
        File file = nameInput.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("logo.png"));

    }

}