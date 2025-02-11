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
import ru.iteco.fmhandroid.ui.auth.AuthPage;
import ru.iteco.fmhandroid.ui.auth.AuthStep;
import ru.iteco.fmhandroid.ui.controlpanel.ControlPanelStep;
import ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsStep;
import ru.iteco.fmhandroid.ui.news.NewsStep;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)
@Epic("Тест-кейсы для проведения  тестирования страницы Создания новости в приложении В хосписе")

public class CreatingNewsFormTest {
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
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Зарплата")
    public void creatingNewsWithCategorySalary() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Зарплата", "премия", "Много");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("премия");
        ControlPanelStep.deleteNewsOnControlPanel("премия");
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Праздник")
    public void creatingNewsWithCategoryHoliday() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Праздник", "8 Марта!", "Поздравляем!");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("8 Марта!");
        ControlPanelStep.deleteNewsOnControlPanel("8 Марта!");

    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Обьявление")
    public void creatingNewsWithCategoryAdvertisement() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Объявление", "Требуется медсестра!", "Обратиться в кабинет №4");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("Требуется медсестра!");
        ControlPanelStep.deleteNewsOnControlPanel("Требуется медсестра!");

    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией День рождения")
    public void creatingNewsWithCategoryBirthday() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("День рождения", "Юбилей!", "23 марта");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("Юбилей!");
        ControlPanelStep.deleteNewsOnControlPanel("Юбилей!");

    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Профсоюз")
    public void creatingNewsWithCategoryTradeUnion() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Профсоюз", "Обратите внимание!", "Собрание состоится");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("Обратите внимание!");
        ControlPanelStep.deleteNewsOnControlPanel("Обратите внимание!");
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Массаж")
    public void creatingNewsWithCategoryMassage() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж", "Изменение расписания!", "Теперь по вторникам");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("Изменение расписания!");
        ControlPanelStep.deleteNewsOnControlPanel("Изменение расписания!");
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Благодарность")
    public void creatingNewsWithCategoryGratitude() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Благодарность", "Благодарность!", "Важно");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("Благодарность!");
        ControlPanelStep.deleteNewsOnControlPanel("Благодарность!");
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными с категорией Нужна помощь")
    public void creatingNewsWithCategoryNeedHelp() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Нужна помощь", "Срочно!", "Очень срочно");
        CreatingNewsStep.findNewsWithSpecifiedDescriptionOnListRecycler("Срочно!");
        ControlPanelStep.deleteNewsOnControlPanel("Срочно!");
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными, но с пустым полем категория ")
    public void creatingNewsWithCategoryEmpty() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("", "Срочно", "Очень срочно");
        CreatingNewsStep.emptyCategoryWarningSignIsVisible();
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными, но с пустым полем Название ")
    public void creatingNewsWithTitleEmpty() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Нужна помощь", "", "Очень срочно");
        CreatingNewsStep.emptyTitleWarningSignIsVisible();
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными, но с пустым полем Описание ")
    public void creatingNewsWithDescriptionEmpty() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Нужна помощь", "Срочно", "");
        CreatingNewsStep.emptyDescriptionWarningSignIsVisible();
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными, но с пустым полем Дата публикации ")
    public void creatingNewsWithPublicationDateEmpty() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithoutPublicationDate("Нужна помощь", "Срочно", "Очень");
        CreatingNewsStep.emptyPublicationDateWarningSignIsVisible();
    }

    @Test
    @Description("Создание новости со всеми полями, заполненными валидными данными, но с пустым полем Время публикации ")
    public void creatingNewsWithPublicationTimeEmpty() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithoutPublicationTime("Нужна помощь", "Срочно", "Очень");
        CreatingNewsStep.emptyPublicationTimeWarningSignIsVisible();
    }

    @Test
    @Description("Создание новости со всеми пустыми полями")
    public void creatingNewsWithAllEmptyFields() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithAllEmptyFields("", "", "");
        CreatingNewsStep.emptyCategoryWarningSignIsVisible();
        CreatingNewsStep.emptyTitleWarningSignIsVisible();
        CreatingNewsStep.emptyPublicationDateWarningSignIsVisible();
        CreatingNewsStep.emptyPublicationTimeWarningSignIsVisible();
        CreatingNewsStep.emptyDescriptionWarningSignIsVisible();
    }

    @Test
    @Description("Создание новости с несуществующей Категорией в раскрывающемся списке категорией")
    public void creatingNewsWithNonExistentCategory() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Новый Год", "Праздник", "Скоро");
        CreatingNewsStep.checkingWarning("Saving failed. Try again later.", true);

    }

    @Test
    @Description("Создание новости с численными данными в поле  категория")
    public void creatingNewsWithNumbersInCategoryField() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("123456789", "Праздник", "Скоро");
        CreatingNewsStep.checkingWarning("Saving failed. Try again later.", true);

    }

    @Test
    @Description("Создание новости с символьными данными в поле  категория")
    public void creatingNewsWithSpecialSymbolsInCategoryField() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("$&**@!", "Праздник", "Скоро");
        CreatingNewsStep.checkingWarning("Saving failed. Try again later.", true);
    }

    @Test
    @Description("Отмена отмены сохранения вновь созданной новости")
    public void cancelCancelCreatingNews() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addDataInFieldsCreatingNews("Массаж", "Праздник", "Скоро");
        CreatingNewsStep.clickButtonCancelCreatingNews();
        CreatingNewsStep.clickButtonCancelAfterButtonCancelCreatingNews();

    }

    // проверка поля TITLE
    @Test
    @Description("Создание новости с численными данными в поле  Заголовок(негативный)")
    public void creatingNewsWithNumbersInTitleField() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж", "12345678", "Скоро");
        CreatingNewsStep.checkingWarning("A field cannot contain only numeric values", true);

    }

    @Test
    @Description("Создание новости с символьными данными в поле  Заголовок(негативный)")
    public void creatingNewsWithSpecialSymbolsInTitleField() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж", "%%;№*(", "Скоро");
        CreatingNewsStep.checkingWarning("A field cannot contain only numeric values", true);
    }

    // проверка поля описание
    @Test
    @Description("Создание новости с только с численными данными в поле  Описание(негативный)")
    public void creatingNewsWithNumbersInDescriptionField() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж", "Скоро", "123456789");
        CreatingNewsStep.checkingWarning("A field cannot contain only numeric values", true);

    }

    @Test
    @Description("Создание новости с символьными данными в поле  Описание(негативный)")
    public void creatingNewsWithSpecialSymbolsInDescriptionField() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.addNewNewsWithData("Массаж", "Скоро", "%:?№;%*");
        CreatingNewsStep.checkingWarning("A field cannot contain only numeric values", true);
    }
    @Test
    @Description("Создание новости с датой публикации в прошлом времени (негативный)")
    public void creatingNewsWithLastYearInDataPublication() {
        NewsStep.clickButtonAllNews();
        CreatingNewsStep.enterDataInFieldsCategoryTitleDescription("Массаж","очень хороший", "Массаж");
        CreatingNewsStep.enterDataInPublicationDateControlPanelAddNews("20.03.2022");
        CreatingNewsStep.choosePublicationTimeControlPanelAddNews();
        CreatingNewsStep.clickButtonOkInFieldPublicationTimeControlPanelAddNews();
        CreatingNewsStep.clickButtonSaveAddingNewsControlPanelAddNews();
        CreatingNewsStep.checkingWarning("The publication date cannot be in the past tense.", true);
    }
}










