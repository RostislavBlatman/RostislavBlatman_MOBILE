package com.epam.exercise_3.enums;

public enum Contacts {

    PITTER_CHAILOVSKY("Pitter Chailovsky", "12345678901");

    public String name;
    public String phoneNumber;

    Contacts(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

}
