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
@Epic("Тест-кейсы для проведения  тестирования страницы Цитаты в приложении В хосписе")
public class QuoteTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule=new ActivityTestRule<>(AppActivity.class);
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
    @Description("Развертывание цитаты кнопкой развернуть")
    public void deploymentRollUpQuoteArrow(){
        QuoteStep.clickButtonQuote();
        QuoteStep.clickDeploymentButtonQuote();
        QuoteStep.clickDeploymentButtonQuote();
    }
    @Test
    @Description("Развертывание цитаты путем нажатия на заголовок цитаты")
    public void deploymentRollUpQuoteTitleDescription(){
        QuoteStep.clickButtonQuote();
        QuoteStep.clickTitleQuoteClick();
        QuoteStep.clickDescriptionQuoteClick();
    }
    @Test
    @Description("Переход со страницы Цитаты на страницу Главная кнопкой Главная в меню AppBar")
    public void buttonMainInMainMenuInQuotePage(){
        QuoteStep.clickButtonQuote();
        MainStep.buttonMainMenuClick();
        NewsStep.clickFieldMainInMainMenu();
        MainStep.isItMainPage();
    }
    @Test
    @Description("Переход со страницы Цитаты на страницу Новости кнопкой Новости в меню AppBar")
    public void buttonNewsInMainMenuInQuotePage(){
        QuoteStep.clickButtonQuote();
        MainStep.buttonMainMenuClick();
        MainStep.buttonNewsClickInMainMenu();
        NewsStep.isItNewsPage();
    }
    @Test
    @Description("Переход со страницы Цитаты на страницу О приложении кнопкой Новости в меню AppBar")
    public void buttonAboutInMainMenuInQuotePage(){
        QuoteStep.clickButtonQuote();
        MainStep.buttonMainMenuClick();
        MainStep.buttonAboutClickInMainMenu();
        AboutStep.isItAboutPage();
    }


}
