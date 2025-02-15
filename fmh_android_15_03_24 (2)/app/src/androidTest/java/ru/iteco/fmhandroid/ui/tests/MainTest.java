package ru.iteco.fmhandroid.ui.tests;

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
import ru.iteco.fmhandroid.ui.news.NewsStep;
import ru.iteco.fmhandroid.ui.quote.QuoteStep;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения  тестирования страницы Главная в приложении В хосписе")
public class MainTest {
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
    @Description("Переход с Главной страницы приложения на страницу Новости кнопкой ВСЕ НОВОСТИ")
    public void buttonAllNews() {
        MainStep.buttonAllNewsclick();
        NewsStep.isItNewsPage();
    }

    @Test
    @Description("Переход с Главной страницы приложения на страницу Новости через вкладку Меню ")
    public void buttonNewsInMainMenu() {
        MainStep.buttonMainMenuClick();
        MainStep.buttonNewsClickInMainMenu();
        NewsStep.isItNewsPage();
    }
    @Test
    @Description("Переход с Главной страницы приложения на страницу О приложении через вкладку Меню ")
    public void buttonAboutInMainMenu() {
        MainStep.buttonMainMenuClick();
        MainStep.buttonAboutClickInMainMenu();
        AboutStep.isItAboutPage();
    }
    @Test
    @Description("Переход с Главной страницы приложения на страницу Цитаты через тематическую иконку в AppBar ")
    public void buttonQuoteInMainAppBar() {
        QuoteStep.clickButtonQuote();
        QuoteStep.isItQuotePage();
    }

}
