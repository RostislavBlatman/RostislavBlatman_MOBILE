package com.epam.exercise_3.pageObjects.forWeb;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.epam.exercise_3.enums.ExceptionText.FIELD_IS_NOT_DISPALAYED;
import static com.epam.exercise_3.enums.IanaOrgContent.*;
import static com.epam.exercise_3.setup.Driver.driver;
import static org.testng.Assert.assertEquals;

public class IanaOrg {

    public AppiumDriver driver;

    @FindBy(css = "body > div > header > h1")
    private WebElement logo;

    @FindBy(css = "#intro > p")
    private WebElement textUnderLogo;

    @FindBy(css = "#home-panel-domains > h2 > a")
    private WebElement domainSectionTitle;

    @FindBy(css = "#home-panel-domains > p")
    private WebElement textInDomainSection;

    @FindBy(css = "#home-panel-domains > ul > li:nth-child(1) > a")
    private WebElement rootZoneManagement;

    public IanaOrg(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checkUrl() {
        assertEquals(driver().getCurrentUrl(), LINK.text);
    }

    public void checkLogo() {
        assert logo.isDisplayed() : FIELD_IS_NOT_DISPALAYED.text;
    }

    public void checkTextUnderLogo() {
        assertEquals(textUnderLogo.getText(), TEXT_UNDER_LOGO.text);
    }

    public void checkDomainSectionTitle() {
        assert domainSectionTitle.isDisplayed() : FIELD_IS_NOT_DISPALAYED.text;
        assertEquals(domainSectionTitle.getText(), DOMAIN_NAMES.text);
    }

    public void checkTextInDomainSection() {
        assert textInDomainSection.isDisplayed() : FIELD_IS_NOT_DISPALAYED.text;
        assertEquals(textInDomainSection.getText(), TEXT_IN_DOMAIN_SECTION.text);
    }

    public void checkLinkInRootZoneManagement() {
        assert rootZoneManagement.isDisplayed() : FIELD_IS_NOT_DISPALAYED.text;
        assertEquals(rootZoneManagement.getAttribute("href"), LINK_ROOT_ZONE_MANAGEMENT.text);
    }

    public List<WebElement> webElements() {
        WebElement[] webElements = new WebElement[]{logo,textUnderLogo,
                domainSectionTitle,textInDomainSection,rootZoneManagement};
        List<WebElement> list = new ArrayList<>(Arrays.asList(webElements));
        return list;

    }
}
