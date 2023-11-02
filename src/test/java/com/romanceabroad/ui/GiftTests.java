package com.romanceabroad.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GiftTests extends BaseUI {


    @Test
    public void testGiftsLink() {
        String giftLink = mainPage.verifyGiftLink();
        System.out.println(giftLink);
        Assert.assertEquals(giftLink, Data.expectedUrlGifts);

    }
}
