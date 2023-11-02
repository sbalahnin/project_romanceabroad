package com.romanceabroad.ui;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class BaseUISauceLabs {


    WebDriver driver;
    WebDriverWait wait;
    MainPage mainPage;
    SearchPage searchPage;
    HowWeWorkPage howWeWorkPage;
    BlogPage blogPage;

    PhotosPage photosPage;
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod
    @Parameters({"browser", "version", "platform"})
    public void setup(String browser, String version, String platform, Method method) throws MalformedURLException {

        Reports.start(method.getName());

        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("80");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-sbalahnin20-ddfb4");
        sauceOptions.put("accessKey", "e71171e8-a8bd-4d80-af7e-989f047751a8");
        sauceOptions.put("name", method.getName());
        browserOptions.setCapability("sauce:options", sauceOptions);

        URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
        RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        capabilities.setCapability("username", "oauth-sbalahnin20-ddfb4");
//        capabilities.setCapability("accessKey", "e71171e8-a8bd-4d80-af7e-989f047751a8");
//        capabilities.setCapability("browserName", browser);
//        capabilities.setCapability("platform", platform);
//        capabilities.setCapability("version", version);
//        capabilities.setCapability("name",  method.getName());
//        driver = new RemoteWebDriver(
//                new URL("http://" + System.getenv("SAUCE_USERNAME") + ":" + System.getenv("SAUCE_ACCESS_KEY") + "@ondemand.saucelabs.com:80/wd/hub"),
//                capabilities);


        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        mainPage = new MainPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        howWeWorkPage = new HowWeWorkPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        driver.manage().window().maximize();
        driver.get(Data.mainUrl);
    }

    @AfterMethod
    public void afterActions(ITestResult testResult) {
        //Local Reports
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        //Sauce Labs
        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (testResult.isSuccess() ? "passed": "failed"));

        driver.quit();
    }

}





