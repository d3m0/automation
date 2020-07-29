package utils;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

import static java.lang.invoke.MethodHandles.lookup;

public class MyListener extends ReportPortalTestNGListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass());

    public MyListener() {
        super();
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        String className = testResult.getTestClass().getName().trim();
        String methodName = testResult.getMethod().getMethodName().trim();

        WebDriver webDriver = WebDriverRunner.getWebDriver();
        File tmpFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        File destFile = new File("build/reports/tests/" + className + "/" + methodName + "/" + System.currentTimeMillis() + ".png");
        try {
            FileUtils.copyFile(tmpFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        LOGGER.error("RP_MESSAGE#FILE#{}#{}", destFile, "Screenshot");
        super.onTestFailure(testResult);
    }
}
