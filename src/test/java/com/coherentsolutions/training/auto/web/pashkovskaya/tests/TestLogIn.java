package com.coherentsolutions.training.auto.web.pashkovskaya.tests;

import com.coherentsolutions.training.auto.web.pashkovskaya.base.BaseTest;
import com.coherentsolutions.training.auto.web.pashkovskaya.util.PageDriver;
import com.coherentsolutions.training.auto.web.pashkovskaya.util.Screenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.coherentsolutions.training.auto.web.pashkovskaya.pages.HomePage;
import com.coherentsolutions.training.auto.web.pashkovskaya.pages.PasswordPage;
import com.coherentsolutions.training.auto.web.pashkovskaya.pages.SignInPage;
import com.coherentsolutions.training.auto.web.pashkovskaya.pages.UserNamePage;

import java.io.IOException;

import static com.coherentsolutions.training.auto.web.pashkovskaya.util.MainConstants.*;
import static org.testng.Assert.assertEquals;

public class TestLogIn extends BaseTest {
    @Test
    public void testLogin() throws InterruptedException, IOException {
        WebDriver driver = PageDriver.getDriver();
        driver.get(LINK_TO_MAIN_YANDEX_PAGE);
        Thread.sleep(20000);

        SignInPage signInPage = new SignInPage(driver);
        UserNamePage userNamePage = signInPage.openUserNamePage();
        PasswordPage passwordPage = userNamePage.enterValidUsername(USERNAME);
        HomePage homePage = passwordPage.enterValidPassword(PASSWORD);

        Screenshot.takeScreenshot(driver);

        assertEquals(homePage.getMessageText(), USERNAME, "UserName mismatch");
    }
}
