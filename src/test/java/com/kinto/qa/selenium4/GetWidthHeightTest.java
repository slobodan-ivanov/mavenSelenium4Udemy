package com.kinto.qa.selenium4;

import com.kinto.qa.config.BaseTest;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class GetWidthHeightTest extends BaseTest {

    @Test
    void getWidthHeightTest() throws IOException {
        waiter(15);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
        double height = nameInput.getRect().getDimension().getHeight();
        double width = nameInput.getRect().getDimension().getWidth();
        System.out.println("height: " + height);
        System.out.println("width: " + width);

    }

}