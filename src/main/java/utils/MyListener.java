package utils;

import com.codeborne.selenide.WebDriverRunner;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import static java.lang.invoke.MethodHandles.lookup;

public class MyListener extends ReportPortalTestNGListener {
    private final static Logger LOGGER = LoggerFactory.getLogger(lookup().lookupClass().getSimpleName());

    public MyListener() {
        super();
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        String className = testResult.getTestClass().getName().trim();
        String methodName = testResult.getMethod().getMethodName().trim();

        WebDriver webDriver = WebDriverRunner.getWebDriver();

        Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(webDriver);

        File destFile = new File("build/reports/tests/" + className + "/" + methodName + "/" + System.currentTimeMillis() + ".png");

        try {
            ImageIO.write(screenshot.getImage(), "PNG", destFile);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }

        LOGGER.error("RP_MESSAGE#FILE#{}#{}", destFile, "Screenshot");
        super.onTestFailure(testResult);
    }
}
