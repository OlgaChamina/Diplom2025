package ru.iteco.fmhandroid.ui.auth;


//import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.auth.AuthPage.getAuthText;
import static ru.iteco.fmhandroid.ui.auth.AuthPage.getAuthorizationButtonLogOut;
import static ru.iteco.fmhandroid.ui.auth.AuthPage.getAuthorizationLoginField;
import static ru.iteco.fmhandroid.ui.auth.AuthPage.getAuthorizationPasswordField;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitFor;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AuthStep {
    public static void authorization(){
        try {
            AuthPage.textAuth();
        } catch (NoMatchingViewException e){
            return;
        }
        AuthStep.clickLoginField();
        AuthStep.clickPasswordField();
        AuthPage.clickButton(AuthPage.getAuthorizationButton());
    }
    public static void clickButton(Integer resourceId){
        Allure.step("Нажать на кнопку Войти");
        onView(withId(resourceId)).perform(click());
    }
    public static void clickButtonExit(Integer resourceId){
        Allure.step("Нажать на кнопку Выход");
        waitFor(3);
        onView(withId(resourceId)).perform(click());
    }
    public static void clickButtonLogOut(){
        Allure.step("Нажать на кнопку Log Out");
        waitFor(3);
        onView(getAuthorizationButtonLogOut()).perform(click());
    }


    public static void clickLoginField(){
        Allure.step("В поле Логин вводим валидный логин login2");
        onView(getAuthorizationLoginField())
                .perform(replaceText("login2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
    public static void clickPasswordField(){
        Allure.step("В поле Пароль вводим валидный пароль password2");
        onView(getAuthorizationPasswordField())
                .perform(replaceText("password2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
    public static void textAuth() {
        Allure.step("Проверяем, что находимся на страние Авторизация");
        waitFor(3);
        onView(getAuthText())
                .check(matches(isDisplayed()));
    }
    public static void clickLoginFieldInValid(){
        Allure.step("В поле Логин вводим невалидный логин, и проверяем всплывающее сообщение");
        onView(getAuthorizationLoginField())
                .perform(replaceText("login"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickPasswordFieldInValid() {
        Allure.step("В поле Пароль вводим невалидный пароль, и проверяем всплывающее сообщение");
        onView(getAuthorizationPasswordField())
                .perform(replaceText("password"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickLoginFieldEmpty(){
        Allure.step("Поле Логин оставляем пустым, и проверяем всплывающее сообщение");
        onView(getAuthorizationLoginField())
                .perform(replaceText(""), closeSoftKeyboard());
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }
    public static void clickPasswordFieldEmpty() {
        Allure.step("Поле Пароль оставляем пустым,  и проверяем всплывающее сообщение");
        onView(getAuthorizationPasswordField())
                .perform(replaceText(""), closeSoftKeyboard());
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }
    public static void clickLoginFieldUpperCase(){
        Allure.step("В Поле Логин вводим данные заглавными буквами, и проверяем всплывающее сообщение");
        onView(getAuthorizationLoginField())
                .perform(replaceText("LOGIN2"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickPasswordFieldUpperCase() {
        Allure.step("В Поле Пароль вводим данные заглавными буквами, и проверяем всплывающее сообщение");
        onView(getAuthorizationPasswordField())
                .perform(replaceText("PASSWORD2"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickLoginFieldSpecialCharacters(){
        Allure.step("В Поле Логин вводим данные - спецсимволы, и проверяем всплывающее сообщение");
        onView(getAuthorizationLoginField())
                .perform(replaceText("<script>alert(testalert)</script>"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickPasswordFieldSpecialCharacters() {
        Allure.step("В Поле Пароль вводим данные - спецсимволы, и проверяем всплывающее сообщение");
        onView(getAuthorizationPasswordField())
                .perform(replaceText("<iframe src=\"javascript:…\">"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickLoginFieldNumbers() {
        Allure.step("В Поле Логин вводим данные - числа, и проверяем всплывающее сообщение");
        onView(getAuthorizationLoginField())
                .perform(replaceText("123456789"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
    public static void clickPasswordFieldNumbers() {
        Allure.step("В Поле Пароль вводим данные - числа, и проверяем всплывающее сообщение");
        onView(getAuthorizationPasswordField())
                .perform(replaceText("123456789"), closeSoftKeyboard());
        onView(allOf(withContentDescription("Something went wrong. Try again later."), isDisplayed()));
    }
}











