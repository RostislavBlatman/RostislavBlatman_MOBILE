package com.epam.exercise_3.setup;

import com.epam.exercise_3.enums.DefaultProperties;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.net.URL;
import java.util.Properties;

import static com.epam.exercise_3.enums.DefaultProperties.CHROME_DRIVER_EXECUTABLE_DIR;
import static com.epam.exercise_3.enums.ExceptionText.UNCLEAR_APP_TYPE;
import static com.epam.exercise_3.enums.ExceptionText.UNKNOWN_PLATFORM;
import static com.epam.exercise_3.setup.TestProperties.getCurrentProp;
import static io.appium.java_client.remote.MobileBrowserType.CHROME;
import static io.appium.java_client.remote.MobileBrowserType.SAFARI;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;
import static io.appium.java_client.remote.MobilePlatform.IOS;

/**
 * Initialize a driver with test properties
 */
public class Driver {
    private static AppiumDriver driverSingle = null;
    private static WebDriverWait waitSingle;
    private DesiredCapabilities capabilities;
    private Properties properties;

    // DefaultProperties to be read
    protected static String AUT; // (mobile) app under testing
    protected static String SUT; // site under testing
    protected static String TEST_PLATFORM;
    protected static String DRIVER;
    protected static String CHROME_DIR;
    protected static String UDID;
    protected static String DEVICE_NAME;

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */
    protected void prepareDriver(String propertiesFileName) throws Exception {
        // Set properties
        properties = getCurrentProp(propertiesFileName);
        AUT = properties.getProperty(DefaultProperties.AUT.name);
        SUT = properties.getProperty(DefaultProperties.SUT.name);
        TEST_PLATFORM = properties.getProperty(DefaultProperties.PLATFORM.name);
        DRIVER = properties.getProperty(DefaultProperties.DRIVER.name);
        CHROME_DIR = properties.getProperty(CHROME_DRIVER_EXECUTABLE_DIR.name);
        UDID = properties.getProperty(DefaultProperties.UDID.name);
        DEVICE_NAME = properties.getProperty(MobileCapabilityType.DEVICE_NAME);

        capabilities = new DesiredCapabilities();
        String browserName;

        System.out.println(DRIVER);

        // Setup test platform: Android or iOS. Browser also depends on a platform.
        switch (TEST_PLATFORM) {
            case ANDROID:
//                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
//                capabilities.setCapability(CHROME_DRIVER_EXECUTABLE_DIR.name,CHROME_DRIVER_PATH.name);
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                browserName = CHROME;
                break;
            case IOS:
                browserName = SAFARI;
                capabilities.setCapability(MobileCapabilityType.UDID, UDID);
                break;
            default:
                throw new Exception(UNKNOWN_PLATFORM.text);
        }
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);

        // Setup type of application: mobile, webTests (or hybrid)
        if (AUT != null && SUT == null) {
            // Native
            capabilities.setCapability("appPackage","com.example.android.contactmanager");
            capabilities.setCapability("appActivity",".ContactManager");
            File app = new File(AUT);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && AUT == null) {
            // Web
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, browserName);
        } else {
            throw new Exception(UNCLEAR_APP_TYPE.text);
        }

        // Init driver for local Appium server with capabilities have been set
        if (driverSingle == null) {
            driverSingle = new AppiumDriver(new URL(DRIVER), capabilities);
        }
        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 20);
        }
    }

    public static AppiumDriver driver() {
        return driverSingle;
    }

    public static void closeApp() {
        driver().closeApp();
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}

