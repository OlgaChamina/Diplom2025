package ru.iteco.fmhandroid.ui.controlpanel;

import static androidx.test.espresso.matcher.ViewMatchers.withChild;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;



import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.WaitId;

public class ControlPanelPage extends ControlPanelStep {
    public static Matcher<View> getButtonSortingNewsInControlPanel(){
        // сортировка новостей
      return allOf(withId(R.id.sort_news_material_button));
    }
    public static Matcher<View> getButtonFilteredNewsInControlPanel(){
        //фильтрация новостей
        return allOf(withId(R.id.filter_news_material_button));
    }
    public static Matcher<View> getFieldCategoryInFilteredNewsPageInControlPanel(){
        //поле категория на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }
    public static Matcher<View> getFieldDataStartInFilteredNewsPageInControlPanel(){
        //поле дата начала фильтрации на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    }
    public static Matcher<View> getFieldDataEndInFilteredNewsPageInControlPanel() {
        //поле дата окончания фильтрации на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    }
    public static Matcher<View> getCheckBoxActiveInFilteredNewsPageInControlPanel() {
        //чек-бокс активна на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.filter_news_active_material_check_box));
    }
    public static Matcher<View> getCheckBoxNotActiveInFilteredNewsPageInControlPanel() {
        //чек-бокс не активна на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.filter_news_inactive_material_check_box));
    }


    public static Matcher<View> getButtonFilterInFilteredNewsPageInControlPanel() {
        //кнопка фильтровать на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.filter_button), withText("Filter"));
    }



    public static Matcher<View> getButtonCancelFilterInFilteredNewsPageInControlPanel() {
        //кнопка отмена фильтрации на странице фильтрация новостей в панели управления
        return allOf(withId(R.id.cancel_button));
    }




    public static Matcher<View> getButtonDeleteNewsInControlPanel(){
        //удаление новости
        return allOf(withId(R.id.delete_news_item_image_view));
    }
    public static Matcher<View> getButtonOkDeleteNewsInControlPanel(){
        //согласие с удалением новости
        return allOf(withId(android.R.id.button1));
    }
    public static Matcher<View> getButtonChangeDeleteNewsInControlPanel(){
        //не согласие с удалением новости
        return allOf(withId(android.R.id.button2));
    }


    public static Matcher<View> getButtonEditNewsInControlPanel(){
        //кнопка редактировать новость
        return allOf(withId(R.id.edit_news_item_image_view));
    }


    public static Matcher<View> getFieldCategoryEditableNewsInControlPanel(){
        //поле категория на странице редактирования новостей
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }
    public static Matcher<View> getFieldTitleEditableNewsInControlPanel(){
        //поле заголовок на странице редактирования новостей
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }
    public static Matcher<View> getFieldDataEditableNewsInControlPanel(){
        //поле дата публикации на странице редактирования новостей
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }
    public static Matcher<View> getFieldTimeEditableNewsInControlPanel(){
        //поле время на странице редактирования новостей
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }
    public static Matcher<View> getFieldDescriptionEditableNewsInControlPanel(){
        //поле описание на странице редактирования новостей
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public static Matcher<View> getButtonSaveEditableNewsInControlPanel(){
        //кнопка сохранить отредактированную новость
        return allOf(withId(R.id.save_button));
    }
    public static Matcher<View> getButtonCancelSaveEditableNewsInControlPanel(){
        //кнопка отмена на странице редактирование новости
        return allOf(withId(R.id.cancel_button));
    }
    public static Matcher<View> getButtonOkAfterCancelSaveEditableNewsInControlPanel(){
        //кнопка согласия с отменой редактирования новости
        return allOf(withId(android.R.id.button2));
    }
    public static Matcher<View> getButtonCanselAfterCancelSaveEditableNewsInControlPanel(){
        //кнопка отмены сохранения для возвращения к редактируемой новости
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getButtonExpandCollapseDescriptionInControlPanel(){
        // кнопка сворачивания/разворачивания описания
        return allOf(withId(R.id.news_list_recycler_view));
    }
    public static Matcher<View> getclickTitleExpandCollapseDescriptionInControlPanel(){
        //сворачивание/разворачивание описания новости нажатием на заголовок новости
        return allOf(withId(R.id.news_list_recycler_view));
    }
    public static ViewInteraction getButtonDeleteElementOnControlPanel(String title) {
        return WaitId.waitView(allOf(withId(R.id.delete_news_item_image_view), withParent(withParent(allOf(withId(R.id.news_item_material_card_view), withChild(withChild(withText(title))))))));
    }
    public static ViewInteraction getNewsRecyclerList() {
        return WaitId.waitView(withId(R.id.news_list_recycler_view));
    }
}
