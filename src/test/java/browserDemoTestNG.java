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

public class browserDemoTestNG {

    private String accessKey = "eyJhbGciOiJIUzI1NiJ9.eyJ4cC51Ijo0Nzg0NSwieHAucCI6MTM0NTQzLCJ4cC5tIjoxNjg2MjczNDY2MTY3LCJleHAiOjIwMjcwMzQwNjQsImlzcyI6ImNvbS5leHBlcml0ZXN0In0.MMhQsAZkREfdzZZKosGkJjl_OsmDb-AQpClchGEcXM0";
    protected IOSDriver<IOSElement> driver = null;
    DesiredCapabilities dc = new DesiredCapabilities();
    private final String DEFAULT_NAME = "demoTest1";


    @BeforeTest()
    public void setUp(@Optional(DEFAULT_NAME) String testName) throws MalformedURLException {
        dc.setCapability("testName", "Quick Start iOS Native Demo");
        dc.setCapability("accessKey", accessKey);
        dc.setCapability("deviceQuery", "@os='ios' and @category='PHONE'");
        dc.setCapability(MobileCapabilityType.APP, "cloud:com.experitest.ExperiBank");
        dc.setCapability(IOSMobileCapabilityType.BUNDLE_ID, "com.experitest.ExperiBank");
        driver = new IOSDriver<>(new URL("https://partners.experitest.com/wd/hub"), dc);
    }

    @Test
    public void quickStartiOSNativeDemo() {
        driver.rotate(ScreenOrientation.PORTRAIT);
        driver.findElement(By.xpath("//*[@label='usernameTextField']")).sendKeys("company");
        driver.hideKeyboard();
        driver.findElement(By.xpath("//*[@label='passwordTextField']")).sendKeys("company");
        driver.findElement(By.xpath("//*[@label='Login']")).click();
        driver.findElement(By.xpath("//*[@label='Make Payment']")).click();
        driver.findElement(By.xpath("//*[@label='phoneTextField']")).sendKeys("0912345678");
        driver.findElement(By.xpath("//*[@label='nameTextField']")).sendKeys("Test Acc");
        driver.findElement(By.xpath("//*[@label='amountTextField']")).sendKeys("10");
        driver.findElement(By.xpath("//*[@label='countryButton']")).click();
        driver.findElement(By.xpath("//*[@label='USA']")).click();
        driver.findElement(By.xpath("//*[@label='Send Payment']")).click();
        driver.findElement(By.xpath("//*[@label='Yes']")).click();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
