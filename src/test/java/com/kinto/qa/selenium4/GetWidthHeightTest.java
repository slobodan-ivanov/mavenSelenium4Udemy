package com.kinto.qa.selenium4;

import com.kinto.qa.config.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class GetWidthHeightTest extends BaseTest {

    @Test
    void getWidthHeightTest() throws IOException {
        waiter(15);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
        double height = nameInput.getRect().getDimension().getHeight();
        double width = nameInput.getRect().getDimension().getWidth();
        System.out.println("height: " + height);
        System.out.println("width: " + width);

    }

}