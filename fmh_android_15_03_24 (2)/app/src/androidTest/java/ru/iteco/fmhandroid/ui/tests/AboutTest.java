package ru.iteco.fmhandroid.ui.tests;



import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.about.AboutStep;
import ru.iteco.fmhandroid.ui.auth.AuthPage;
import ru.iteco.fmhandroid.ui.auth.AuthStep;
import ru.iteco.fmhandroid.ui.main.MainStep;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения тестирования страницы 'О приложении' приложения В хосписе")

public class AboutTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authDoIt(){
        AuthStep.authorization();
    }

    @AfterClass
    public static void exitDoIt(){
        AuthPage.clickButtonExit(AuthPage.getAuthorizationButtonExit());
        AuthStep.clickButtonLogOut();
    }
    @Test
    @Description("Переход по ссылке Политика конфиденциальности")
    public void openLinkPrivacyPolicy(){
        AboutStep.clickButtonMainMenu();
        AboutStep.clickButtonAbout();
        AboutStep.clickLinkPrivacyPolicy();
        pressBack();

    }
    @Test
    @Description("Переход по ссылке Пользовательское соглашение")
    public void openLinkTermOfUse(){
        AboutStep.clickButtonMainMenu();
        AboutStep.clickButtonAbout();
        AboutStep.clickLinkTermsOfUse();
        pressBack();
    }
    @Test
    @Description("Вернуться на предыдущую страницу кнопкой назад в AppBar страницы О приложении")
    public void backInPrevPageOnAboutPage(){
        AboutStep.clickButtonMainMenu();
        AboutStep.clickButtonAbout();
        AboutStep.clickButtonBack();
        MainStep.isItMainPage();
    }

}
