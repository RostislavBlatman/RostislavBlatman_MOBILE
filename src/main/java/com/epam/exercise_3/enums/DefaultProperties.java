package com.epam.exercise_3.enums;

public enum DefaultProperties {
    AUT("aut"),
    SUT("sut"),
    PLATFORM("platform"),
    DRIVER("driver"),
    CHROME_DRIVER_EXECUTABLE_DIR("chromedriverExecutableDir"),
    UDID("udid"),
    CHROME_DRIVER_PATH("C:\\Users\\Ростислав\\Desktop\\TestAutomation\\RostislavBlatman_Mobile\\src\\main\\java\\resources");

    public String name;

    DefaultProperties(String title) {
        this.name = title;
    }
}