package com.epam.exercise_3.pageObjects.forNative;

import com.epam.exercise_3.setup.Driver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import static com.epam.exercise_3.enums.ContactManagerContent.*;
import static com.epam.exercise_3.enums.ExceptionText.WRONG_FIELD_CONTENT;

public class AddContactPage extends Driver {

    private MobileElement contactNameTextFieldTitle (){
        return (MobileElement) driver().findElement(By.xpath(CONTACT_NAME_TITLE_PATH.path));
    }

    private MobileElement contactNameTextField (){
        return (MobileElement) driver().findElement(By.id(CONTACT_NAME.path));
    }

    private MobileElement contactPhoneTextField (){
        return (MobileElement) driver().findElement(By.id(CONTACT_PHONE.path));
    }

    private MobileElement contactPhoneTextFieldTitle (){
        return (MobileElement) driver().findElement(By.xpath(CONTACT_PHONE_TITLE_PATH.path));
    }

    private MobileElement saveButton() {
        return (MobileElement) driver().findElement(By.id(SAVE.path));
    }

    private MobileElement allertTitle() {
        return (MobileElement) driver().findElement(By.id(ALLERT_TITLE.path));
    }

    public void clickBackButtonOnAndroid(){
        driver().navigate().back();
    }

    public void contactNameEditText(String name){
        contactNameTextField().sendKeys(name);
    }

    public void contactPhoneEditText(String number){
        contactPhoneTextField().sendKeys(number);
    }

    public void checkNameContent(String content){

        assert contactNameTextFieldTitle().getAttribute(TEXT_ATTRIBUTE.path)
                .contains(CONTACT_NAME_TITLE.path) : WRONG_FIELD_CONTENT.text;
        assert contactNameTextField().getAttribute(TEXT_ATTRIBUTE.path).contains(content) : WRONG_FIELD_CONTENT.text;

    }

    public void checkPhoneContent(String content){

        assert contactPhoneTextFieldTitle().getAttribute(TEXT_ATTRIBUTE.path)
                .contains(CONTACT_PHONE_TITLE.path) : WRONG_FIELD_CONTENT.text;
        assert contactPhoneTextField().getAttribute(TEXT_ATTRIBUTE.path).contains(content) : WRONG_FIELD_CONTENT.text;

    }

    public void clickSaveButton(){
        saveButton().click();
        allertTitle().isDisplayed();
    }



}
