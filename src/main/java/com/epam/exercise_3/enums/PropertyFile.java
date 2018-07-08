package com.epam.exercise_3.enums;

public enum PropertyFile {
    DEFAULT_PATH_TO_PROPERTY("src\\main\\java\\resources\\"),
    NATIVE("nativetests.properties"),
    WEB("webtests.properties");

    public String title;

    PropertyFile(String title) {
        this.title = title;
    }
}
