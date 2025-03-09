
import Pageobject.CalculatorPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Base {

    //    attributes
    CalculatorPage calculatorPage;

    //    public static WebDriver driver;
    public static AndroidDriver driver;
    static String configPath = "C:\\Users\\m\\IdeaProjects\\Mobile3\\src\\testData\\config.xml";




    static ExtentReports extent;
    static ExtentTest test;

    @BeforeAll
    public static void setUp() throws Exception {
        // Initialize Extent report
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium:noReset", true);
        capabilities.setCapability("platformName", "android");
        capabilities.setCapability("appium:deviceName", "Android Device");
//        capabilities.setCapability("appium:appPackage", "com.android.chrome");//
//        capabilities.setCapability("appium:appActivity", "com.google.android.apps.chrome.Main");
        capabilities.setCapability("appium:appPackage", "com.miui.calculator");//
        capabilities.setCapability("appium:appActivity", ".cal.CalculatorActivity");
        capabilities.setCapability("appium:newCommandTimeout", 120);
        capabilities.setCapability("appium:hideKeyboard", true);
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        driver = new AndroidDriver(new URL("http://localhost:4723"), capabilities);
    }

    @BeforeEach
    public void intialzing() {
        calculatorPage = new CalculatorPage(driver);
        driver.activateApp("com.miui.calculator");
        //   driver.get("https://www.wikipedia.com");
    }

    @AfterAll
    public static void close(){
        extent.flush();
    }

    public static String readFromFile(String keyData, String pathName) throws ParserConfigurationException, IOException, SAXException {
        String value = null;
        try {
            // Load the XML file
            File xmlFile = new File(pathName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            // Normalize the document
            doc.getDocumentElement().normalize();

            // Extract values from XML
            value = doc.getElementsByTagName(keyData).item(0).getTextContent();

        } catch (AssertionError e) {
            e.printStackTrace();
        }
        return value;
    }
}