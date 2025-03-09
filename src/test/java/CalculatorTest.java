import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import static org.openqa.selenium.io.FileHandler.copy;

public class CalculatorTest extends Base{


    @Test
    public void testMobile(){
        driver.findElement(AppiumBy.xpath("//*[@searchInput]")).sendKeys("avi");
    }

    @Test
    public void testMobileCal() throws ParserConfigurationException, IOException, SAXException {
        test = extent.createTest("calulator test");
        String num1=readFromFile("num1",configPath);
        String action=readFromFile("action",configPath);
        String num2=readFromFile("num2",configPath);
        String expected=readFromFile("result",configPath);
        for (int i=0; i < num1.length(); i++)
             calculatorPage.click_bottun(num1.charAt(i)+"");
        calculatorPage.click_bottun(action);
        for (int i=0; i < num2.length(); i++)
            calculatorPage.click_bottun(num2.charAt(i)+"");
        calculatorPage.click_bottun("=");
        try {
            String res = calculatorPage.getResult().split(" ")[1];
            Assertions.assertEquals(expected,res);
            test.log(Status.PASS,"test pass");
        } catch (AssertionError e) {
            String msg = e.getMessage().replace('<',' ').replace('>',' ');
            test.log(Status.FAIL, "Test Failed - Assertion failed: "+msg);
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String filePath = "test-output/images/img.png";
            FileHandler.copy(src, new File(filePath));
            test.fail("bad result", MediaEntityBuilder.createScreenCaptureFromPath("images/img.png").build());
        }
    }
}