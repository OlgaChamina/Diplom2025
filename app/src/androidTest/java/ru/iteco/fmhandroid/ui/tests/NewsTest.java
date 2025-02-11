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
import ru.iteco.fmhandroid.ui.controlpanel.ControlPanelStep;
import ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsStep;
import ru.iteco.fmhandroid.ui.main.MainStep;
import ru.iteco.fmhandroid.ui.news.NewsPage;
import ru.iteco.fmhandroid.ui.news.NewsStep;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения  тестирования страницы Новости в приложении В хосписе")

public class NewsTest {
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
    @Description("Сортировка новостей на странице Новости")
    public void sortingNewsClick(){
        NewsStep.clickButtonAllNews();
        NewsStep.clickButtonSortingNews();
    }
    @Test
    @Description("Фильтрация для поиска вновь созданной новости на странице Новости по категории Объявление (негативный)")
    public void filteredNewsAllFieldsAreFilledIn(){
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Объявление", "Задачи", "решаем");
        MainStep.buttonMainMenuClick();
        MainStep.buttonNewsClickInMainMenu();
        NewsStep.clickButtonFilteredNews();
        NewsStep.enterDataOnFieldChooseCategoryOfFiltered("Объявление");
        NewsStep.clickButtonFilterOnFiltered();
        NewsStep.checkNewsIsPresent("Задачи");
    }
    @Test
    @Description("Фильтрация новостей на странице Новости по Несуществующей категории (негативный)")
    public void filteredNewsNonExistCategory(){
        NewsStep.clickButtonAllNews();
        NewsStep.clickButtonFilteredNews();
        NewsStep.enterDataOnFieldChooseCategoryOfFiltered("Новый год");
        NewsStep.clickButtonFilterOnFiltered();
        CreatingNewsStep.checkingWarning("Select a category from the list", true);

    }
    @Test
    @Description("Переход со страницы Новости  на страницу О приложении через вкладку Меню в AppBar(негативный)")
    public void buttonAboutInMainMenuOnNewsPage() {
        NewsStep.clickButtonAllNews();
        MainStep.buttonMainMenuClick();
        MainStep.buttonAboutClickInMainMenu();
        AboutStep.isItAboutPage();
    }
    @Test
    @Description("Переход со страницы Новости  на страницу Главная через вкладку Меню в AppBar")
    public void buttonMainInMainMenuOnNewsPage() {
        NewsStep.clickButtonAllNews();
        MainStep.buttonMainMenuClick();
        NewsStep.clickFieldMainInMainMenu();
        MainStep.isItMainPage();
    }


}
