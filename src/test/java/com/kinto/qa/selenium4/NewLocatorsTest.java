package com.kinto.qa.selenium4;

import com.kinto.qa.config.BaseTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class NewLocatorsTest extends BaseTest {

    @Test
    void locatorTest() {
        waiter(15);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        // .above()
        WebElement nameInput = driver.findElement(By.cssSelector("[name='name']"));
        String nameLabelText = driver.findElement(with(By.tagName("label")).above(nameInput)).getText();
        System.out.println("dateofBirth: " + nameLabelText);

        // .below()
        WebElement dateOfBirthLabel = driver.findElement(By.cssSelector("label[for='dateofBirth']"));
        driver.findElement(with(By.tagName("input")).below(dateOfBirthLabel)).click();

        // .toLeftOf()
        WebElement labelCheckbox = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));
        driver.findElement(with(By.tagName("input")).toLeftOf(labelCheckbox)).click();

        WebElement firstRadioButton = driver.findElement(By.id("inlineRadio1"));
        String firstRadioButtonLabelText = driver.findElement(with(By.tagName("label")).toRightOf(firstRadioButton)).getText();
        assertEquals("Student", firstRadioButtonLabelText);

    }

}