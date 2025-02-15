package ru.iteco.fmhandroid.ui.creatingnews;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class CreatingNewsPage extends CreatingNewsStep {
    public static Matcher<View> getButtonControlPanel(){
        return allOf(withId(R.id.edit_news_material_button));
    };
    public static Matcher<View> getButtonControlPanelAddNews(){
        return allOf(withId(R.id.add_news_image_view));
    }
    public static Matcher<View> getFieldCategoryControlPanelAddNews(){
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }
    public static Matcher<View> getFieldTitleControlPanelAddNews(){
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }
    public static Matcher<View> getFieldPublicationDateControlPanelAddNews(){
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }
    public static Matcher<View> getButtonOkInFieldPublicationDateControlPanelAddNews(){
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getFieldPublicationTimeControlPanelAddNews(){
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }
    public static Matcher<View> getButtonOkInFieldPublicationTimeControlPanelAddNews(){
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getFieldDescriptionControlPanelAddNews(){
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }
    public static Matcher<View> getButtonSaveAddingNewsControlPanelAddNews(){
        return allOf(withId(R.id.save_button));
    }
    public static Matcher<View> getPageNewsListRecycler(){
        return allOf(withId(R.id.news_list_recycler_view));
    }
    public static Matcher<View> getEmptyCategory(){
        return allOf(withId(R.id.text_input_start_icon), withParent(withParent(withParent(withId(R.id.news_item_category_text_input_layout)))));
    }
    public static Matcher<View> getEmptyTitle(){
        return allOf(withId(R.id.text_input_end_icon), withParent(withParent(withParent(withParent(withId(R.id.news_item_title_text_input_layout))))));
    }
    public static Matcher<View> getEmptyDescription(){
        return allOf(withId(R.id.text_input_end_icon), withParent(withParent(withParent(withParent(withId(R.id.news_item_description_text_input_layout))))));
    }
    public static Matcher<View> getEmptyPublicationDate(){
        return allOf(withId(R.id.text_input_end_icon), withParent(withParent(withParent(withParent(withId(R.id.news_item_create_date_text_input_layout))))));
    }
    public static Matcher<View> getEmptyPublicationTime(){
        return allOf(withId(R.id.text_input_end_icon), withParent(withParent(withParent(withParent(withId(R.id.news_item_publish_time_text_input_layout))))));
    }
    public static ViewInteraction warningNow(String text) {
    return onView(withText(text)).inRoot(new DataHelper.ToastMatcher());
    }
    public static Matcher<View> getButtonCancel(){
        return allOf(withId(R.id.cancel_button), withText("Cancel"));
    }
    public static Matcher<View> getButtonOkAfterButtonCancel(){
        return allOf(withId(android.R.id.button1));
    }
    public static Matcher<View> getButtonCanselAfterButtonCancel(){
        return allOf(withId(android.R.id.button2), withText("Cancel"));
    }




}
