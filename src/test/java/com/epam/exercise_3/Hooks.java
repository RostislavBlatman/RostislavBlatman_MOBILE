package com.epam.exercise_3;

import com.epam.exercise_3.setup.Driver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static com.epam.exercise_3.enums.PropertyFile.*;

@Test
public class Hooks extends Driver {

    @BeforeSuite(groups = "native")
    public void setUpNative() throws Exception {
        prepareDriver(NATIVE.title);
        System.out.println("Driver prepared");
    }

    @BeforeSuite(groups = "nativefarm")
    public void setUpNativeFarm() throws Exception {
        prepareDriver(NATIVE_ON_FARM.title);
        System.out.println("Driver prepared");
    }

    @BeforeSuite(groups = "web")
    public void setUpWeb() throws Exception {
        prepareDriver(WEB.title);
        System.out.println("Driver prepared");
    }

    @BeforeSuite(groups = "webfarmIOS")
    public void setUpWebFarmIOS() throws Exception {
        prepareDriver(WEB_ON_FARM_IOS.title);
        System.out.println("Driver prepared");
    }

    @BeforeSuite(groups = "webfarmAndroid")
    public void setUpWebFarmAndroid() throws Exception {
        prepareDriver(WEB_ON_FARM_ANDROID.title);
        System.out.println("Driver prepared");
    }

    @AfterSuite(groups = {"native", "web","webfarmIOS","webfarmAndroid"}, description = "Close driver")
    public void tearDown() {
        closeApp();
        System.out.println("Driver closed");
    }
}
