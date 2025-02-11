package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.Callable;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.auth.AuthPage;
import ru.iteco.fmhandroid.ui.auth.AuthStep;
import ru.iteco.fmhandroid.ui.controlpanel.ControlPanelStep;
import ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsStep;
import ru.iteco.fmhandroid.ui.news.NewsStep;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения  тестирования страницы Панель Управления в приложении В хосписе")
public class ControlPanelTest {
    @Rule
    public ActivityTestRule<AppActivity> activityTestRule = new ActivityTestRule<>(AppActivity.class);

    @Before
    public void authDoIt() {
        AuthStep.authorization();
    }

    @AfterClass
    public static void exitDoIt() {
        AuthPage.clickButtonExit(AuthPage.getAuthorizationButtonExit());
        AuthStep.clickButtonLogOut();
    }
    @Test
    @Description("Фильтрация новостей по  категории Объявление на странице Панель управления")
    public void filteredNewsOnCategoryAdversiment() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Профсоюз","заголовок","описание");
        ControlPanelStep.isItControlPanelPage();
        ControlPanelStep.clickFilteredNews();
        ControlPanelStep.selectCategoryInFilteredNews("Профсоюз");
        ControlPanelStep.clickButtonFilterInFilteredNews();
        ControlPanelStep.findNewsWithCategoryAdversiment("заголовок");
    }

    @Test
    @Description("Фильтрация новостей по статусу  НЕ Активна на странице Панель управления")
    public void filteredNewsOnStatusNotActive() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.clickButtonControlPanel();
        ControlPanelStep.clickFilteredNews();
        ControlPanelStep.selectcheckBoxActiveInFilteredNews();
        ControlPanelStep.clickButtonFilterInFilteredNews();
        ControlPanelStep.findNewsWithStatusNotActive();
    }
    @Test
    @Description("Фильтрация новостей по статусу Активна на странице Панель управления")
    public void filteredNewsOnStatusActive() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.clickButtonControlPanel();
        ControlPanelStep.clickFilteredNews();
        ControlPanelStep.selectcheckBoxNotActiveInFilteredNews();
        ControlPanelStep.clickButtonFilterInFilteredNews();
        ControlPanelStep.findNewsWithStatusActive();
    }
    @Test
    @Description("Фильтрация новостей по Дате публикации на странице Панель управления")
    public void filteredNewsOnSelectDataOnControlPanel() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.enterDataInFieldsCategoryTitleDescription("Массаж","Массаж", "Массаж");
        CreatingNewsStep.enterDataInPublicationDateControlPanelAddNews("01.01.2026");
        CreatingNewsStep.choosePublicationTimeControlPanelAddNews();
        CreatingNewsStep.clickButtonOkInFieldPublicationTimeControlPanelAddNews();
        CreatingNewsStep.clickButtonSaveAddingNewsControlPanelAddNews();
        ControlPanelStep.clickFilteredNews();
        ControlPanelStep.selectDataStartInFilteredNews("01.01.2026");
        ControlPanelStep.selectDataEndInFilteredNews("01.01.2026");
        ControlPanelStep.clickButtonFilterInFilteredNews();
        ControlPanelStep.findNewsWithSelectData("01.01.2026");
    }
    @Test
    @Description("Редактирование Заголовка новости на странице Панель управления")
    public void editingTitleNewsOnControlPanel() {

        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж","Скоро121","описание");
        ControlPanelStep.openNewsCard("Скоро121");
        ControlPanelStep.enterDataFieldTitleInEditNewsOnContralPanel("Не очень111");
        ControlPanelStep.clickButtonSaveEditingNewsOnContralPanel();
        ControlPanelStep.openNewsCard("Не очень111");
        ControlPanelStep.getNewsItemTitle().check(matches(withText("Не очень111")));
            }
    @Test
    @Description("Редактирование Категории новости на несуществующую  на странице Панель управления")
    public void editingCategoryOnNonExistentNewsOnControlPanel() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Нужна помощь","Это важно","описание");
        ControlPanelStep.openNewsCard("Это важно");
        ControlPanelStep.enterDataFieldCategoryInEditNewsOnContralPanel("Новый год");
        ControlPanelStep.clickButtonSaveEditingNewsOnContralPanel();
        ControlPanelStep.checkingWarning("Saving failed. Try again later.", true);
    }

    @Test
    @Description("Редактирование Категории новости с определенным заголовком на странице Панель управления")
    public void changeCategoryPublicationNewsOnOnControlPanel() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Профсоюз","Забастовка!", "Всех сотрудников");
        ControlPanelStep.openNewsCard("Забастовка!");
        ControlPanelStep.enterDataFieldCategoryInEditNewsOnContralPanel("Нужна помощь");
        ControlPanelStep.enterDataFieldTitleInEditNewsOnContralPanel("набастовались!");
        ControlPanelStep.clickButtonSaveEditingNewsOnContralPanel();
        ControlPanelStep.openNewsCard("набастовались!");
        ControlPanelStep.getNewsCategory().check(matches(withText("Нужна помощь")));
    }
    @Test
    @Description("Редактирование Описания новости с определенным заголовком на странице Панель управления")
    public void changeDescriptionPublicationNewsOnOnControlPanel() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Праздник", "К нам", "Приходит");
        ControlPanelStep.openNewsCard("К нам");
        ControlPanelStep.enterDataFieldDescriptionInEditNewsOnContralPanel("Не приходит");
        ControlPanelStep.enterDataFieldTitleInEditNewsOnContralPanel("К другим!");
        ControlPanelStep.clickButtonSaveEditingNewsOnContralPanel();
        ControlPanelStep.checkNewsIsPresent("К другим!");
        ControlPanelStep.getItemNewsEditElementDescription("Не приходит");
        };

    @Test
    @Description("Редактирование Заголовка новости на странице Панель управления")
    public void changeEditingNewsOnControlPanel() {
         NewsStep.clickButtonAllNews();
         CreatingNewsStep.addNewNewsWithData("День рождения","Нужно отметить","описание");
         ControlPanelStep.openNewsCard("Нужно отметить");
         ControlPanelStep.enterDataFieldTitleInEditNewsOnContralPanel("Будет весело");
         ControlPanelStep.clickButtonSaveEditingNewsOnContralPanel();
         ControlPanelStep.checkNewsIsPresent("Будет весело");
         ControlPanelStep.getItemNewsEditElementTitle("Будет весело");
    }

    @Test
    @Description("Удаление новости на странице Панель управления")
    public void deleteNewsOnControlPanel() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж","Тайский","описание");
        ControlPanelStep.checkNewsIsPresent("Тайский");
        ControlPanelStep.deleteNewsOnControlPanel("Тайский");
        ControlPanelStep.checkNewsDoesNotPresent("Тайский");
    }


        }







