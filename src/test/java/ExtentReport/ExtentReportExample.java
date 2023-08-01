package ExtentReport;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.kinto.qa.config.BaseTest;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class ExtentReportExample extends BaseTest {

    @Test
    public void extentReportTest() throws IOException {
        waiter(15);
        driver.manage().window().maximize();
        driver.get("https://www.rahulshettyacademy.com/angularpractice/");

        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        ExtentTest test1 = extent.createTest("extentReportTest", "test to validate extentReportTest ");
        test1.log(Status.INFO, "Starting test case");
        test1.pass("Passed");
        extent.flush();


    }
}
