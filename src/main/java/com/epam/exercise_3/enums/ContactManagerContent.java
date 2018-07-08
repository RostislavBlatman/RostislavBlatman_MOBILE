package com.epam.exercise_3.enums;

public enum ContactManagerContent {

    ADD_CONTACT("com.example.android.contactmanager:id/addContactButton"),
    SHOW_INVISIBLE_CONTACTS("com.example.android.contactmanager:id/showInvisible"),
    CONTACT_NAME("com.example.android.contactmanager:id/contactNameEditText"),
    CONTACT_NAME_TITLE_PATH("//android.widget.TextView[@content-desc=\"Contact Name\"]"),
    CONTACT_PHONE("com.example.android.contactmanager:id/contactPhoneEditText"),
    CONTACT_PHONE_TITLE_PATH("//android.widget.TextView[@content-desc=\"Contact Phone\"]"),
    SAVE("com.example.android.contactmanager:id/contactSaveButton"),
    ALLERT_TITLE("android:id/alertTitle"),
    TEXT_ATTRIBUTE("text"),
    CONTACT_NAME_TITLE("Contact Name"),
    CONTACT_PHONE_TITLE("Contact Phone");

    public String path;
    ContactManagerContent(String path){
        this.path = path;
    }
}
