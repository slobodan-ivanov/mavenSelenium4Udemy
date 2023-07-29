package com.kinto.qa.config;

import com.kinto.qa.util.KintoTestWatcher;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.StringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;

@ExtendWith(KintoTestWatcher.class)
@Slf4j
public class BaseTest {
  public static WebDriver driver;
  public static File scrFile;
  public static RunEnvironment runEnvironment;

  protected final static String baseURL = "https://ui.kinto-digital-com-dev.xyz/?path=/story";

  public static String QASE_API_TOKEN_VALUE;
  public static String QASE_PROJECT_CODE_VALUE;

  @BeforeAll
  public static void setupClass() {

    runEnvironment = RunEnvironment.LOCAL;
  }

  @BeforeEach
  public void setupTest() throws MalformedURLException {
    if (runEnvironment == RunEnvironment.LOCAL) {
      driver = new ChromeDriver();
    } else if (runEnvironment == RunEnvironment.JENKINS) {
      ChromeOptions chromeOptions = new ChromeOptions();
      URL server = new URL("http://selenium-hub-44:4444/wd/hub");
      driver = new RemoteWebDriver(server, chromeOptions);
    }
  }

  @AfterEach
  public void teardownTest() {
    scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    if (driver != null) {
      driver.quit();
    }
  }

  @AfterAll
  public static void teardown() {
    if (driver != null) {
      driver.quit();
    }
  }

  public static String getFormattedDate() {
    Date date = Calendar.getInstance().getTime();
    DateFormat dateFormat = new SimpleDateFormat("yyMMdd_HHmmss");
    return dateFormat.format(date);
  }

  public static WebDriverWait waiter() {
    // todo move to BasePage when refactoring - or remove completely
    waitImplicitMillis(150);
    return new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
  }

  public static WebDriverWait waiter(final Integer seconds) {
    // todo move to BasePage when refactoring - or remove completely
    return new WebDriverWait(driver, Duration.ofSeconds(seconds), Duration.ofMillis(500));
  }

  public static void waitImplicitMillis(final Integer milliseconds) {
    // todo move to BasePage when refactoring - or remove completely
    try {
      Thread.sleep(milliseconds);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public static void pause(int seconds) {
    try {
      Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void pauseInMilliSeconds(int milliSeconds) {
    try {
      Thread.sleep(milliSeconds);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  public static void clear(WebDriver driver, By locator) {
    String os = System.getProperty("os.name").toLowerCase();
    if (os.contains("win")) {
      driver.findElement(locator).sendKeys(Keys.CONTROL, "a");
    } else if (os.contains("mac")) {
      driver.findElement(locator).sendKeys(Keys.COMMAND, "a");
    }
    driver.findElement(locator).sendKeys(Keys.BACK_SPACE);
  }

  public enum RunEnvironment {
    JENKINS,
    LOCAL
  }
}
