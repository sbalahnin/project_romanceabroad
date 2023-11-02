package com.romanceabroad.ui;

public class Data {
    public static final String mainUrl = "https://romanceabroad.com/";

    // Registration data
    public static final String email1 = "11@gmail.com";
    public static final String email2 = "abcgmail.com";
    public static final String email3 = "xyz@yahoo.com";
    public static final String password = "Oregon";
    public static final String nickname1stPart = "Test";
    public static final String nickname = MainPage.generateNewNumber(nickname1stPart, Data.lengthSecondPartOfNickname);
    public static final String phone = "888-999-1111";
    public static final int lengthSecondPartOfNickname = 5;
    public static final String day = "1";
    public static final String month = "May";
    public static final String year = "1999";
    public static final String city = "Sydney";
    public static final String location = "North Sydney, State of New South Wales, Australia";

    //Sign In page
    public static final String emailSignIn1 = "";
    public static final String emailSignIn2 = "sergey@gmail.com";
    public static final String passwordSignIn1 = "";
    public static final String passwordSignIn2 = "T12345";
    public static final String signInErrorMessage = "Error message is displayed";

    public static final String expectedUrlMedia = "https://romanceabroad.com/media/index";
    public static final String expectedUrlSearch = "https://romanceabroad.com/users/search";
    public static final String expectedUrlHowWeWok = "https://romanceabroad.com/content/view/how-it-works";
    public static final String expectedUrlGifts = "https://romanceabroad.com/store/category-sweets";
    public static final String expectedUrlTourUkraine = "https://romanceabroad.com/store/sweets/20-tour_to_ukraine";
    public static final String expectedUrlBlog = "https://romanceabroad.com/content/view/blog";
    public static final String expectedUrlSignIn = "https://romanceabroad.com/";
    public static final String expectedUrlPrettyWomen = "https://romanceabroad.com/users/search";
    public static final String expectedTitleHowWeWork = "Ukrainian women for marriage";
    public static final String expectedTitlePrettyWomen = "Single Ukrainian women online";


    // User Profile
    public static final String expectedTitleAllPhotos = "Ukrainian women photos";
    public static final String expectedTitleGallery = "Gallery";
    public static final String expectedTitlePhotoGallery = "Photo gallery";
    public static final String expectedTitleVideoGallery = "Video gallery";
    public static final String expectedTitleAlbumsGallery = "Gallery albums";

    //Media
    public static final String textMedia = "On our website you have access to photos of all different kinds of women";
}
