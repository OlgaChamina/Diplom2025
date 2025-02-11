package ru.iteco.fmhandroid.ui.news;


import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.is;




import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class NewsPage extends NewsStep {
    public static Matcher<View> getAllNewsButton(){
        return allOf(withId(R.id.all_news_text_view));
    }
    public static Matcher<View> getDeploymentNewsButton(){
        return allOf(withId(R.id.expand_material_button));
    }
    public static Matcher<View> getSortingNewsButton(){
        return allOf(withId(R.id.sort_news_material_button));
    }
    public static Matcher<View> getFilterNewsButton(){
        return allOf(withId(R.id.filter_news_material_button));
    }
    public static Matcher<View> getInFilterNewsChooseCategoryField(){
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> getInFilterNewsChooseStartDateField(){
        return allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    }
    public static Matcher<View> getInFilterNewsChooseStartDateFieldClickOk(){
        return allOf(withId(android.R.id.button1));
    }
    public static Matcher<View> getInFilterNewsChooseFinishDateField(){
        return allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    }
    public static Matcher<View> getInFilterNewsChooseFinishDateFieldClickOk(){
        return allOf(withId(android.R.id.button1));
    }
    public static Matcher<View> getInFilterNewsClickFilterButton(){
        return allOf(withId(R.id.filter_button));
    }
    public static Matcher<View> getInMainMenuFieldMain(){
        return allOf((withId(android.R.id.title)), withText("Main"));
    }

}
