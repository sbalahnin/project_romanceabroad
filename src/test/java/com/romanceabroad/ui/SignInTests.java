package com.romanceabroad.ui;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTests extends BaseUI {

    @Test
    public void testSignInTest() {
        String signInLink = mainPage.verifySignInLink();
        System.out.println(signInLink);
        Assert.assertEquals(signInLink, Data.expectedUrlSignIn);

    }
    @Test(dataProvider = "SignIn", dataProviderClass = DataProviders.class)
    public void negativeTestCases (String email, String password, boolean requirement){
        mainPage.verifySignInLink();
        mainPage.javaWaitSec(2);
        driver.findElement(Locators.TEXT_FIELD_SIGN_IN_EMAIL).sendKeys(email);
        driver.findElement(Locators.TEXT_FIELD_SIGN_IN_PASSWORD).sendKeys(password);
        driver.findElement(Locators.BUTTON_SIGN_IN).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.SIGN_IN_ERROR_MESSAGE));
        if(!requirement) {
            Assert.assertTrue(driver.findElement(Locators.SIGN_IN_ERROR_MESSAGE).isDisplayed(), Data.signInErrorMessage);
            System.out.println(Data.signInErrorMessage);
        }else{
            System.out.println("Login successfully");
        }


    }

}

