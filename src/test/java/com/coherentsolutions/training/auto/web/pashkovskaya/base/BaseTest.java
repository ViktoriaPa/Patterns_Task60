package com.coherentsolutions.training.auto.web.pashkovskaya.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.coherentsolutions.training.auto.web.pashkovskaya.util.DriverInit;
import com.coherentsolutions.training.auto.web.pashkovskaya.util.PageDriver;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp (String browserName) throws IOException {
        DriverInit instanseDriver = DriverInit.getInstance();
        driver = instanseDriver.openDriverInSauceLabs(browserName);

        PageDriver.setDriver(driver);
    }

    @AfterMethod (alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }
}
