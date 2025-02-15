package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;


import androidx.test.espresso.NoMatchingViewException;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.auth.AuthPage;
import ru.iteco.fmhandroid.ui.auth.AuthStep;
import ru.iteco.fmhandroid.ui.main.MainStep;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения  тестирования страницы Авторизации пользователя в приложении В хосписе")
public class AutorizasionTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
    @Before
    public void auth(){
        try {
            AuthPage.textAuth();
        } catch (NoMatchingViewException e){
            AuthPage.clickButtonExit(AuthPage.getAuthorizationButtonExit());
            AuthStep.clickButtonLogOut();
        }
    }

    @Test
    @Description("Авторизация валидного пользователя с логином login2 паролем password2")
    public void authTestValid() {
       AuthStep.textAuth();
       AuthStep.clickLoginField();
       AuthStep.clickPasswordField();
       AuthPage.clickButton(AuthPage.getAuthorizationButton());
       MainStep.isItMainPage();
       AuthPage.clickButtonExit(AuthPage.getAuthorizationButtonExit());
       AuthStep.clickButtonLogOut();

    }

    @Test
    @Description("Авторизация  пользователя с невалидным логином login и валидным паролем password2")
    public void authTestInvalidLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldInValid();
        AuthStep.clickPasswordField();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с валидным логином login2 и невалидным паролем password")
    public void authTestInvalidPassword() {
        AuthStep.textAuth();
        AuthStep.clickLoginField();
        AuthStep.clickPasswordFieldInValid();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с невалидным логином login и невалидным паролем password")
    public void authTestInvalidPasswordInvalidLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldInValid();
        AuthStep.clickPasswordFieldInValid();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с пустым полем логин и валидным паролем password2")
    public void authTestEmptyLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldEmpty();
        AuthStep.clickPasswordField();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с валидным логином login2 и пустым полем пароль")
    public void authTestEmptyPassword() {
        AuthStep.textAuth();
        AuthStep.clickLoginField();
        AuthStep.clickPasswordFieldEmpty();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с пустым полем логин и пустым полем пароль")
    public void authTestEmptyPasswordEmptyLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldEmpty();
        AuthStep.clickPasswordFieldEmpty();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с заглавными символами в поле логин LOGIN2 и паролем password2")
    public void authTestUpperCaseLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldUpperCase();
        AuthStep.clickPasswordField();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя c данными логин: login2 и с заглавными символами в поле пароль PASSWORD2")
    public void authTestUpperCasePassword() {
        AuthStep.textAuth();
        AuthStep.clickLoginField();
        AuthStep.clickPasswordFieldUpperCase();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя c заглавными символами в поле логин: LOGIN2 и с заглавными символами в поле пароль PASSWORD2")
    public void authTestUpperCasePasswordUpperCaseLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldUpperCase();
        AuthStep.clickPasswordFieldUpperCase();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с невалидными данными в поле логин - спецсимволы и валидным паролем password2")
    public void authTestSpecialCharactersLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldSpecialCharacters();
        AuthStep.clickPasswordField();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с валидным логином login2 и невалидными данными в поле пароль - спецсимволы")
    public void authTestSpecialCharactersPassword() {
        AuthStep.textAuth();
        AuthStep.clickLoginField();
        AuthStep.clickPasswordFieldSpecialCharacters();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с невалидными данными в поле логин - спецсимволы и невалидными данными в поле пароль - спецсимволы")
    public void authTestSpecialCharactersPasswordSpecialCharactersLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldSpecialCharacters();
        AuthStep.clickPasswordFieldSpecialCharacters();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с невалидными данными в поле логин - цифры и валидным паролем password2")
    public void authTestNumbersLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldNumbers();
        AuthStep.clickPasswordField();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с валидным логином login2 и невалидными данными в поле пароль - цифры")
    public void authTestNumbersPassword() {
        AuthStep.textAuth();
        AuthStep.clickLoginField();
        AuthStep.clickPasswordFieldNumbers();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    @Test
    @Description("Авторизация  пользователя с невалидными данными в поле логин - цифры и невалидными данными в поле пароль - цифры")
    public void authTestNumbersPasswordNumbersLogin() {
        AuthStep.textAuth();
        AuthStep.clickLoginFieldNumbers();
        AuthStep.clickPasswordFieldNumbers();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }




}
