package automation.utils;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@Slf4j
public class MyListener extends ReportPortalTestNGListener {

    public MyListener() {
        super();
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        String className = testResult.getTestClass().getName().trim();
        String methodName = testResult.getMethod().getMethodName().trim();

        WebDriver webDriver = WebDriverRunner.getWebDriver();
        File destFile = new File("build/reports/tests/" + className + "/" + methodName + "/" + System.currentTimeMillis() + ".png");

        try {
            takeScreenshotWithSeleniumWebDriver((TakesScreenshot) webDriver, destFile);
            getScreenshotByAShot(webDriver, destFile);
        } catch (IOException exception) {
            log.error(exception.getMessage(), exception);
        }

        log.error("RP_MESSAGE#FILE#{}#{}", destFile, "Screenshot");
        super.onTestFailure(testResult);
    }

    private void takeScreenshotWithSeleniumWebDriver(TakesScreenshot webDriver, File destFile) throws IOException {
        File tmpFile = webDriver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tmpFile, destFile);
    }

    private void getScreenshotByAShot(WebDriver webDriver, File destFile) throws IOException {
        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(10))
                .takeScreenshot(webDriver);
        ImageIO.write(screenshot.getImage(), "PNG", destFile);
    }
}