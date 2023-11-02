package com.romanceabroad.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

public class BaseUI {
    WebDriver driver;
    WebDriverWait wait;
    String mainUrl = "https://www.romanceabroad.com";
    MainPage mainPage;
    SearchPage searchPage;
    BlogPage blogPage;
    PhotosPage photosPage;
    HowWeWorkPage howWeWorkPage;
    SoftAssert softAssert = new SoftAssert();


    @BeforeMethod(groups = {"user", "admin", "firefox"}, alwaysRun = true)
    //  public void setUp (){

    @Parameters("browser")
    public void setup(@Optional("chrome") String browser, Method method) throws Exception {
        Reports.start(method.getDeclaringClass().getName() + " : " + method.getName());
        // Check if parameter passed from TestNG.xml is 'firefox'
        if (browser.equalsIgnoreCase("firefox")) {

            // Create firefox instance
            System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
            driver = new FirefoxDriver();

        }

        // Check if parameter passed as 'chrome'
        else if (browser.equalsIgnoreCase("chrome")) {

            // Set path to chromedriverOld.exe
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

            // Create chrome instance
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");

        } else {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            driver = new ChromeDriver();
            driver.get("chrome://settings/clearBrowserData");

        }

//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        mainPage = new MainPage(driver, wait);
        searchPage = new SearchPage(driver, wait);
        blogPage = new BlogPage(driver, wait);
        photosPage = new PhotosPage(driver, wait);
        howWeWorkPage = new HowWeWorkPage(driver, wait);
        driver.manage().window().maximize();
        driver.get(mainUrl);

    }


    @AfterMethod
    public void afterActions(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            Reports.fail(driver, testResult.getName());
        }
        Reports.stop();

        //  driver.quit();
    }



    }

