package ru.iteco.fmhandroid.ui.controlpanel;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonCancelFilterInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonCancelSaveEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonCanselAfterCancelSaveEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonChangeDeleteNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonDeleteNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonEditNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonExpandCollapseDescriptionInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonFilterInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonFilteredNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonOkAfterCancelSaveEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonOkDeleteNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonSaveEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getButtonSortingNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getCheckBoxActiveInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getCheckBoxNotActiveInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldCategoryEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldCategoryInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldDataEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldDataEndInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldDataStartInFilteredNewsPageInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldDescriptionEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldTimeEditableNewsInControlPanel;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getFieldTitleEditableNewsInControlPanel;
//import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getSliderActiveEditableNewsInControlPanel;
//import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getIconAdvertisement;
import static ru.iteco.fmhandroid.ui.controlpanel.ControlPanelPage.getclickTitleExpandCollapseDescriptionInControlPanel;
import static ru.iteco.fmhandroid.ui.creatingnews.CreatingNewsPage.warningNow;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitElement;
import static ru.iteco.fmhandroid.ui.data.WaitId.waitId;


import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.RecyclerViewActions;

import java.time.LocalDateTime;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class ControlPanelStep {

    // СОРТИРОВКА

    public static void clickSortingNews(){
        Allure.step("Нажать на кнопку сортировка новостей");
        onView(getButtonSortingNewsInControlPanel()).perform(click());
    }


    // ФИЛЬТРАЦИЯ

    public static void clickFilteredNews(){
        Allure.step("Нажать на кнопку фильтровать для перехода на страницу Фильтрации");
        onView(getButtonFilteredNewsInControlPanel()).perform(click());
    }

    public static void selectCategoryInFilteredNews(String category){
        Allure.step("Вписать категорию, по которой будет осуществлятся фильтрация новостей");
        onView(getFieldCategoryInFilteredNewsPageInControlPanel()).perform(click(), replaceText(category), closeSoftKeyboard());
    }
    public static void selectDataStartInFilteredNews(String dataStart){
        Allure.step("Выбрать дату начала фильтрации, по которой будет осуществляться фильтрация новостей");
        onView(getFieldDataStartInFilteredNewsPageInControlPanel()).perform(replaceText(dataStart));

    }
    public static void selectDataEndInFilteredNews(String dataEnd){
        Allure.step("Выбрать дату окончания  фильтрации, по которой будет осуществляться фильтрация новостей");
        onView(getFieldDataEndInFilteredNewsPageInControlPanel()).perform(replaceText(dataEnd));

    }
    public static void selectcheckBoxActiveInFilteredNews(){
        Allure.step("Переключение  статус Активна");
        onView(getCheckBoxActiveInFilteredNewsPageInControlPanel()).perform(click());

    }
    public static void selectcheckBoxNotActiveInFilteredNews(){
        Allure.step("Переключение  статуса не Активна");
        onView(getCheckBoxNotActiveInFilteredNewsPageInControlPanel()).perform(click());

    }
    public static void clickButtonFilterInFilteredNews(){
        Allure.step("Нажать на кнопку Фильтровать");
        onView(getButtonFilterInFilteredNewsPageInControlPanel()).perform(click());
    }

    public static void enterDataFieldCategoryInEditNewsOnContralPanel(String categoryChange){
        Allure.step("Ввести данные в  поле категория на странице редактирования новостей");
        onView(getFieldCategoryEditableNewsInControlPanel()).perform(click(), replaceText(categoryChange), closeSoftKeyboard());
    }
    public static void enterDataFieldDescriptionInEditNewsOnContralPanel(String changeDescription){
        Allure.step("Ввести данные в  поле описание на странице редактирования новостей");
        onView(getFieldDescriptionEditableNewsInControlPanel()).perform(click(), replaceText(changeDescription), closeSoftKeyboard());
    }

    public static void enterDataFieldTitleInEditNewsOnContralPanel(String title) {
        Allure.step("Ввести данные в  поле заголовок на странице редактирования новостей");
        onView(getFieldTitleEditableNewsInControlPanel()).perform(click(), replaceText(title), closeSoftKeyboard());
    }

    public static void clickButtonSaveEditingNewsOnContralPanel(){
        Allure.step("Нажать на кнопку сохранить отредактированную новость");
        onView(getButtonSaveEditableNewsInControlPanel()).perform(click());
    }

    public static void findNewsWithCategoryAdversiment(String title) {
        Allure.step("Проверить, что новости с  категорией Объявление");
        onView(allOf(withId(R.id.news_item_title_text_view), withText(title),
                isDisplayed()));
    }

    public static void findNewsWithStatusNotActive() {
        Allure.step("Проверить, что новости с  категорией Благодарность");
        onView(allOf(withId(R.id.news_item_published_text_view), withText("NOT ACTIVE"),
                withParent(withParent(withId(R.id.news_item_material_card_view))),
                isDisplayed()));
    }
    public static void findNewsWithStatusActive() {
        Allure.step("Проверить, что отображаются новости с  категорией Благодарность");
        onView(allOf(withId(R.id.news_item_published_text_view), withText("ACTIVE"),
                withParent(withParent(withId(R.id.news_item_material_card_view))),
                isDisplayed()));
    }
    public static void findNewsWithSelectData(String selectData) {
        Allure.step("Проверить, что новости с  определенной датой");
        onView(allOf(withId(R.id.news_item_publication_date_text_view), withText(selectData),
                isDisplayed()));
    }

    public static void openNewsCard(String title) {
        Allure.step("Открываем карточку новости");
        checkNewsIsPresent(title);
        getItemNewsEditElement(title).perform(click());
    }
    public static void checkNewsIsPresent(String title) {
        Allure.step("Ищем вновь созданную новость в списке");
        scrollToElementInRecyclerList(title).check(matches(isDisplayed()));
    }
    public static ViewInteraction getItemNewsEditElement(String title) {
        Allure.step("Проверяем новый заголовок новости");
        return onView(allOf(withId(R.id.edit_news_item_image_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));
    }
    public static ViewInteraction getItemNewsEditElementDescription(String description) {
        Allure.step("Проверяем новое описание новости");
        return onView(allOf(withId(R.id.news_item_description_text_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(description))))))));
    }
    public static ViewInteraction getItemNewsEditElementTitle(String title) {
        Allure.step("Проверяем новый заголовок новости");
        return onView(allOf(withId(R.id.news_item_title_text_view),
                withParent(withParent(allOf(withId(R.id.news_item_material_card_view),
                        withChild(withChild(withText(title))))))));
    }

    public static ViewInteraction scrollToElementInRecyclerList(String title) {
        Allure.step("Переходим к нужному элементу");
        return WaitId.waitView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.scrollTo(allOf(
                        hasDescendant(withText(title)))));


    }
    public static ViewInteraction getNewsItemTitle() {
        Allure.step("Проверим, изменился ли заголовок на новый");
        return WaitId.waitView(withId(R.id.news_item_title_text_input_edit_text));
    }



    public static ViewInteraction getNewsCategory() {
        Allure.step("Проверим, изменилась ли категория новости на новую");
        return WaitId.waitView(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static void deleteNewsOnControlPanel(String title) {
        Allure.step("Удаляем вновь созданную новость");
        scrollToElementInRecyclerList(title);
        ControlPanelPage.getButtonDeleteElementOnControlPanel(title).check(matches(isDisplayed())).perform(click());
        WaitId.waitView(withText("Are you sure you want to permanently delete the document? These changes cannot be reversed in the future.")).check(matches(isDisplayed()));
        WaitId.waitView(getButtonOkDeleteNewsInControlPanel()).perform(click());
    }


    public static void checkNewsDoesNotPresent(String title) {
        Allure.step("Проверяем, что новость с таким названием удалилась");
        ControlPanelPage.getNewsRecyclerList()
                .check(matches(DataHelper.RecyclerViewMatcher
                        .matchChildViewIsNotExist((R.id.news_item_title_text_view), withText(title))));
    }
    public static void isItControlPanelPage() {
        Allure.step("Проверяем, находимся ли на странице Панель управления");
        WaitId.waitView(withText("Control panel")).check(matches(isDisplayed()));

    }

   public static void checkingWarning(String text, boolean visible){
        Allure.step("Проверяем видимость предупреждающего знака");
        if (visible) {
            warningNow(text).check(matches(isDisplayed()));
        } else warningNow(text).check(matches(not(isDisplayed())));
    }
}
