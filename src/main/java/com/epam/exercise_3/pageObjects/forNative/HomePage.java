package com.epam.exercise_3.pageObjects.forNative;

import com.epam.exercise_3.setup.Driver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.epam.exercise_3.enums.ContactManagerContent.ADD_CONTACT;
import static com.epam.exercise_3.enums.ContactManagerContent.SHOW_INVISIBLE_CONTACTS;

public class HomePage extends Driver {

    private MobileElement addContact (){
        return (MobileElement) driver().findElement(By.id(ADD_CONTACT.path));
    }

    private MobileElement showInvisibleContactsCheckbox(){
        return (MobileElement) driver().findElement(By.id(SHOW_INVISIBLE_CONTACTS.path));
    }

    public void addContactChoose(){
        addContact().click();
    }

    public void showInvisibleContactsCheckboxChoose(){
        showInvisibleContactsCheckbox().click();
    }

}
