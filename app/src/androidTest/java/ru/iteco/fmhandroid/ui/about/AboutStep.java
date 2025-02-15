package ru.iteco.fmhandroid.ui.about;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import static ru.iteco.fmhandroid.ui.about.AboutPage.getButtonAbout;
import static ru.iteco.fmhandroid.ui.about.AboutPage.getButtonBack;
import static ru.iteco.fmhandroid.ui.about.AboutPage.getLinkPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.about.AboutPage.getLinkTermsOfUse;
import static ru.iteco.fmhandroid.ui.main.MainPage.getButtonMainMenu;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitFor;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class AboutStep {
    public static void clickButtonMainMenu(){
        Allure.step("Нажать на кнопку Меню");
        waitFor(3);
        onView(getButtonMainMenu())
                .perform(click());
    }

    public static void clickButtonAbout() {
        Allure.step("Нажать на кнопку О приложении.");
        onView(getButtonAbout())
                .perform(click());
    }

    public static void clickLinkPrivacyPolicy(){
        Allure.step("Проверить, что ссылка Политика Конфиденциальности присутствует и нажать на нее");
        onView(getLinkPrivacyPolicy())
                .check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())));
    }

    public static void clickLinkTermsOfUse(){
        Allure.step("Проверить, что ссылка Пользовательское соглашение присутствует и нажать на нее");
        onView(getLinkTermsOfUse())
                .check(matches(allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
    }
    public static void isItAboutPage() {
        Allure.step("Проверяем, находимся ли на странице О приложении");
        WaitId.waitView(withText("Version:")).check(matches(isDisplayed()));
    }
    public static void clickButtonBack() {
        Allure.step("Нажать на кнопку назад в AppBar");
        onView(getButtonBack())
                .perform(click());
    }
}
