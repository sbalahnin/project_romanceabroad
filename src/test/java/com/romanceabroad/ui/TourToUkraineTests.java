package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TourToUkraineTests extends BaseUI {

    @Test
    public void testTourToUkraineLink() {
        String tourToUkraineLink = mainPage.verifyTourToUkraineLink();
        System.out.println(tourToUkraineLink);
        Assert.assertEquals(tourToUkraineLink, Data.expectedUrlTourUkraine);

    }
}
