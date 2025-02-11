package ru.iteco.fmhandroid.ui.main;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.main.MainPage.getButtonAboutInMainMenu;
import static ru.iteco.fmhandroid.ui.main.MainPage.getButtonAllNewsClick;

import static ru.iteco.fmhandroid.ui.main.MainPage.getButtonMainMenu;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;
import static ru.iteco.fmhandroid.ui.main.MainPage.getButtonNewsInMainMenu;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class MainStep {
    public static void buttonAllNewsclick(){
        Allure.step("Нажать на кнопку Все новости");
        waitElement(R.id.all_news_text_view);
        onView(getButtonAllNewsClick()).perform(click());
    }
    public static void buttonMainMenuClick(){
        Allure.step("Нажать на кнопку Меню в AppBar");
        waitElement(R.id.main_menu_image_button);
        onView(getButtonMainMenu()).perform(click());
    }
    public static void buttonNewsClickInMainMenu(){
        Allure.step("Нажать на кнопку Новости в AppBar");
        waitElement(android.R.id.title);
        onView(getButtonNewsInMainMenu()).perform(click());
    }
    public static void buttonAboutClickInMainMenu(){
        Allure.step("Нажать на кнопку О приложении в AppBar");
        waitElement(android.R.id.title);
        onView(getButtonAboutInMainMenu()).perform(click());
    }
    public static void isItMainPage() {
        Allure.step("Проверяем, находимся ли на Главной странице Приложения");
        WaitId.waitView(withText("News")).check(matches(isDisplayed()));
        WaitId.waitView(withId((R.id.all_news_text_view))).check(matches(isDisplayed()));

    }}

