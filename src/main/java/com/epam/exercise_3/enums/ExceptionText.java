package com.epam.exercise_3.enums;

public enum ExceptionText {
    UNKNOWN_PLATFORM("Unknown mobile platform"),
    UNCLEAR_APP_TYPE("Unclear type of mobile app"),
    WRONG_FIELD_CONTENT("The contents of the field don`t satisfy the expected"),
    FIELD_IS_NOT_DISPALAYED("Field is not displayed on page");

    public String text;

    ExceptionText(String text) {
        this.text = text;
    }
}
