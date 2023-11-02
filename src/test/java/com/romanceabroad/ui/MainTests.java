package com.romanceabroad.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainTests extends BaseUI {


    @Test
    public void MainPageTest() {
        WebElement ele = driver.findElement(Locators.YOUTUBE_LINK);
        driver.switchTo().frame(ele);
        WebElement playButton = driver.findElement(Locators.YOUTUBE_PLAY_BUTTON);
        if (playButton.isDisplayed()) {
            Assert.assertTrue(playButton.isDisplayed(), "Video is displayed");
            System.out.println("Video is displayed");
            wait.until(ExpectedConditions.elementToBeClickable(Locators.YOUTUBE_PLAY_BUTTON));
            playButton.click();
        } else {
            Assert.fail("Video is not displayed");
        }
    }

    @Test
    public void testLinksOnMainPage() {
        mainPage.checkLinksOnWebPage("//a", "href");
        mainPage.checkLinksOnWebPage("//img", "src");

    }


}


