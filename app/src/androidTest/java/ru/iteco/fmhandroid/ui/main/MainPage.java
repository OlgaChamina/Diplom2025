package ru.iteco.fmhandroid.ui.main;

import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class MainPage extends MainStep {
    public static Matcher<View> getButtonAllNewsClick()
    {
        return withId(R.id.all_news_text_view);
    }

    public static Matcher<View> getButtonMainMenu() {
        return allOf(withId(R.id.main_menu_image_button));
    }
    public static Matcher<View> getButtonNewsInMainMenu(){
        return allOf((withId(android.R.id.title)), withText("News"));
    }
    public static Matcher<View> getButtonAboutInMainMenu(){
        return allOf((withId(android.R.id.title)), withText("About"));
    }


}
