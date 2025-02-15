package ru.iteco.fmhandroid.ui.creatingnews;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonOkDeleteNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelStep.scrollToElementInRecyclerList;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonCancel;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonCanselAfterButtonCancel;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonControlPanel;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonOkAfterButtonCancel;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonOkInFieldPublicationDateControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonOkInFieldPublicationTimeControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getButtonSaveAddingNewsControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getEmptyCategory;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getEmptyDescription;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getEmptyPublicationDate;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getEmptyPublicationTime;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getEmptyTitle;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getFieldCategoryControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getFieldDescriptionControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getFieldPublicationDateControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getFieldPublicationTimeControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getFieldTitleControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.getPageNewsListRecycler;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.warningNow;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;

import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class CreatingNewsStep {

    public static void clickButtonControlPanel(){
        Allure.step("Нажать на кнопку Создания и редактирования новостей");

        onView(getButtonControlPanel()).perform(click());
    }
    public static void clickButtonControlPanelAddNews(){
        Allure.step("Нажать на кнопку Добавить новость");

        onView(getButtonControlPanelAddNews()).perform(click());
    }

    public static void enterDataInFieldCategoryControlPanelAddNews(String category){
        Allure.step("Ввести данные в поле Категория");

        onView(getFieldCategoryControlPanelAddNews()).perform(click(), replaceText(category), closeSoftKeyboard());
    }
    public static void enterDataInFieldTitleControlPanelAddNews(String title){
        Allure.step("Ввести данные в поле Заголовок");

        onView(getFieldTitleControlPanelAddNews()).perform(click(), replaceText(title), closeSoftKeyboard());
    }
    public static void choosePublicationDateControlPanelAddNews(){
        Allure.step("Нажать на поле Дата публикации");

        onView(getFieldPublicationDateControlPanelAddNews()).perform(click());
    }
    public static void clickButtonOkInFieldPublicationDateControlPanelAddNews(){
        Allure.step("Нажать на кнопку Ок в календаре при выборе даты публикации");

        onView(getButtonOkInFieldPublicationDateControlPanelAddNews()).perform(click());
    }
    public static void choosePublicationTimeControlPanelAddNews(){
        Allure.step("Нажать на поле Время публикации");

        onView(getFieldPublicationTimeControlPanelAddNews()).perform(click());
    }
    public static void enterDataInPublicationDateControlPanelAddNews(String dataPublication){
        Allure.step("Ввести данные в поле Дата публикации");

        onView(getFieldPublicationDateControlPanelAddNews()).perform(replaceText(dataPublication));
    }

    public static void clickButtonOkInFieldPublicationTimeControlPanelAddNews(){
        Allure.step("Нажать на кнопку Ок на часах при выборе времени публикации");

        onView(getButtonOkInFieldPublicationTimeControlPanelAddNews()).perform(click());
    }
    public static void enterDataInFieldDescriptionControlPanelAddNews(String description){
        Allure.step("Ввести данные в поле Описание");

        onView(getFieldDescriptionControlPanelAddNews()).perform(click(), replaceText(description), closeSoftKeyboard());
    }
    public static void clickButtonSaveAddingNewsControlPanelAddNews(){
        Allure.step("Нажать на кнопку сохранить новость");

        onView(getButtonSaveAddingNewsControlPanelAddNews()).perform(click());
    }
    public static void findNewsWithSpecifiedDescriptionOnListRecycler(String title){
        Allure.step("Найти вновь созданную новость в списке новостей");

        onView(getPageNewsListRecycler()).perform(RecyclerViewActions.scrollTo(hasDescendant(withText(title))));
    }
    public static void addNewNewsWithData(String category, String title, String description){
        Allure.step("Создать и сохранить новость с всеми полями, заполненными валидными значениями с текущей датой и временем");
        clickButtonControlPanel();
        clickButtonControlPanelAddNews();
        enterDataInFieldCategoryControlPanelAddNews(category);
        enterDataInFieldTitleControlPanelAddNews(title);
        choosePublicationDateControlPanelAddNews();
        clickButtonOkInFieldPublicationDateControlPanelAddNews();
        choosePublicationTimeControlPanelAddNews();
        clickButtonOkInFieldPublicationTimeControlPanelAddNews();
        enterDataInFieldDescriptionControlPanelAddNews(description);
        clickButtonSaveAddingNewsControlPanelAddNews();
    }
    public static void addDataInFieldsCreatingNews(String category, String title, String description){
        Allure.step("Заполнить все поля валидными данными");
        clickButtonControlPanel();
        clickButtonControlPanelAddNews();
        enterDataInFieldCategoryControlPanelAddNews(category);
        enterDataInFieldTitleControlPanelAddNews(title);
        choosePublicationDateControlPanelAddNews();
        clickButtonOkInFieldPublicationDateControlPanelAddNews();
        choosePublicationTimeControlPanelAddNews();
        clickButtonOkInFieldPublicationTimeControlPanelAddNews();
        enterDataInFieldDescriptionControlPanelAddNews(description);
    }

    public static void addNewNewsWithoutPublicationDate(String category, String title, String description){
        Allure.step("Заполнить все поля валидными данными, поле Дата публикации оставить пустым");
        clickButtonControlPanel();
        clickButtonControlPanelAddNews();
        enterDataInFieldCategoryControlPanelAddNews(category);
        enterDataInFieldTitleControlPanelAddNews(title);
        choosePublicationTimeControlPanelAddNews();
        clickButtonOkInFieldPublicationTimeControlPanelAddNews();
        enterDataInFieldDescriptionControlPanelAddNews(description);
        clickButtonSaveAddingNewsControlPanelAddNews();
    }
    public static void addNewNewsWithoutPublicationTime(String category, String title, String description){
        Allure.step("Заполнить все поля валидными данными, поле Время публикации оставить пустым");
        clickButtonControlPanel();
        clickButtonControlPanelAddNews();
        enterDataInFieldCategoryControlPanelAddNews(category);
        enterDataInFieldTitleControlPanelAddNews(title);
        choosePublicationDateControlPanelAddNews();
        clickButtonOkInFieldPublicationDateControlPanelAddNews();
        enterDataInFieldDescriptionControlPanelAddNews(description);
        clickButtonSaveAddingNewsControlPanelAddNews();
    }
    public static void addNewNewsWithAllEmptyFields(String category, String title, String description){
        Allure.step("Заполнить все поля валидными значениями, Поля Дата публикации и Время публикации оставить пустыми. Сохранить");
        clickButtonControlPanel();
        clickButtonControlPanelAddNews();
        enterDataInFieldCategoryControlPanelAddNews(category);
        enterDataInFieldTitleControlPanelAddNews(title);
        enterDataInFieldDescriptionControlPanelAddNews(description);
        clickButtonSaveAddingNewsControlPanelAddNews();
    }
    public static void enterDataInFieldsCategoryTitleDescription(String category, String title, String description){
        Allure.step("Заполнить все поля валидными значениями. Поля Дата публикации и Время публикации оставить пустыми");
        clickButtonControlPanel();
        clickButtonControlPanelAddNews();
        enterDataInFieldCategoryControlPanelAddNews(category);
        enterDataInFieldTitleControlPanelAddNews(title);
        enterDataInFieldDescriptionControlPanelAddNews(description);
    }

    public static void emptyCategoryWarningSignIsVisible(){
        Allure.step("Предупреждающий знак присутствует и виден в поле Категория");

        onView(getEmptyCategory()).check(matches(isDisplayed()));
    }
    public static void emptyTitleWarningSignIsVisible(){
        Allure.step("Предупреждающий знак присутствует и виден в поле Заголовок");

        onView(getEmptyTitle()).check(matches(isDisplayed()));
    }
    public static void emptyDescriptionWarningSignIsVisible(){
        Allure.step("Предупреждающий знак присутствует и виден в поле Описание.");

        onView(getEmptyDescription()).check(matches(isDisplayed()));
    }
    public static void emptyPublicationDateWarningSignIsVisible(){
        Allure.step("Предупреждающий знак присутствует и виден в поле Дата публикации");

        onView(getEmptyPublicationDate()).check(matches(isDisplayed()));
    }
    public static void emptyPublicationTimeWarningSignIsVisible(){
        Allure.step("Предупреждающий знак присутствует и виден в поле Время публикации");

        onView(getEmptyPublicationTime()).check(matches(isDisplayed()));
    }
    public static void checkingWarning(String text, boolean visible){
        Allure.step("Проверяем видимость предупреждающего сообщения.");
        if (visible) {
            warningNow(text).check(matches(isDisplayed()));
        } else warningNow(text).check(matches(not(isDisplayed())));
    }
    public static void clickButtonCancelCreatingNews(){
        Allure.step("Нажать на кнопку Отмена сохранения вновь созданной новости");

        onView(getButtonCancel()).perform(click());
    }

    public static void clickButtonCancelAfterButtonCancelCreatingNews(){
        Allure.step("Не подтверждение отмены сохранения новости");

        onView(getButtonCanselAfterButtonCancel()).perform(click());
    }

}
