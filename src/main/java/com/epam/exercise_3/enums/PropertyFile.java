package com.epam.exercise_3.enums;

public enum PropertyFile {
    DEFAULT_PATH_TO_PROPERTY("src\\main\\java\\resources\\"),
    NATIVE("nativetests.properties"),
    WEB("webtests.properties"),
    NATIVE_ON_FARM("nativetests_on_mobilefarm.properties"),
    WEB_ON_FARM_ANDROID("webtests_on_mobilefarm_android.properties"),
    WEB_ON_FARM_IOS("webtests_on_mobilefarm_ios.properties");

    public String title;

    PropertyFile(String title) {
        this.title = title;
    }
}
