package com.epam.exercise_3;

import com.epam.exercise_3.setup.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.exercise_3.enums.PropertyFile.NATIVE;
import static com.epam.exercise_3.enums.PropertyFile.WEB;

@Test
public class Hooks extends Driver {

    @BeforeSuite(groups = "native")
    public void setUpNative() throws Exception {
        prepareDriver(NATIVE.title);
        System.out.println("Driver prepared");
    }

    @BeforeSuite(groups = "web")
    public void setUpWeb() throws Exception {
        prepareDriver(WEB.title);
        System.out.println("Driver prepared");
    }

    @AfterSuite(groups = {"native", "web"}, description = "Close driver")
    public void tearDown() {
        closeApp();
        System.out.println("Driver closed");
    }
}
