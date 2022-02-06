package listeners;

import driver.DriverManager;
import io.qameta.allure.Attachment;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Log4j2
public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        log.info(String.format("Starting test '%s'", getTestName(result)));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info(String.format("Test '%s' is passed", getTestName(result)));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.info(String.format("Test '%s' is FAILED", getTestName(result)));
        saveScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        log.info(String.format("Test '%s' is FAILED WITH TIMEOUT", getTestName(result)));
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }

    public String getTestName(ITestResult result) {
        Method method = result.getMethod().getConstructorOrMethod().getMethod();
        Test test = method.getAnnotation(Test.class);
        return test.testName();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
