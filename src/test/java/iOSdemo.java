import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class iOSdemo {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo0Nzg0NSwieHAucCI6MTM0NTQzLCJ4cC5tIjoxNjg2MjczNDY2MTY3LCJleHAiOjIwMjcwMzQwNjQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.MMhQsAZkREfdzZZKosGkJjl_OsmDb-AQpClchGEcXM0";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private final String DEFAULT_NAME = "demoTest1";

    @Parameters("testName")
    @BeforeTest

        public void setUp(@Optional(DEFAULT_NAME) String testName) throws MalformedURLException {
        System.out.println(new Date() + "\t" + "Starting test for - " + testName);
        dc.setCapability("testName", "sdsd");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        dc.setCapability("CustomerDemoName","ATB");
        driver = new IOSDriver<>(new URL("https://partners.experitest.com/wd/hub"), dc);

    }

    @Test
    public void number1() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@id='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@id='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@id='loginButton']")).click();
        driver.findElement(By.xpath("//*[@id='makePaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='phoneTextField']")).sendKeys("0541234567");
        driver.findElement(By.xpath("//*[@id='nameTextField']")).sendKeys("Jon Snow");
        driver.findElement(By.xpath("//*[@id='amountTextField']")).sendKeys("50");
        driver.findElement(By.xpath("//*[@id='countryButton']")).click();
        driver.findElement(By.xpath("//*[@id='Switzerland']")).click();
        driver.findElement(By.xpath("//*[@id='sendPaymentButton']")).click();
        driver.findElement(By.xpath("//*[@id='Yes']")).click();
    }


    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
