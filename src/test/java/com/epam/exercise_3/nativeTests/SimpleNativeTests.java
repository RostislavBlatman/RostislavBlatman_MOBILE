package com.epam.exercise_3.nativeTests;

import com.epam.exercise_3.pageObjects.forNative.AddContactPage;
import com.epam.exercise_3.pageObjects.forNative.HomePage;
import com.epam.exercise_3.setup.Driver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.epam.exercise_3.enums.Contacts.PITTER_CHAILOVSKY;

@Test(groups = {"native","nativefarm"})
public class SimpleNativeTests extends Driver {

    private HomePage homePage;
    private AddContactPage addContactPage;


    @BeforeClass
    public void beforeClass(){
        homePage = new HomePage();
        addContactPage = new AddContactPage();
    }


    @Test(description = "simple native test")
    public void nativeTest() {
        homePage.addContactChoose();
        addContactPage.contactNameEditText(PITTER_CHAILOVSKY.name);
        addContactPage.clickBackButtonOnAndroid();
        addContactPage.contactPhoneEditText(PITTER_CHAILOVSKY.phoneNumber);
        addContactPage.clickBackButtonOnAndroid();
        addContactPage.checkNameContent(PITTER_CHAILOVSKY.name);
        addContactPage.checkPhoneContent(PITTER_CHAILOVSKY.phoneNumber);
        addContactPage.clickSaveButton();
    }
}

