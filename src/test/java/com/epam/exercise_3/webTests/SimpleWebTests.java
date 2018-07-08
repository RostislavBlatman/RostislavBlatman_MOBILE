package com.epam.exercise_3.webTests;

import com.epam.exercise_3.pageObjects.forWeb.IanaOrg;
import com.epam.exercise_3.setup.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

@Test(groups = "web")
public class SimpleWebTests extends Driver {

    private IanaOrg ianaOrg;

    @BeforeClass
    public void beforeClass(){

        driver().get(SUT);
        ianaOrg = new IanaOrg(driver());
    }

    @Test(description = "Open website and check functionality")
    public void webTest() {
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        ianaOrg.checkUrl();
        driverWait().until(ExpectedConditions.visibilityOfAllElements(ianaOrg.webElements()));
        ianaOrg.checkLogo();
        ianaOrg.checkTextUnderLogo();
        ianaOrg.checkDomainSectionTitle();
        ianaOrg.checkTextInDomainSection();
        ianaOrg.checkLinkInRootZoneManagement();

    }
}
