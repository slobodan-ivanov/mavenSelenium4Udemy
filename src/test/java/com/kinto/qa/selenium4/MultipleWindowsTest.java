package com.kinto.qa.selenium4;

import com.kinto.qa.config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultipleWindowsTest extends BaseTest {

    @Test
    void multipleWindowsTest() throws IOException {
        waiter(15);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB); // Lessons learned. Opens new blank tab

        // New - with Array list
        ArrayList<String> windows = new ArrayList<>(driver.getWindowHandles());
        String parentWindowId = windows.get(0);
        String childWindowId = windows.get(1);

          // OLD
//        Set<String> windowHandles = driver.getWindowHandles();
//        Iterator<String> iterator = windowHandles.iterator();
//        String parentWindowId = iterator.next();
//        String childWindowId = iterator.next();

        driver.switchTo().window(childWindowId);
        driver.get("https://www.rahulshettyacademy.com/");
        BaseTest.pause(5);

        String firstCourse = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
        System.out.println("firstCourse: " + firstCourse);

        driver.switchTo().window(parentWindowId);
        driver.findElement(By.cssSelector("[name='name']")).sendKeys(firstCourse);
        BaseTest.pause(2);
        //assertEquals(firstCourse, driver.findElement(By.cssSelector("[name='name']")).getText());

    }

}