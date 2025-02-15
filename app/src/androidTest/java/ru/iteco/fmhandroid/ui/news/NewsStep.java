package ru.iteco.fmhandroid.ui.news;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getAllNewsButton;

import static ru.iteco.fmhandroid.ui.news.NewsPage.getFilterNewsButton;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInFilterNewsChooseCategoryField;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInFilterNewsChooseFinishDateField;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInFilterNewsChooseFinishDateFieldClickOk;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInFilterNewsChooseStartDateField;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInFilterNewsChooseStartDateFieldClickOk;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInFilterNewsClickFilterButton;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getInMainMenuFieldMain;
import static ru.iteco.fmhandroid.ui.news.NewsPage.getSortingNewsButton;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class NewsStep {
    public static void clickButtonAllNews(){
        Allure.step("Нажать на кнопку Все новости");
        onView(getAllNewsButton()).perform(click());
    }
    public static void clickButtonSortingNews(){
        Allure.step("Нажать на кнопку Сортировка новостей");
        onView(getSortingNewsButton()).perform(click());
    }
    public static void clickButtonFilteredNews(){
        Allure.step("Нажать на кнопку Фильтрация новостей");
        onView(getFilterNewsButton()).perform(click());
    }

    public static void enterDataOnFieldChooseCategoryOfFiltered(String category){
        Allure.step("Выбрать категорию на странице  Фильтрации новостей");
        onView(getInFilterNewsChooseCategoryField()).perform(click(), replaceText(category), closeSoftKeyboard());
    }

    public static void clickButtonFilterOnFiltered(){
        Allure.step("Нажать на кнопку Фильтровать");
        onView(getInFilterNewsClickFilterButton()).perform(click());
    }
    public static void isItNewsPage() {
        Allure.step("Проверяем, находимся ли на странице Новости");
        WaitId.waitView(withText("News")).check(matches(isDisplayed()));

    }
    public static void clickFieldMainInMainMenu() {
        Allure.step("Нажать на кнопку Главная в Главном меню В AppBar");
        onView(getInMainMenuFieldMain()).perform(click());
    }
    public static void checkNewsIsPresent(String title) {
        Allure.step("Ищем вновь созданную новость в списке");
        scrollToElementInRecyclerList(title).check(matches(isDisplayed()));
    }
    public static ViewInteraction scrollToElementInRecyclerList(String title) {
        Allure.step("Переходим к нужному элементу");
        return WaitId.waitView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.scrollTo(allOf(
                        hasDescendant(withText(title)))));


    }

}
